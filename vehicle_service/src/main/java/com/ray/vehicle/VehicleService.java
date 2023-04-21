package com.ray.vehicle;

import com.ray.vehicle.entity.VehicleCategoryEntity;
import com.ray.vehicle.entity.VehicleEntity;
import com.ray.vehicle.grpc.CategoryFilter;
import com.ray.vehicle.grpc.Vehicle;
import com.ray.vehicle.grpc.VehicleCategory;
import com.ray.vehicle.grpc.VehicleFilter;
import com.ray.vehicle.util.Utility;
import com.ray.vehicle.util.email.EmailUtil;
import com.ray.vehicle.util.hibernate.EntityService;
import com.ray.vehicle.util.hibernate.HibernateUtil;
import com.ray.vehicle.util.user.UserUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.query.Query;

import java.util.Optional;
import java.util.stream.Stream;

public class VehicleService {
    private static final Logger LOG = LogManager.getLogger(VehicleService.class);
    private static final EntityService<VehicleEntity> vehicleService = new EntityService<>(VehicleEntity.class);
    private static final EntityService<VehicleCategoryEntity> categoryService = new EntityService<>(VehicleCategoryEntity.class);

    public Optional<Vehicle> addVehicle(Vehicle vehicle) {
        try {
            validateVehicle(vehicle);
            if (getVehicleByPlateNoOrId(vehicle.getPlateNo(), vehicle.getId()).isPresent())
                throw new RuntimeException("Vehicle with plateNo already exists");
            var user = UserUtil.getUser(vehicle.getOwnerEmail()).orElse(null);
            if (user == null) throw new RuntimeException("Invalid owner");
            var vehicleEntity = VehicleEntity.getInstance(vehicle);
            vehicleEntity.setOwnerEmail(user.getEmail());
            vehicleEntity.setOwnerName(user.getName());
            var category = vehicle.getCategory();
            if (category.getId() > 0 || !Utility.isEmpty(category.getDescription())) {
                var categoryEntity = categoryService.getById(category.getId()).orElse(new VehicleCategoryEntity(category.getName(), category.getDescription()));
                vehicleEntity.setVehicleCategory(categoryEntity);
            }
            vehicleService.save(vehicleEntity);
            EmailUtil.sendEmail("Vehicle created", user.getEmail(),
                    String.format("Vehicle with plate number %s has been created for you on Ray app", vehicleEntity.getPlateNo()));
            return Optional.of(VehicleEntity.getVehicle(vehicleEntity, false));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
            return Optional.of(Vehicle.newBuilder().setError(e.getMessage()).build());
        }
    }

    public Stream<Vehicle> getVehicles(VehicleFilter filter) {
        try {
            var session = HibernateUtil.getSession();
            if (filter.getByDateAdded()) {
                var query = session.createQuery("from Vehicle order by createdAt desc", VehicleEntity.class).setMaxResults(filter.getLimit());
                return query.getResultStream().map(v -> VehicleEntity.getVehicle(v, true));
            }
            if (filter.getByRating()) {
                var query = session.createQuery("from Vehicle order by rating desc", VehicleEntity.class).setMaxResults(filter.getLimit());
                return query.getResultStream().map(v -> VehicleEntity.getVehicle(v, true));
            }
            if (Utility.isNotEmpty(filter.getCategoryName())) {
                var query = session.createQuery("from Vehicle v join v.vehicleCategory vc where vc.name = :name", VehicleEntity.class)
                        .setParameter("name", filter.getCategoryName()).setMaxResults(filter.getLimit());
                return query.getResultStream().map(v -> VehicleEntity.getVehicle(v, true));
            }
            var query = session.createQuery("from  Vehicle v join v.vehicleCategory vc where (v.model like %:query% or v.plateNo like %:query% or " +
                            "v.make like %:query% or v.color like %:query% or v.ownerEmail like %:query% or v.ownerName like %:query%" +
                            " or v.engineType like %:query% or v.fuelType like %:query% or v.transmission like %:query%" +
                            " or vc.name like %:query% or vc.ownerEmail like %:query%) and v.status = 'active'", VehicleEntity.class)
                    .setParameter("query", filter.getQuery());
            return query.getResultStream().map(v -> VehicleEntity.getVehicle(v, true));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Stream.of();
    }

    public Stream<VehicleCategory> getCategories(CategoryFilter filter) {
        try {
            var session = HibernateUtil.getSession();
            if (Utility.isEmpty(filter.getQuery())) {
                return categoryService.getAll(filter.getLimit()).map(category -> VehicleCategoryEntity.getCategory(category, true));
            }
            var query = session.createQuery("from  VehicleCategory where name like %:query% or ownerEmail like %:query%", VehicleCategoryEntity.class)
                    .setParameter("query", filter.getQuery());
            return query.getResultStream().map(c -> VehicleCategoryEntity.getCategory(c, true));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Stream.of();
    }

    public Optional<Vehicle> update(Vehicle vehicle) {
        try {
            validateVehicle(vehicle);
            var savedVehicle = getVehicleByPlateNoOrId(vehicle.getPlateNo(), vehicle.getId()).orElse(null);
            if (savedVehicle == null)
                throw new RuntimeException(String.format("Vehicle [%d, %s] not found", vehicle.getId(), vehicle.getPlateNo()));
            VehicleEntity.updateInstance(vehicle, savedVehicle);
            categoryService.getById(vehicle.getCategory().getId()).ifPresent(savedVehicle::setVehicleCategory);
            vehicleService.update(savedVehicle);
            return Optional.of(VehicleEntity.getVehicle(savedVehicle, false));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
            return Optional.of(Vehicle.newBuilder().setError(e.getMessage()).build());
        }
    }

    public Optional<VehicleCategory> addCategory(VehicleCategory category) {
        try {
            if (Utility.isEmpty(category.getName())) throw new RuntimeException("Category name cannot be empty");
            var savedCategory = getCategoryByName(category.getName()).orElse(null);
            if (savedCategory != null) throw new RuntimeException("Category with name already exists");

            savedCategory = VehicleCategoryEntity.getInstance(category);
            categoryService.save(savedCategory);
            return Optional.of(VehicleCategoryEntity.getCategory(savedCategory, false));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
            return Optional.of(VehicleCategory.newBuilder().setError(e.getMessage()).build());
        }
    }

    public Optional<Vehicle> getVehicle(Vehicle vehicle) {
        try {
            return getVehicleByPlateNoOrId(vehicle.getPlateNo(), vehicle.getId()).map(v -> VehicleEntity.getVehicle(v, true));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Optional.of(Vehicle.getDefaultInstance());
    }

    public Vehicle confirmAvailability(Vehicle vehicle) {
        try {
            var savedVehicle = getVehicleByPlateNoOrId(vehicle.getPlateNo(), vehicle.getId()).orElseThrow();
            return VehicleEntity.getVehicle(savedVehicle, false);
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Vehicle.getDefaultInstance();
    }

    private Optional<VehicleEntity> getVehicleByPlateNoOrId(String plateNo, Integer id) {
        var optionalVehicle = vehicleService.getById(id);
        if (optionalVehicle.isPresent()) return optionalVehicle;

        var session = HibernateUtil.getSession();
        var query = session.createQuery("from Vehicle where plateNo = :plateNo", VehicleEntity.class)
                .setParameter("plateNo", plateNo);
        var savedVehicle = getSingleVehicle(query);
        session.close();
        return savedVehicle != null ? Optional.of(savedVehicle) : Optional.empty();
    }

    private VehicleEntity getSingleVehicle(Query<VehicleEntity> query) {
        try {
            return (VehicleEntity) query.getSingleResult();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    private VehicleCategoryEntity getSingleCategory(Query<VehicleCategoryEntity> query) {
        try {
            return (VehicleCategoryEntity) query.getSingleResult();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    private Optional<VehicleCategoryEntity> getCategoryByName(String name) {
        var session = HibernateUtil.getSession();
        var query = session.createQuery("from VehicleCategory where name = :name", VehicleCategoryEntity.class)
                .setParameter("name", name);
        var savedCategory = getSingleCategory(query);
        session.close();
        return savedCategory != null ? Optional.of(savedCategory) : Optional.empty();
    }

    private void validateVehicle(Vehicle vehicle) throws RuntimeException {
        if (!Utility.isValidPlateNumber(vehicle.getPlateNo())) throw new RuntimeException("Invalid plateNo");
        if (Utility.isInvalidEmail(vehicle.getOwnerEmail())) throw new RuntimeException("Invalid owner");
    }
}

package com.ray.vehicle;

import com.ray.vehicle.entity.VehicleCategoryEntity;
import com.ray.vehicle.entity.VehicleEntity;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            var categoryEntity = categoryService.getById(category.getId()).orElse(new VehicleCategoryEntity(category.getName(), category.getDescription()));
            vehicleEntity.setVehicleCategory(categoryEntity);
            vehicleService.save(vehicleEntity);
            EmailUtil.sendEmail("Vehicle created", user.getEmail(),
                    String.format("Vehicle with plate number %s has been created for you on Ray app", vehicleEntity.getPlateNo()));
            return Optional.of(VehicleEntity.getVehicle(vehicleEntity, false));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public List<Vehicle> getVehicles(VehicleFilter filter) {
        return new ArrayList<>();
    }

    public List<VehicleCategory> getCategories() {
        return categoryService.getAll().stream().map(category -> VehicleCategoryEntity.getCategory(category, true)).collect(Collectors.toList());
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
        }
        return Optional.empty();
    }

    public Optional<VehicleCategory> addCategory(VehicleCategory category) {
        try {
            if (Utility.isEmpty(category.getName())) throw new RuntimeException("Category name cannot be empty");
            var savedCategory = getCategoryByName(category.getName()).orElse(null);
            if (savedCategory == null) throw new RuntimeException("Category with name already exists");

            savedCategory = VehicleCategoryEntity.getInstance(category);
            categoryService.save(savedCategory);
            return Optional.of(VehicleCategoryEntity.getCategory(savedCategory, false));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public Optional<Vehicle> getVehicle(Vehicle vehicle) {
        try {
            return getVehicleByPlateNoOrId(vehicle.getPlateNo(), vehicle.getId()).map(v -> VehicleEntity.getVehicle(v, true));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
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
        var savedVehicle = (VehicleEntity) query.getSingleResult();
        session.close();
        return savedVehicle != null ? Optional.of(savedVehicle) : Optional.empty();
    }

    private Optional<VehicleCategoryEntity> getCategoryByName(String name) {
        var session = HibernateUtil.getSession();
        var query = session.createQuery("from VehicleCategory where name = :name", VehicleCategoryEntity.class)
                .setParameter("name", name);
        var savedCategory = (VehicleCategoryEntity) query.getSingleResult();
        session.close();
        return savedCategory != null ? Optional.of(savedCategory) : Optional.empty();
    }

    private void validateVehicle(Vehicle vehicle) throws RuntimeException {
        if (Utility.isValidPlateNumber(vehicle.getPlateNo())) throw new RuntimeException("Invalid plateNo");
        if (Utility.isInvalidEmail(vehicle.getOwnerEmail())) throw new RuntimeException("Invalid owner");
    }
}

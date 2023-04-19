package com.ray.app.util.vehicle;


import com.google.protobuf.Empty;
import com.ray.app.grpc.*;
import com.ray.app.util.auth.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.ServiceInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.ray.app.Main.getAuth;

public class VehicleUtil {
    private VehicleUtil() {}

    private static final Logger LOG = LogManager.getLogger(VehicleUtil.class);
    private static VehicleServiceGrpc.VehicleServiceBlockingStub serviceStub;
    @SuppressWarnings("deprecation")
    public static void setServiceStub(ServiceInfo info) {
        LOG.info("IP Resolved for vehicle_service - " + info.getPort() + ":" + info.getHostAddress());
        ManagedChannel channel = ManagedChannelBuilder.forAddress(info.getHostAddress(), info.getPort()).usePlaintext().build();
        serviceStub = VehicleServiceGrpc.newBlockingStub(channel);
    }

    public static Optional<Vehicle> createOrUpdateVehicle(Vehicle vehicle) {
        if (serviceStub != null) {
            try {
                if (vehicle.getId() > 0) {
                    vehicle = serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken)).update(vehicle);
                } else {
                    vehicle = serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken)).addVehicle(vehicle);
                }
            return vehicle != null ? Optional.of(vehicle) : Optional.empty();
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        }
        return Optional.empty();
    }

    public static Optional<VehicleCategory> createCategory(VehicleCategory category) {
        if (serviceStub != null) {
            try {
                category = serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken)).addCategory(category);
                return category != null ? Optional.of(category) : Optional.empty();
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        }
        return Optional.empty();
    }

    public static Iterator<VehicleCategory> getCategories(CategoryFilter filter) {
        if (serviceStub != null) {
            try {
                return serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken))
                        .getCategories(filter);
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        }
        return null;
    }

    public static Iterator<Vehicle> getVehicles(VehicleFilter filter) {
        if (serviceStub != null) {
            try {
                return serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken))
                        .getVehicles(filter);
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        }
        return null;
    }

    public static void removeVehicleStub() {
        serviceStub = null;
    }
}

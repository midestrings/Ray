package com.ray.app.util.vehicle;


import com.google.protobuf.Empty;
import com.ray.app.grpc.*;
import com.ray.app.util.auth.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.ServiceInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.ray.app.Main.getAuth;
import static com.ray.app.controller.BaseController.showErrorAlert;

public class VehicleUtil {
    private VehicleUtil() {}

    private static final Logger LOG = LogManager.getLogger(VehicleUtil.class);
    private static VehicleServiceGrpc.VehicleServiceBlockingStub serviceStub;
    private static int port = 0;
    private static String host = "";
    @SuppressWarnings("deprecation")
    public static void setServiceStub(ServiceInfo info) {
        LOG.info("IP Resolved for vehicle_service - " + info.getPort() + ":" + info.getHostAddress());
        ManagedChannel channel = ManagedChannelBuilder.forAddress(info.getHostAddress(), info.getPort()).usePlaintext().build();
        serviceStub = VehicleServiceGrpc.newBlockingStub(channel);
        port = info.getPort();
        host = info.getHostAddress();
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
        } else {
            Platform.runLater(() -> showErrorAlert("Vehicle service isn't reachable"));
        }
        return Optional.empty();
    }

    public static VehicleServiceGrpc.VehicleServiceStub createCategory() {
        if (serviceStub != null) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        return VehicleServiceGrpc.newStub(channel).withCallCredentials(new BearerToken(getAuth()::getToken));
        } else {
            Platform.runLater(() -> showErrorAlert("Vehicle service isn't reachable"));
        }
        return null;
    }

    public static Iterator<VehicleCategory> getCategories(CategoryFilter filter) {
        if (serviceStub != null) {
            try {
                return serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken))
                        .getCategories(filter);
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        } else {
            Platform.runLater(() -> showErrorAlert("Vehicle service isn't reachable"));
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
        } else {
            Platform.runLater(() -> showErrorAlert("Vehicle service isn't reachable"));
        }
        return null;
    }
    public static Optional<Vehicle> getVehicle(Vehicle vehicle) {
        if (serviceStub != null) {
            try {
                return Optional.of(serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken))
                        .getVehicle(vehicle));
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        } else {
            Platform.runLater(() -> showErrorAlert("Vehicle service isn't reachable"));
        }
        return Optional.empty();
    }

    public static void removeVehicleStub() {
        serviceStub = null;
    }
}

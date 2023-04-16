package com.ray.app.util.vehicle;


import com.ray.app.grpc.Vehicle;
import com.ray.app.grpc.VehicleServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.ServiceInfo;
import java.util.Optional;

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

    public static Optional<Vehicle> confirmVehicleAvailability(int vehicleId) {
        if (serviceStub != null) {
            var vehicle = Vehicle.newBuilder().setId(vehicleId).build();
            vehicle = serviceStub.confirmAvailability(vehicle);
            if (vehicle.getIsAvailableForRent() || vehicle.getIsAvailableForRideHailing()) {
                return Optional.of(Vehicle.newBuilder().setId(vehicle.getId()).setPlateNo(vehicle.getPlateNo()).build());
            }
        }
        return Optional.empty();
    }

    public static void removeVehicleStub() {
        serviceStub = null;
    }
}
package com.ray.schedule.util.vehicle;

import com.ray.schedule.grpc.Vehicle;
import com.ray.schedule.grpc.VehicleServiceGrpc;
import com.ray.schedule.util.Utility;
import com.ray.schedule.util.auth.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.ServiceInfo;
import java.util.Optional;

public class VehicleUtil {
    private VehicleUtil() {
    }

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
            vehicle = serviceStub
                    .withCallCredentials(new BearerToken(Utility::generateToken))
                    .confirmAvailability(vehicle);
            if (vehicle.getIsAvailableForRent() || vehicle.getIsAvailableForRideHailing()) {
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }


    public static Optional<Vehicle> updateVehicle(Vehicle vehicle) {
        if (serviceStub != null) {
            try {
                return Optional.of(serviceStub.withCallCredentials(new BearerToken(Utility::generateToken)).update(vehicle));
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        }
        return Optional.empty();
    }

    public static void removeVehicleStub() {
        serviceStub = null;
    }
}

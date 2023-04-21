package com.ray.app.util.schedule;


import com.ray.app.grpc.Reservation;
import com.ray.app.grpc.ReservationFilter;
import com.ray.app.grpc.ScheduleServiceGrpc;
import com.ray.app.grpc.VehicleCategory;
import com.ray.app.util.auth.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.ServiceInfo;
import java.util.Iterator;
import java.util.Optional;

import static com.ray.app.Main.getAuth;

public class ScheduleUtil {
    private ScheduleUtil() {}

    private static final Logger LOG = LogManager.getLogger(ScheduleUtil.class);
    private static ScheduleServiceGrpc.ScheduleServiceBlockingStub serviceStub;
    @SuppressWarnings("deprecation")
    public static void setServiceStub(ServiceInfo info) {
        LOG.info("IP Resolved for schedule_service - " + info.getPort() + ":" + info.getHostAddress());
        ManagedChannel channel = ManagedChannelBuilder.forAddress(info.getHostAddress(), info.getPort()).usePlaintext().build();
        serviceStub = ScheduleServiceGrpc.newBlockingStub(channel);
    }



    public static Optional<Reservation> createReservation(Reservation reservation) {
        if (serviceStub != null) {
            try {
                reservation = serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken)).createReservation(reservation);
                return reservation != null ? Optional.of(reservation) : Optional.empty();
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        }
        return Optional.empty();
    }

    public static Iterator<Reservation> getReservations(ReservationFilter filter) {
        if (serviceStub != null) {
            try {
                return serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken)).getReservations(filter);
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        }
        return null;
    }


    public static void removeScheduleStub() {
        serviceStub = null;
    }
}

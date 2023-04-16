package com.ray.schedule;

import com.ray.schedule.grpc.Reservation;
import com.ray.schedule.grpc.ReservationFilter;
import com.ray.schedule.grpc.ScheduleServiceGrpc;
import com.ray.schedule.util.auth.AuthorizationServerInterceptor;
import com.ray.schedule.util.email.EmailUtil;
import com.ray.schedule.util.user.UserUtil;
import com.ray.schedule.util.vehicle.VehicleUtil;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class ReservationServer extends ScheduleServiceGrpc.ScheduleServiceImplBase {
    private static final Logger LOG = LogManager.getLogger(ReservationServer.class);
    private static final Properties properties = new Properties();
    private static final String host = "_http._tcp.local.";// = "localhost";
    private static final ReservationService service = new ReservationService();
    public static void main( String[] args ) {
        loadConfig(args);
        Server server = null;
		try {
			server = ServerBuilder.forPort(Integer.parseInt(properties.getProperty("port")))
                    .addService(new ReservationServer())
                    .intercept(new AuthorizationServerInterceptor())
                    .build().start();
			LOG.info("Server started....");
            registerAndDiscoverServices();
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
            if (server != null) {
                server.shutdown();
            }
            LOG.error(e.getMessage(), e);
		}
    }


    @Override
    public void createReservation(Reservation request, StreamObserver<Reservation> responseObserver) {
        service.create(request).ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getReservations(ReservationFilter request, StreamObserver<Reservation> responseObserver) {
        service.getReservations(request).forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void updateReservation(Reservation request, StreamObserver<Reservation> responseObserver) {
        service.update(request).ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getReservation(Reservation request, StreamObserver<Reservation> responseObserver) {
        service.getReservation(request).ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    private static void loadConfig(String[] args) {
        var propertyFile = "/application.properties";
        if (args.length > 0 && args[0].equalsIgnoreCase("dev")) {
            propertyFile = "/application-dev.properties";
        }
        try (InputStream is = ReservationServer.class.getResourceAsStream(propertyFile)) {
            properties.load(is);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static void registerAndDiscoverServices() {
        JmDNS jmdns = null;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create(host, "schedule_service", Integer.parseInt(properties.getProperty("port")), "path=index.html");
            jmdns.registerService(serviceInfo);
            jmdns.addServiceListener(host, new ScheduleServiceListener());

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            if (jmdns != null) {
                jmdns.unregisterAllServices();
            }
        }
    }

    public static Properties getProperties() {
        return properties;
    }

    private static class ScheduleServiceListener implements ServiceListener {
        public void serviceAdded(ServiceEvent event) {
            LOG.info("Service added: " + event.getInfo());
        }
        public void serviceRemoved(ServiceEvent event) {
            LOG.info("Service removed: " + event.getInfo());
            if (event.getInfo().getName().equals("email_service")) {
                EmailUtil.removeMailerStub();
            } else if (event.getInfo().getName().equals("user_service")) {
                UserUtil.removeUserStub();
            } else if (event.getInfo().getName().equals("vehicle_service")) {
                VehicleUtil.removeVehicleStub();
            }
        }
        public void serviceResolved(ServiceEvent event) {
            LOG.info("Service resolved: " + event.getInfo());
            ServiceInfo info = event.getInfo();
            if (info.getName().equals("email_service")) {
                EmailUtil.setMailerStub(info);
            } else if (info.getName().equals("user_service")) {
                UserUtil.setServiceStub(info);
            } else if (info.getName().equals("vehicle_service")) {
                VehicleUtil.setServiceStub(info);
            }
        }
    }
}

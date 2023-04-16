package com.ray.vehicle;

import com.ray.vehicle.grpc.*;
import com.ray.vehicle.util.auth.AuthorizationServerInterceptor;
import com.ray.vehicle.util.email.EmailUtil;
import com.ray.vehicle.util.user.UserUtil;
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
 */
public class VehicleServer extends VehicleServiceGrpc.VehicleServiceImplBase {
    private static final Logger LOG = LogManager.getLogger(VehicleServer.class);
    private static final Properties properties = new Properties();
    private static final String host = "_http._tcp.local.";// = "localhost";
    private final VehicleService service = new VehicleService();


    public static void main(String[] args) {
        loadConfig(args);
        Server server = null;
		try {
			server = ServerBuilder.forPort(Integer.parseInt(properties.getProperty("port")))
                    .addService(new VehicleServer())
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
    public void addVehicle(Vehicle request, StreamObserver<Vehicle> responseObserver) {
        service.addVehicle(request).ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getVehicles(VehicleFilter request, StreamObserver<Vehicle> responseObserver) {
        service.getVehicles(request).forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void update(Vehicle request, StreamObserver<Vehicle> responseObserver) {
        service.update(request).ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<VehicleCategory> addCategory(StreamObserver<VehicleCategory> responseObserver) {
        return new StreamObserver<VehicleCategory>() {
            @Override
            public void onNext(VehicleCategory category) {
                service.addCategory(category).ifPresent(responseObserver::onNext);
            }

            @Override
            public void onError(Throwable throwable) {
                LOG.error(throwable.getMessage(), throwable);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void getCategories(Empty request, StreamObserver<VehicleCategory> responseObserver) {
        service.getCategories().forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void confirmAvailability(Vehicle request, StreamObserver<Vehicle> responseObserver) {
        responseObserver.onNext(service.confirmAvailability(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getVehicle(Vehicle request, StreamObserver<Vehicle> responseObserver) {
        service.getVehicle(request).ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    private static void loadConfig(String[] args) {
        var propertyFile = "/application.properties";
        if (args.length > 0 && args[0].equalsIgnoreCase("dev")) {
            propertyFile = "/application-dev.properties";
        }
        try (InputStream is = VehicleServer.class.getResourceAsStream(propertyFile)) {
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
            ServiceInfo serviceInfo = ServiceInfo.create(host, "vehicle_service", Integer.parseInt(properties.getProperty("port")), "path=index.html");
            jmdns.registerService(serviceInfo);
            jmdns.addServiceListener(host, new VehicleServiceListener());

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

    private static class VehicleServiceListener implements ServiceListener {
        public void serviceAdded(ServiceEvent event) {
            LOG.info("Service added: " + event.getInfo());
        }

        public void serviceRemoved(ServiceEvent event) {
            LOG.info("Service removed: " + event.getInfo());
            if (event.getInfo().getName().equals("email_service")) {
                EmailUtil.removeMailerStub();
            } else if (event.getInfo().getName().equals("user_service")) {
                UserUtil.removeUserStub();
            }
        }

        public void serviceResolved(ServiceEvent event) {
            LOG.info("Service resolved: " + event.getInfo());
            ServiceInfo info = event.getInfo();
            if (info.getName().equals("email_service")) {
                EmailUtil.setMailerStub(info);
            } else if (info.getName().equals("user_service")) {
                UserUtil.setServiceStub(info);
            }
        }
    }
}

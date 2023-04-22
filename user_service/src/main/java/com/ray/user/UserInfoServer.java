package com.ray.user;

import com.ray.user.grpc.*;
import com.ray.user.util.auth.AuthorizationServerInterceptor;
import com.ray.user.util.email.EmailUtil;
import com.ray.user.util.hibernate.HibernateUtil;
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
public class UserInfoServer extends UserServiceGrpc.UserServiceImplBase {
    private static final Logger LOG = LogManager.getLogger(UserInfoServer.class);
    private static final Properties properties = new Properties();
    private static final String host = "_http._tcp.local.";// = "localhost";
    private final UserService userService = new UserService();

    public static void main( String[] args ) {
        loadConfig(args);
        Server server = null;
		try {
			server = ServerBuilder.forPort(Integer.parseInt(properties.getProperty("port")))
                    .addService(new UserInfoServer())
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
    public void createUser(User request, StreamObserver<User> responseObserver) {
        userService.createUser(request).ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void login(User request, StreamObserver<Authentication> responseObserver) {
        var auth = userService.login(request).orElse(Authentication.newBuilder().setError("Authentication Error").build());
        responseObserver.onNext(auth);
        responseObserver.onCompleted();
    }

    @Override
    public void refreshToken(Authentication request, StreamObserver<Authentication> responseObserver) {
        var auth = userService.refreshToken(request).orElse(Authentication.newBuilder().setError("Authentication Error").build());
        responseObserver.onNext(auth);
        responseObserver.onCompleted();
    }

    @Override
    public void resendOTP(User request, StreamObserver<Authentication> responseObserver) {
        var auth = userService.resendOTP(request).orElse(Authentication.newBuilder().setError("Authentication Error").build());
        responseObserver.onNext(auth);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(User request, StreamObserver<User> responseObserver) {
        userService.updateUser(request).ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(User request, StreamObserver<User> responseObserver) {
        userService.getUser(request).ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void activateUser(User request, StreamObserver<Authentication> responseObserver) {
        var auth = userService.activateUser(request).orElse(Authentication.newBuilder().setError("Authentication Error").build());
        responseObserver.onNext(auth);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllUser(UserFilter request, StreamObserver<User> responseObserver) {
        userService.getAllUsers(request).forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    private static void loadConfig(String[] args) {
        var propertyFile = "/application.properties";
        if (args.length > 0 && args[0].equalsIgnoreCase("dev")) {
            propertyFile = "/application-dev.properties";
        }
        try (InputStream is = UserInfoServer.class.getResourceAsStream(propertyFile)) {
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
            ServiceInfo serviceInfo = ServiceInfo.create(host, "user_service", Integer.parseInt(properties.getProperty("port")), "path=index.html");
            jmdns.registerService(serviceInfo);
            jmdns.addServiceListener(host, new UserServiceListener());
            JmDNS finalJmdns = jmdns;
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                finalJmdns.unregisterAllServices();
                LOG.info("Server is shutting down");
            }));

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

    private static class UserServiceListener implements ServiceListener {
        public void serviceAdded(ServiceEvent event) {
            LOG.info("Service added: " + event.getInfo());
        }
        public void serviceRemoved(ServiceEvent event) {
            LOG.info("Service removed: " + event.getInfo());
            if (event.getInfo().getName().equals("email_service")) {
                EmailUtil.removeMailerStub();
            }
        }
        public void serviceResolved(ServiceEvent event) {
            LOG.info("Service resolved: " + event.getInfo());
            ServiceInfo info = event.getInfo();
            if (info.getName().equals("email_service")) {
                EmailUtil.setMailerStub(info);
            }
        }
    }
}

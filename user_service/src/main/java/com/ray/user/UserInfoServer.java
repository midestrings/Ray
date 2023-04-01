package com.ray.user;

import com.ray.user.grpc.*;
import com.ray.user.util.email.EmailUtil;
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


    public static void main( String[] args ) {
        loadConfig(args);
        registerAndDiscoverServices();


    }

    @Override
    public void createUser(User request, StreamObserver<User> responseObserver) {
        super.createUser(request, responseObserver);
    }

    @Override
    public void login(User request, StreamObserver<Authentication> responseObserver) {
        super.login(request, responseObserver);
    }

    @Override
    public void refreshToken(Authentication request, StreamObserver<Authentication> responseObserver) {
        super.refreshToken(request, responseObserver);
    }

    @Override
    public void updateUser(User request, StreamObserver<User> responseObserver) {
        super.updateUser(request, responseObserver);
    }

    @Override
    public void getUser(User request, StreamObserver<User> responseObserver) {
        super.getUser(request, responseObserver);
    }

    @Override
    public void activateUser(User request, StreamObserver<User> responseObserver) {
        super.activateUser(request, responseObserver);
    }

    @Override
    public void getAllUser(Filter request, StreamObserver<User> responseObserver) {
        super.getAllUser(request, responseObserver);
    }

    private static void loadConfig(String[] args) {
        var propertyFile = "/application.properties";
        if (args.length > 0 && args[0].equalsIgnoreCase("dev")) {
            propertyFile = "/application-dev.properties";
        }
        try (InputStream is = UserInfoServer.class.getResourceAsStream(propertyFile)) {
            properties.load(is);
            System.setProperties(properties);
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

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            if (jmdns != null) {
                jmdns.unregisterAllServices();
            }
        }
    }

    public Properties getProperties() {
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

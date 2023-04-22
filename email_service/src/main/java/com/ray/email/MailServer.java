package com.ray.email;

import com.ray.email.grpc.Email;
import com.ray.email.grpc.EmailResponse;
import com.ray.email.grpc.MailerGrpc;
import com.ray.email.util.auth.AuthorizationServerInterceptor;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

public class MailServer extends MailerGrpc.MailerImplBase {
    private static final Logger LOG = LogManager.getLogger(MailServer.class);
    private static final Properties properties = new Properties();


    public static void main(String[] args) {
        loadConfig(args);
        Server server = null;
        try {
            server = ServerBuilder.forPort(Integer.parseInt(properties.getProperty("port")))
                    .addService(new MailServer())
                    .intercept(new AuthorizationServerInterceptor())
                    .build().start();
            LOG.info("Server started....");
            registerService();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            if (server != null) {
                server.shutdown();
            }
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public StreamObserver<Email> sendMail(StreamObserver<EmailResponse> responseObserver) {
        return new StreamObserver<Email>() {
            @Override
            public void onNext(Email email) {
                responseObserver.onNext(EmailService.getInstance().sendEmail(email));
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

    private static void loadConfig(String[] args) {
        var propertyFile = "/application.properties";
        if (args.length > 0 && args[0].equalsIgnoreCase("dev")) {
            propertyFile = "/application-dev.properties";
        }
        try (InputStream is = MailServer.class.getResourceAsStream(propertyFile)) {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void registerService() {
        JmDNS jmdns = null;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "email_service", Integer.parseInt(properties.getProperty("port")), "path=index.html");
            jmdns.registerService(serviceInfo);
            JmDNS finalJmdns = jmdns;
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                finalJmdns.unregisterAllServices();
                LOG.info("Server is shutting down");
            }));
        } catch (IOException e) {
            if (jmdns != null) {
                jmdns.unregisterAllServices();
            }
            LOG.error(e.getMessage(), e);
        }
    }
}

package com.ray.email;

import com.ray.email.grpc.Email;
import com.ray.email.grpc.EmailResponse;
import com.ray.email.grpc.MailerGrpc;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailServer extends MailerGrpc.MailerImplBase {

    private static final Properties properties = new Properties();

    public static void main(String [] args) {
        loadConfig();

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

            }

            @Override
            public void onCompleted() {

            }
        };
    }

    private static void loadConfig() {
        try (InputStream is = MailServer.class.getResourceAsStream("/application.properties")) {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Properties getProperties() {
        return properties;
    }

}

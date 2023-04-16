package com.ray.schedule.util.email;


import com.ray.schedule.grpc.Email;
import com.ray.schedule.grpc.EmailResponse;
import com.ray.schedule.grpc.MailerGrpc;
import com.ray.schedule.util.Utility;
import com.ray.schedule.util.auth.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.ServiceInfo;
import java.util.LinkedList;
import java.util.List;

public final class EmailUtil {
    private EmailUtil() {}

    private static final Logger LOG = LogManager.getLogger(EmailUtil.class);
    private static MailerGrpc.MailerStub mailerStub;
    private static final List<Email> emailQueue = new LinkedList<>();

    @SuppressWarnings("deprecation")
    public static void setMailerStub(ServiceInfo info) {
        LOG.info("IP Resolved for email_service - " + info.getPort() + ":" + info.getHostAddress());
        ManagedChannel channel = ManagedChannelBuilder.forAddress(info.getHostAddress(), info.getPort()).usePlaintext().build();
        mailerStub = MailerGrpc.newStub(channel);
        sendEmails();
    }

    public static void sendEmail(String subject, String to, String body) {
        sendEmail(subject, to, body, "");
    }

    public static void sendEmail(String subject, String to, String body, String from) {
        Email email = Email.newBuilder()
                .setBody(body)
                .setFrom(from)
                .setSubject(subject)
                .setTo(to)
                .build();
        emailQueue.add(email);
        if (mailerStub != null) sendEmails();
    }

    public static void removeMailerStub() {
        mailerStub = null;
    }

    private static void sendEmails() {
        StreamObserver<EmailResponse> responseObserver = new StreamObserver<EmailResponse>() {
            @Override
            public void onNext(EmailResponse emailResponse) {
                switch (emailResponse.getStatus()) {
                    case SENT:
                        LOG.debug("Email with subject - {} sent to - {}", emailResponse.getSubject(), emailResponse.getTo());
                        break;
                    case PERSISTED:
                        LOG.debug("Email with subject - {} has be persisted to be sent to - {}", emailResponse.getSubject(), emailResponse.getTo());
                        break;
                    case ERROR:
                        LOG.debug("Error with sending email with  subject - {} to - {}", emailResponse.getSubject(), emailResponse.getTo());
                }
            }

            @Override
            public void onError(Throwable throwable) {
                LOG.error(throwable.getMessage(), throwable);
            }

            @Override
            public void onCompleted() {
                LOG.info("Finished sending emails");
            }
        };
        StreamObserver<Email> requestObserver = mailerStub
                .withCallCredentials(new BearerToken(Utility::generateToken))
                .sendMail(responseObserver);
        try {
            for (Email email: emailQueue) {
                LOG.info("Sending email with subject - {} to {}", email.getSubject(), email.getTo());
                requestObserver.onNext(email);
            }
        } catch (RuntimeException e) {
            LOG.error(e.getMessage(), e);
            requestObserver.onError(e);
        }
        requestObserver.onCompleted();
    }
}

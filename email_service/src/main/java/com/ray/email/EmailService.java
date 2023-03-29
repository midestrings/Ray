package com.ray.email;

import com.ray.email.grpc.Email;
import com.ray.email.grpc.EmailResponse;
import com.ray.email.grpc.MailStatus;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static com.ray.email.MailServer.getProperties;

public class EmailService {
    private static EmailService instance;

    private EmailService() {}

    public static EmailService getInstance() {
        if (instance == null) {
            instance = new EmailService();
        }
        return instance;
    }

    public EmailResponse sendEmail(Email email) {
        Properties mailProperties = new Properties();
        mailProperties.put("mail.transport.protocol", "smtp");
        mailProperties.put("mail.smtp.port", getProperties().getProperty("smtp_port"));
        mailProperties.put("mail.smtp.host", getProperties().getProperty("smtp_host"));
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.ssl.trust", "*");
        mailProperties.put("mail.smtp.socketFactory.port", getProperties().getProperty("smtp_port"));
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(mailProperties, auth);
        try {
            MimeMessage message = new MimeMessage(session);
            var from = StringUtil.isNullOrEmpty(email.getFrom()) ? getProperties().getProperty("sender_email") : email.getFrom();
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            Transport.send(message);
            System.out.println("Mail successfully sent");

            return EmailResponse.newBuilder()
                    .setStatus(MailStatus.SENT)
                    .build();
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return EmailResponse.newBuilder()
                    .setStatus(MailStatus.ERROR)
                    .build();
        }
    }

    private static class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(getProperties().getProperty("smtp_username"), getProperties().getProperty("smtp_password"));
        }
    }
}

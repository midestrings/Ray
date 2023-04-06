package com.ray.vehicle.util.user;

import com.ray.vehicle.grpc.Email;
import com.ray.vehicle.grpc.MailerGrpc;
import com.ray.vehicle.grpc.User;
import com.ray.vehicle.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.ServiceInfo;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserUtil {
    private UserUtil() {}

    private static final Logger LOG = LogManager.getLogger(UserUtil.class);
    private static UserServiceGrpc.UserServiceBlockingStub serviceStub;

    @SuppressWarnings("deprecation")
    public static void setServiceStub(ServiceInfo info) {
        LOG.info("IP Resolved for user_service - " + info.getPort() + ":" + info.getHostAddress());
        ManagedChannel channel = ManagedChannelBuilder.forAddress(info.getHostAddress(), info.getPort()).usePlaintext().build();
        serviceStub = UserServiceGrpc.newBlockingStub(channel);
    }


    public static void removeUserStub() {
        serviceStub = null;
    }

    public static Optional<User> getUser(String email) {
        if (serviceStub != null) {
            var user = serviceStub.getUser(User.newBuilder().setEmail(email).build());
            return user != null ? Optional.of(user) : Optional.empty();
        }
        return Optional.empty();
    }

}

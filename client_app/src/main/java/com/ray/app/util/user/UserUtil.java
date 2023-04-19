package com.ray.app.util.user;


import com.ray.app.grpc.Authentication;
import com.ray.app.grpc.User;
import com.ray.app.grpc.UserServiceGrpc;
import com.ray.app.util.auth.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.ServiceInfo;
import java.util.Optional;

import static com.ray.app.Main.getAuth;

public class UserUtil {
    private UserUtil() {
    }

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
            try {
                var user = serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken)).getUser(User.newBuilder().setEmail(email).build());
                return user != null ? Optional.of(user) : Optional.empty();
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    public static Optional<User> createUser(User user) {
        if (serviceStub != null) {
            try {
                var createdUser = serviceStub.createUser(user);
                return createdUser != null ? Optional.of(createdUser) : Optional.empty();
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    public static Optional<Authentication> login(User user) {
        if (serviceStub != null) {
            try {
                var auth = serviceStub.login(user);
                return auth != null ? Optional.of(auth) : Optional.empty();
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    public static Optional<Authentication> resendOTP(String email) {
        if (serviceStub != null) {
            try {
                var auth = serviceStub.resendOTP(User.newBuilder().setEmail(email).build());
                return auth != null ? Optional.of(auth) : Optional.empty();
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    public static Optional<Authentication> activateUser(String otp, String email) {
        if (serviceStub != null) {
            try {
                var auth = serviceStub.activateUser(User.newBuilder().setOtp(otp).setEmail(email).build());
                return auth != null ? Optional.of(auth) : Optional.empty();
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

}

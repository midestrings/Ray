package com.ray.app.util.user;


import com.ray.app.Main;
import com.ray.app.controller.HomeController;
import com.ray.app.grpc.Authentication;
import com.ray.app.grpc.User;
import com.ray.app.grpc.UserServiceGrpc;
import com.ray.app.util.auth.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.application.Platform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.ServiceInfo;
import java.util.Optional;

import static com.ray.app.Main.*;
import static com.ray.app.controller.BaseController.showErrorAlert;

public class UserUtil {
    private UserUtil() {
    }

    private static final Logger LOG = LogManager.getLogger(UserUtil.class);
    private static UserServiceGrpc.UserServiceBlockingStub serviceStub;
    private static HomeController homeController;

    @SuppressWarnings("deprecation")
    public static void setServiceStub(ServiceInfo info) {
        LOG.info("IP Resolved for user_service - " + info.getPort() + ":" + info.getHostAddress());
        ManagedChannel channel = ManagedChannelBuilder.forAddress(info.getHostAddress(), info.getPort()).usePlaintext().build();
        serviceStub = UserServiceGrpc.newBlockingStub(channel);
        if (isLoggedIn()) {
            refreshToken();
            setUser(getUser(Main.getUser().getEmail()).orElse(Main.getUser()));
            if (homeController != null) {
                homeController.loadUserDetails();
            }
        }
    }


    public static void removeUserStub() {
        serviceStub = null;
    }

    public static Optional<User> getUser(String email) {
        if (serviceStub != null) {
            try {
                var user = serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken)).getUser(User.newBuilder().setLoadImage(true).setEmail(email).build());
                return user != null ? Optional.of(user) : Optional.empty();
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        } else {
            Platform.runLater(() -> showErrorAlert("User service isn't reachable"));
        }
        return Optional.empty();
    }

    public static Optional<User> createUser(User user) {
        if (serviceStub != null) {
            try {
                return Optional.of(serviceStub.createUser(user));
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        } else {
            Platform.runLater(() -> showErrorAlert("User service isn't reachable"));
        }
        return Optional.empty();
    }

    public static Optional<User> updateUser(User user) {
        if (serviceStub != null) {
            try {
                return Optional.of(serviceStub.withCallCredentials(new BearerToken(getAuth()::getToken)).updateUser(user));
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        } else {
            Platform.runLater(() -> showErrorAlert("User service isn't reachable"));
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
        } else {
            Platform.runLater(() -> showErrorAlert("User service isn't reachable"));
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
        } else {
            Platform.runLater(() -> showErrorAlert("User service isn't reachable"));
        }
        return Optional.empty();
    }

    public static void refreshToken() {
        if (serviceStub != null) {
            try {
                var auth = serviceStub.refreshToken(getAuth());
                if (auth != null) setAuth(auth);
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        } else {
            Platform.runLater(() -> showErrorAlert("User service isn't reachable"));
        }
    }

    public static Optional<Authentication> activateUser(String otp, String email) {
        if (serviceStub != null) {
            try {
                var auth = serviceStub.activateUser(User.newBuilder().setOtp(otp).setEmail(email).build());
                return auth != null ? Optional.of(auth) : Optional.empty();
            } catch (Exception e) {
                LOG.info(e.getMessage(), e);
            }
        } else {
            Platform.runLater(() -> showErrorAlert("User service isn't reachable"));
        }
        return Optional.empty();
    }

    public static void setHomeController(HomeController homeController) {
        UserUtil.homeController = homeController;
    }
}

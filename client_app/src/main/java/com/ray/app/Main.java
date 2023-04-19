package com.ray.app;

import com.ray.app.grpc.Authentication;
import com.ray.app.grpc.User;
import com.ray.app.util.Utility;
import com.ray.app.util.schedule.ScheduleUtil;
import com.ray.app.util.user.UserUtil;
import com.ray.app.util.vehicle.VehicleUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.time.Instant;
import java.util.Objects;
import java.util.Properties;
import java.util.prefs.Preferences;

/**
 * Hello world!
 */
public class Main extends Application {
    private final static Logger LOG = LogManager.getLogger(Main.class.getName());
    private static final Properties properties = new Properties();
    private static final String host = "_http._tcp.local.";// = "localhost";
    private static final Preferences prefs = Preferences.userRoot().node("/com/ray/preferences");
    private static Authentication auth;
    private static User user;

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        LOG.info("Ray app started  on {}", Utility.formatDateTimeString(startTime));
        loadConfig(args);
        discoverServices();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Long exitTime = System.currentTimeMillis();
            LOG.info("Ray app is closing on {}. Used for {} ms", Utility.formatDateTimeString(startTime), exitTime);
        }));
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        if (isLoggedIn()) {
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/fxml/home.fxml")));
        } else {
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/fxml/onboarding.fxml")));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("RentMyRide");
        Utility.setStageIcon(stage);

        // Add a close request handler to shut down the application
        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });

        stage.show();

    }

    private static void loadConfig(String[] args) {
        var propertyFile = "/application.properties";
        if (args.length > 0 && args[0].equalsIgnoreCase("dev")) {
            propertyFile = "/application-dev.properties";
        }
        try (InputStream is = Main.class.getResourceAsStream(propertyFile)) {
            properties.load(is);
            auth = Authentication.newBuilder()
                    .setToken(prefs.get("token", ""))
                    .setRefreshToken(prefs.get("refreshToken", ""))
                    .setRefreshTokenExpiry(Utility.getProtoDate(Utility.getDate(prefs.get("refreshTokenExpiry", "01-01-1970"))))
                    .build();
            user = User.newBuilder()
                    .setEmail(prefs.get("userEmail", "")).build();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static void discoverServices() {
        JmDNS jmdns = null;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            jmdns.addServiceListener(host, new AppListener());

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

    public static Authentication getAuth() {
        return auth == null ? Authentication.getDefaultInstance() : auth;
    }

    public static void setAuth(Authentication auth) {
        Main.auth = auth;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Main.user = user;
    }

    public static Preferences getPrefs() {
        return prefs;
    }

    private static class AppListener implements ServiceListener {
        public void serviceAdded(ServiceEvent event) {
            LOG.info("Service added: " + event.getInfo());
        }

        public void serviceRemoved(ServiceEvent event) {
            LOG.info("Service removed: " + event.getInfo());
            if (event.getInfo().getName().equals("user_service")) {
                UserUtil.removeUserStub();
            } else if (event.getInfo().getName().equals("vehicle_service")) {
                VehicleUtil.removeVehicleStub();
            } else if (event.getInfo().getName().equals("schedule_service")) {
                ScheduleUtil.removeScheduleStub();
            }
        }

        public void serviceResolved(ServiceEvent event) {
            LOG.info("Service resolved: " + event.getInfo());
            ServiceInfo info = event.getInfo();
            if (info.getName().equals("user_service")) {
                UserUtil.setServiceStub(info);
            } else if (info.getName().equals("vehicle_service")) {
                VehicleUtil.setServiceStub(info);
            } else if (info.getName().equals("schedule_service")) {
                ScheduleUtil.setServiceStub(info);
            }
        }
    }

    public static boolean isLoggedIn() {
        var refreshTokenDate = Utility.getDate(auth.getRefreshTokenExpiry());
        return Utility.isNotEmpty(auth.getToken()) && Utility.isNotEmpty(auth.getRefreshToken()) && refreshTokenDate != null
                && Instant.now().isBefore(refreshTokenDate.toInstant()) && Utility.isNotEmpty(user.getEmail());
    }

    public static Preferences getPreferences() {
        return prefs;
    }
}

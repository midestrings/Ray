package com.ray.app.controller;

import com.jfoenix.controls.JFXButton;
import com.ray.app.grpc.Authentication;
import com.ray.app.grpc.User;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.ray.app.Main.*;

public class HomeController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(HomeController.class.getName());
    @FXML
    public JFXButton addCategory;
    @FXML
    private JFXButton addVehicle;
    @FXML
    private HBox explore;
    @FXML
    private HBox reservation;
    @FXML
    private HBox profile;
    @FXML
    private HBox myVehicles;
    @FXML
    private HBox categories;
    @FXML
    private HBox logout;
    @FXML
    private Label pageName;
    @FXML
    private ImageView userDp;
    @FXML
    private Label userName;
    @FXML
    private Label userEmail;
    @FXML
    private Label userType;
    @FXML
    private Pane pageBody;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        explore.setOnMouseClicked(event -> loadPage(explore, "/fxml/explore.fxml", "Explore"));
        reservation.setOnMouseClicked(event -> loadPage(reservation, "/fxml/reservations.fxml", "Reservations"));
        profile.setOnMouseClicked(event -> loadPage(profile, "/fxml/explore.fxml", "Profile"));
        myVehicles.setOnMouseClicked(event -> loadPage(myVehicles, "/fxml/explore.fxml", "My Vehicles"));
        categories.setOnMouseClicked(event -> loadPage(categories, "/fxml/explore.fxml", "Vehicle Categories"));
        addVehicle.setOnMouseClicked(this::addVehicle);
        addCategory.setOnMouseClicked(this::addCategory);
        logout.setOnMouseClicked(this::logout);

        // Execute the task after 5 seconds to allow the app to refresh tokens and user data
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(event -> {
            Platform.runLater(() -> {
                var user = getUser();
                userName.setText(user.getName());
                userType.setText(user.getType());
                userEmail.setText(user.getEmail());
                if (user.getProfilePicture().isEmpty()) {
                    userDp.setImage(new Image(Objects.requireNonNull(HomeController.class.getResourceAsStream("/assets/icons/user_icon.png"))));
                } else {
                    userDp.setImage(new Image(user.getProfilePicture().newInput()));
                }
                user.getRolesList().stream().filter(r -> r.getRole().equals("user_vendor")).findAny().ifPresent(r -> {
                    myVehicles.setVisible(true);
                    categories.setVisible(true);
                    addVehicle.setVisible(true);
                    addCategory.setVisible(true);
                });
                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(BaseController.class.getResource("/fxml/explore.fxml")));
                    pageBody.getChildren().setAll(root);
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            });
        });
        delay.play();
    }

    private void loadPage(HBox box, String path, String name) {
        var selectedStyle = "-fx-border-color: white; -fx-cursor: hand; -fx-border-radius: 5px;";
        var defaultStyle = "-fx-cursor: hand; -fx-border-radius: 5px;";
        explore.setStyle(defaultStyle);
        reservation.setStyle(defaultStyle);
        profile.setStyle(defaultStyle);
        myVehicles.setStyle(defaultStyle);
        categories.setStyle(defaultStyle);

        box.setStyle(selectedStyle);
        try {
            pageName.setText(name);
            Parent root = FXMLLoader.load(Objects.requireNonNull(BaseController.class.getResource(path)));
            pageBody.getChildren().setAll(root);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void addVehicle(MouseEvent event) {
        popupNewStage(event, "/fxml/vehicleform.fxml");

    }
    private void addCategory(MouseEvent event) {
        popupNewStage(event, "/fxml/categoryform.fxml");
    }

    private void logout(MouseEvent event) {
        setUser(User.getDefaultInstance());
        setAuth(Authentication.getDefaultInstance());
        getPreferences().remove("userEmail");
        getPreferences().remove("userType");
        getPreferences().remove("token");
        getPreferences().remove("refreshToken");
        getPreferences().remove("refreshTokenExpiry");
        gotoLoginPage(event);
    }
}

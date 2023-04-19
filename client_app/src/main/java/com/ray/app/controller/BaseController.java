package com.ray.app.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Objects;

public abstract class BaseController {
    private final static Logger LOG = LogManager.getLogger(BaseController.class.getName());

    protected void gotoSignupPage(MouseEvent event) {
        goTo(event, "/fxml/signup.fxml");
    }

    protected void gotoLoginPage(MouseEvent event) {
        goTo(event, "/fxml/login.fxml");
    }

    protected void gotoOTPPage(MouseEvent event) {
        goTo(event, "/fxml/otp.fxml");
    }

    protected void goTo(MouseEvent event, String path) {
        var source = (Node) event.getSource();
        var stage = (Stage) source.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(BaseController.class.getResource(path)));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    protected static void showErrorAlert(String message) {
        showAlert(message, Alert.AlertType.ERROR);
    }
    protected static void showInfoAlert(String message) {
        showAlert(message, Alert.AlertType.INFORMATION);
    }

    private static void showAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(type.name());
        alert.setContentText(message);
        alert.showAndWait();
    }
}

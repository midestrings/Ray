package com.ray.app.controller;

import com.jfoenix.controls.JFXButton;
import com.ray.app.Main;
import com.ray.app.util.Utility;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.ray.app.Main.getPreferences;


public class OnBoardingController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(OnBoardingController.class.getName());
    @FXML
    private JFXButton ownerButton;
    @FXML
    private JFXButton clientButton;
    @FXML
    private Label login;
    @FXML
    private ImageView image;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ownerButton.setOnMouseClicked(event -> {
            getPreferences().put("userType", "vendor");
            gotoSignupPage(event);
        });
        clientButton.setOnMouseClicked(event -> {
            getPreferences().put("userType", "client");
            gotoSignupPage(event);
        });
        login.setOnMouseClicked(this::gotoLoginPage);
//
//        // Create a new image with the desired width and height
//        Image resizedImage = new Image(Objects.requireNonNull(OnBoardingController.class.getResourceAsStream("/assets/images/tesla.jpg")), 180, 430, false, false);
//
//        // Create a new image view and set it to display the resized image
//
//        image.setImage(resizedImage);
    }


}

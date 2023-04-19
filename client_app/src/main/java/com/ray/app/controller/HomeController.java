package com.ray.app.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController extends BaseController implements Initializable {
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
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(BaseController.class.getResource("/fxml/explore.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

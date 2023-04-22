package com.ray.app.controller;

import com.jfoenix.controls.JFXButton;
import com.ray.app.grpc.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.ResourceBundle;

public class VehicleCardController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(VehicleCardController.class.getName());

    @FXML
    private Label model;
    @FXML
    private JFXButton rent;
    @FXML
    private Label bookRide;
    @FXML
    private Label price;
    @FXML
    private Label rating;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setVehicle(Vehicle vehicle) {
        price.setText(NumberFormat.getCurrencyInstance().format(vehicle.getRentPrice()));
        model.setText(vehicle.getModel());
        rating.setText(String.valueOf(vehicle.getRating()));
        if (!vehicle.getImage().isEmpty()) {
            image.setImage(new Image(vehicle.getImage().newInput()));
        }
        rent.setOnMouseClicked(event -> rent(event, vehicle));
        bookRide.setOnMouseClicked(event -> bookRide(event, vehicle));
        if (!vehicle.getIsAvailableForRent()) {
            rent.setVisible(false);
        }
        if (!vehicle.getIsAvailableForRideHailing()) {
            bookRide.setVisible(false);
        }

    }

    private void bookRide(MouseEvent event, Vehicle vehicle) {
        try {
            var loader = new FXMLLoader(Objects.requireNonNull(VehicleCardController.class.getResource("/fxml/book_ride.fxml")));
            Parent root = loader.load();
            BooKRideController controller = loader.getController();
            controller.setVehicle(vehicle);
            popupNewStage(event, root);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void rent(MouseEvent event, Vehicle vehicle) {
        try {
            var loader = new FXMLLoader(Objects.requireNonNull(VehicleCardController.class.getResource("/fxml/rent_ride.fxml")));
            Parent root = loader.load();
            RentRideController controller = loader.getController();
            controller.setVehicle(vehicle);
            popupNewStage(event, root);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public void isUpdate() {
        bookRide.setVisible(false);
        rent.setVisible(false);
    }

}

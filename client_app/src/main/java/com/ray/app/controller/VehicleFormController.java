package com.ray.app.controller;

import com.google.protobuf.ByteString;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.ray.app.grpc.Vehicle;
import com.ray.app.util.Utility;
import com.ray.app.util.vehicle.VehicleUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

import static com.ray.app.Main.getUser;

public class VehicleFormController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(VehicleFormController.class.getName());
    public JFXComboBox category;
    @FXML
    private ImageView close;
    @FXML
    private JFXButton confirm;
    @FXML
    private JFXTextField plateNO;
    @FXML
    private JFXTextField make;
    @FXML
    private JFXTextField model;
    @FXML
    private JFXTextField year;
    @FXML
    private JFXTextField mileage;
    @FXML
    private JFXComboBox<String> bodyType;
    @FXML
    private JFXComboBox<String> engineType;
    @FXML
    private JFXComboBox<String> transmission;
    @FXML
    private JFXComboBox<String> status;
    @FXML
    private JFXTextField ridePrice;
    @FXML
    private JFXTextField rentPrice;
    @FXML
    private JFXCheckBox isAvailableForRent;
    @FXML
    private JFXCheckBox isAvailableForRide;
    @FXML
    private JFXTextField imagePath;
    private int vehicleId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> bodyTypeOptions = FXCollections.observableArrayList("Sedan", "Hatchback", "SUV", "Coupe",
                "Convertible", "Station Wagon", "Minivan", "Pickup Truck", "Sports Car");
        bodyType.setItems(bodyTypeOptions);
        ObservableList<String> transmissionOptions = FXCollections.observableArrayList("Manual", "Automatic");
        transmission.setItems(transmissionOptions);
        ObservableList<String> engineTypeOptions = FXCollections.observableArrayList("Petrol", "Diesel", "Hybrid",
                "Electric", "Turbo-diesel");
        engineType.setItems(engineTypeOptions);
        ObservableList<String> statusOptions = FXCollections.observableArrayList("Active", "Inactive", "In a ride", "Rented");
        status.setItems(statusOptions);
        vehicleId = -1;

        close.setOnMouseClicked(this::closePopUp);
        imageChooser.setOnMouseClicked(this::chooseImage);
        confirm.setOnMouseClicked(this::createOrUpdateVehicle);
        year.setTextFormatter(new TextFormatter<>(change -> change.getControlNewText().matches("^\\d*$") ? change : null));
        mileage.setTextFormatter(new TextFormatter<>(change -> change.getControlNewText().matches("^\\d*\\.?\\d*$") ? change : null));
        rentPrice.setTextFormatter(new TextFormatter<>(change -> change.getControlNewText().matches("^\\d*\\.?\\d*$") ? change : null));
        ridePrice.setTextFormatter(new TextFormatter<>(change -> change.getControlNewText().matches("^\\d*\\.?\\d*$") ? change : null));

    }

    private void createOrUpdateVehicle(MouseEvent event) {
        if (!Utility.isValidPlateNumber(plateNO.getText())) showErrorAlert("Invalid plate number");
        else {
            var vehicleBuilder = Vehicle.newBuilder()
                    .setId(Math.max(vehicleId, 0))
                    .setPlateNo(plateNO.getText())
                    .setMake(make.getText())
                    .setModel(model.getText())
                    .setYear(Integer.parseInt(year.getText()))
                    .setMileage(Integer.parseInt(mileage.getText()))
                    .setBodyType(bodyType.getValue())
                    .setEngineType(engineType.getValue())
                    .setTransmission(transmission.getValue())
                    .setStatus(status.getValue())
                    .setRentPrice(Double.parseDouble(rentPrice.getText()))
                    .setRidePrice(Double.parseDouble(ridePrice.getText()))
                    .setIsAvailableForRent(isAvailableForRent.isSelected())
                    .setOwnerEmail(getUser().getEmail())
                    .setOwnerName(getUser().getName())
                    .setIsAvailableForRideHailing(isAvailableForRide.isSelected());
            if (selectedFile != null) {
                try {
                    vehicleBuilder.setFileName(selectedFile.getName())
                            .setImage(ByteString.copyFrom(Files.readAllBytes(selectedFile.toPath())));
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
            var vehicle = vehicleBuilder.build();
            vehicle = VehicleUtil.createOrUpdateVehicle(vehicle).orElse(null);
            if (vehicle == null) {
                if (vehicleId > 0) {
                    showErrorAlert("Error creating vehicle");
                } else {
                    showErrorAlert("Error updating vehicle");
                }
                return;
            }
            if (Utility.isNotEmpty(vehicle.getError())) {
                showErrorAlert(vehicle.getError());
                return;
            }
            if (vehicleId > 0) {
                showInfoAlert("Vehicle has been created");
            } else {
                showInfoAlert("Vehicle has been updated");
            }
            closePopUp(event);
        }
    }
}

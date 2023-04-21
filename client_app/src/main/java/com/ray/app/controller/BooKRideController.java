package com.ray.app.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.ray.app.grpc.Reservation;
import com.ray.app.grpc.Vehicle;
import com.ray.app.util.Utility;
import com.ray.app.util.schedule.ScheduleUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import tornadofx.control.DateTimePicker;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static com.ray.app.Main.getUser;

public class BooKRideController extends BaseController implements Initializable {
    @FXML
    private JFXComboBox<String> pickupLocation;
    @FXML
    private JFXTextField pickupAddress;
    @FXML
    private DateTimePicker pickupTime;
    @FXML
    private JFXComboBox<String> destinationLocation;
    @FXML
    private JFXTextField destinationAddress;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        close.setOnMouseClicked(this::closePopUp);
        destinationLocation.setItems(FXCollections.observableArrayList(Utility.popularLocations()));
        pickupLocation.setItems(FXCollections.observableArrayList(Utility.popularLocations()));
    }

    public void setVehicle(Vehicle vehicle) {
        confirm.setOnMouseClicked(event -> bookRide(event, vehicle));
    }


    public void bookRide(MouseEvent event, Vehicle vehicle) {
        if (Utility.isEmpty(pickupLocation.getValue()) && Utility.isEmpty(pickupAddress.getText())) {
            showErrorAlert("Enter vehicle pickup location");
            pickupLocation.requestFocus();
            return;
        }
        if (Utility.isEmpty(destinationLocation.getValue()) && Utility.isEmpty(destinationAddress.getText())) {
            showErrorAlert("Enter vehicle destination location");
            destinationLocation.requestFocus();
            return;
        }
        if (pickupTime.getDateTimeValue() == null) {
            showErrorAlert("Enter vehicle pickup time");
            return;
        }
        var pickupDateTime = pickupTime.getDateTimeValue();
        if (LocalDateTime.now().plusHours(5L).isBefore(pickupDateTime)) {
            showErrorAlert("You can only book a ride 5 hours in advance");
            return;
        }
        var reservation = Reservation.newBuilder()
                .setClientEmail(getUser().getEmail())
                .setClientName(getUser().getName())
                .setDestinationAddress(Utility.isEmpty(destinationLocation.getValue()) ? destinationAddress.getText() : destinationLocation.getValue())
                .setPickupAddress(Utility.isEmpty(pickupLocation.getValue()) ? pickupAddress.getText() : pickupLocation.getValue())
                .setPickupTime(Utility.getDateTime(pickupDateTime))
                .setVehicleId(vehicle.getId())
                .setVehiclePlateNo(vehicle.getPlateNo())
                .setStatus("Active")
                .setType("ride")
                .build();
        reservation = ScheduleUtil.createReservation(reservation).orElse(null);
        validateReservationCreation(event, reservation);

    }

}

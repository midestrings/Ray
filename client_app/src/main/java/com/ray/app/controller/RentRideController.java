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

public class RentRideController extends BaseController implements Initializable {
    @FXML
    private JFXComboBox<String> dropOffLocation;
    @FXML
    private JFXTextField dropOffAddress;
    @FXML
    private DateTimePicker dropOffTime;
    @FXML
    private DateTimePicker expectedEndTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        close.setOnMouseClicked(this::closePopUp);
        dropOffLocation.setItems(FXCollections.observableArrayList(Utility.popularLocations()));
    }

    public void setVehicle(Vehicle vehicle) {
        confirm.setOnMouseClicked(event -> bookRide(event, vehicle));
    }

    public void bookRide(MouseEvent event, Vehicle vehicle) {
        if (Utility.isEmpty(dropOffLocation.getValue()) && Utility.isEmpty(dropOffAddress.getText())) {
            showErrorAlert("Enter vehicle drop off location");
            return;
        }
        if (dropOffTime.getDateTimeValue() == null) {
            showErrorAlert("Enter vehicle drop off time");
            return;
        }
        if (expectedEndTime.getDateTimeValue() == null) {
            showErrorAlert("Enter vehicle expected end time");
            return;
        }
        var dropOffDateTime = dropOffTime.getDateTimeValue();
        if (LocalDateTime.now().plusDays(1L).isBefore(dropOffDateTime)) {
            showErrorAlert("You can only book a vehicle a day in advance");
            return;
        }
        var expectedEndDateTime = expectedEndTime.getDateTimeValue();
        if (dropOffDateTime.isAfter(expectedEndDateTime)) {
            showErrorAlert("Expected end time can't be before the drop off time");
            return;
        }
        var reservation = Reservation.newBuilder()
                .setClientEmail(getUser().getEmail())
                .setClientName(getUser().getName())
                .setDropOffAddress(Utility.isEmpty(dropOffLocation.getValue()) ? dropOffAddress.getText() : dropOffLocation.getValue())
                .setDropOffTime(Utility.getDateTime(dropOffDateTime))
                .setExpectedEndTime(Utility.getDateTime(expectedEndDateTime))
                .setVehicleId(vehicle.getId())
                .setVehiclePlateNo(vehicle.getPlateNo())
                .setStatus("Active")
                .setType("rent")
                .build();
        reservation = ScheduleUtil.createReservation(reservation).orElse(null);
        validateReservationCreation(event, reservation);

    }
}

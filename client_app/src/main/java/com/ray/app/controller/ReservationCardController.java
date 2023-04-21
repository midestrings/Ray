package com.ray.app.controller;

import com.ray.app.grpc.Reservation;
import com.ray.app.util.Utility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationCardController extends BaseController implements Initializable {
    @FXML
    private Label type;
    @FXML
    private Label plateNo;
    @FXML
    private Label time;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setReservation(Reservation reservation) {
        plateNo.setText(reservation.getVehiclePlateNo());
        type.setText(reservation.getType());
        if ("rent".equalsIgnoreCase(reservation.getType())) {
            time.setText(Utility.formatDateTimeString(Utility.getDate(reservation.getDropOffTime())));
        } else {
            time.setText(Utility.formatDateTimeString(Utility.getDate(reservation.getPickupTime())));
        }
    }
}

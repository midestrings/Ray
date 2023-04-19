package com.ray.app.controller;

import com.ray.app.grpc.Vehicle;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class VehicleCardController extends BaseController implements Initializable {

    private Vehicle vehicle;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

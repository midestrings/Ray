package com.ray.app.controller;

import com.ray.app.grpc.VehicleCategory;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryCardController extends BaseController implements Initializable {
    private VehicleCategory category;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setCategory(VehicleCategory category) {
        this.category = category;
    }
}

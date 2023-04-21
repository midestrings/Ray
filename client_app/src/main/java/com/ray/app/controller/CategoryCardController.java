package com.ray.app.controller;

import com.ray.app.grpc.VehicleCategory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryCardController extends BaseController implements Initializable {
    @FXML
    private Text description;
    @FXML
    private Label name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setCategory(VehicleCategory category) {
        name.setText(category.getName());
        description.setText(category.getDescription());
        if (!category.getImage().isEmpty()) {
            image.setImage(new Image(category.getImage().newInput()));
        }
    }
}

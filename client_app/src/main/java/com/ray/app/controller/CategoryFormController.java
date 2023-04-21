package com.ray.app.controller;

import com.google.protobuf.ByteString;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.ray.app.grpc.VehicleCategory;
import com.ray.app.util.Utility;
import com.ray.app.util.vehicle.VehicleUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

import static com.ray.app.Main.getUser;

public class CategoryFormController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(CategoryFormController.class.getName());
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextArea description;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        close.setOnMouseClicked(this::closePopUp);
        imageChooser.setOnMouseClicked(this::chooseImage);
        confirm.setOnMouseClicked(this::createCategory);

    }

    private void createCategory(MouseEvent event) {
        if (Utility.isEmpty(name.getText())) showErrorAlert("Enter name");
        else {
            var categoryBuilder = VehicleCategory.newBuilder()
                    .setName(name.getText())
                    .setOwnerEmail(getUser().getEmail())
                    .setDescription(description.getText());
            if (selectedFile != null) {
                try {
                    categoryBuilder.setFileName(selectedFile.getName())
                            .setImage(ByteString.copyFrom(Files.readAllBytes(selectedFile.toPath())));
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
            var category = categoryBuilder.build();
            category = VehicleUtil.createCategory(category).orElse(null);
            if (category == null) {
                showErrorAlert("Error creating vehicle category");
                return;
            }
            if (Utility.isNotEmpty(category.getError())) {
                showErrorAlert(category.getError());
                return;
            }
            showInfoAlert("Vehicle category has been created");
            closePopUp(event);
        }
    }
}

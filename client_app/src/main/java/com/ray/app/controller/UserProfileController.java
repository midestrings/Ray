package com.ray.app.controller;

import com.google.protobuf.ByteString;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.ray.app.grpc.UserRole;
import com.ray.app.util.Utility;
import com.ray.app.util.user.UserUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

import static com.ray.app.Main.getUser;
import static com.ray.app.Main.setUser;

public class UserProfileController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(UserProfileController.class.getName());
    @FXML
    private JFXCheckBox upgradeToVendor;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXComboBox<String> gender;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField nationality;
    @FXML
    private JFXTextField passportNumber;
    @FXML
    private JFXTextField address;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageChooser.setOnMouseClicked(this::chooseImage);
        confirm.setOnMouseClicked(this::updateUser);
        ObservableList<String> genders = FXCollections.observableArrayList("Non-binary", "Genderqueer", "Transgender",
                "Agender", "Male", "Two-Spirit", "Female", "Other");
        gender.setItems(genders);
        var user = getUser();
        name.setText(user.getName());
        phone.setText(user.getPhone());
        nationality.setText(user.getNationality());
        passportNumber.setText(user.getPassportNo());
        address.setText(user.getAddress());
        gender.setValue(user.getGender());
        if (!user.getProfilePicture().isEmpty()) {
            image.setImage(new Image(user.getProfilePicture().newInput()));
        }
        if (user.getRolesList().stream().filter(r -> r.getRole().equals("user_vendor")).findAny().isEmpty()) {
            upgradeToVendor.setVisible(true);
        }
    }


    private void updateUser(MouseEvent event) {
        if (Utility.isEmpty(name.getText())) {
            showErrorAlert("Name cannot be empty");
        }
        var userBuilder = getUser().toBuilder()
                .setName(name.getText())
                .setAddress(address.getText())
                .setPassportNo(passportNumber.getText())
                .setNationality(passportNumber.getText())
                .setPhone(phone.getText())
                .setNationality(nationality.getText())
                .setGender(gender.getValue());
        if (upgradeToVendor.isVisible() && upgradeToVendor.isSelected()) {
            userBuilder.setType("vendor")
                    .addRoles(UserRole.newBuilder().setRole("user_vendor").build());
        }
        try {
            if (selectedFile != null) {
                userBuilder.setFileName(selectedFile.getName())
                        .setProfilePicture(ByteString.copyFrom(Files.readAllBytes(selectedFile.toPath())));
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        var updatedUser = UserUtil.updateUser(userBuilder.build()).orElse(null);
        if (updatedUser == null) {
            showErrorAlert("Error updating user");
            return;
        }
        if (Utility.isNotEmpty(updatedUser.getError())) {
            showErrorAlert(updatedUser.getError());
            return;
        }
        setUser(updatedUser);
        showInfoAlert("User has been updated");
        home.reloadUserProfile();
    }
}

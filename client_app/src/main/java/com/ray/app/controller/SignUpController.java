package com.ray.app.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.ray.app.grpc.User;
import com.ray.app.util.Utility;
import com.ray.app.util.user.UserUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

import static com.ray.app.Main.getPreferences;
import static com.ray.app.Main.setUser;

public class SignUpController extends BaseController implements Initializable {
    @FXML
    public Label login;
    @FXML
    private JFXTextField emailField;
    @FXML
    private JFXTextField nameField;
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private JFXPasswordField confirmPasswordField;
    @FXML
    private HBox signup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameField.requestFocus();
        login.setOnMouseClicked(this::gotoLoginPage);
        signup.setOnMouseClicked(this::signUp);
    }

    private void signUp(MouseEvent event) {
        // Perform validation
        if (Utility.isEmpty(nameField.getText())) showErrorAlert("Enter your name");
        else if (Utility.isInvalidEmail(emailField.getText())) showErrorAlert("Enter a valid email");
        else if (Utility.isInvalidPassword(passwordField.getText()))
            showErrorAlert("Enter a strong password, it has to be more than 8 letters");
        else if (!passwordField.getText().equals(confirmPasswordField.getText())) showErrorAlert("Passwords don't match");
        else {
            getPreferences().put("userEmail", emailField.getText());
            var user = User.newBuilder()
                    .setEmail(emailField.getText())
                    .setName(nameField.getText())
                    .setPassword(passwordField.getText())
                    .setType(getPreferences().get("userType", "client"))
                    .build();
            user = UserUtil.createUser(user).orElse(null);
            if (user == null) {
                showErrorAlert("Error signing up, something went wrong");
                return;
            }
            if (Utility.isNotEmpty(user.getError())) {
                showErrorAlert(user.getError());
                return;
            }
            setUser(user);
            showInfoAlert("Your account has been created, check your email for OTP");
            gotoOTPPage(event);
        }
    }
}

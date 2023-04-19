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

import static com.ray.app.Main.*;

public class LoginController extends BaseController implements Initializable {
    @FXML
    public Label signup;
    @FXML
    private JFXTextField emailField;
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private HBox login;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signup.setOnMouseClicked(this::gotoSignupPage);
        login.setOnMouseClicked(this::login);
    }

    private void login(MouseEvent event) {
        if (Utility.isInvalidEmail(emailField.getText())) showErrorAlert("Enter a valid email");
        else {
            getPreferences().put("userEmail", emailField.getText());
            var user = User.newBuilder()
                    .setEmail(emailField.getText())
                    .setPassword(passwordField.getText())
                    .build();
            var auth = UserUtil.login(user).orElse(null);
            if (auth == null) {
                showErrorAlert("Error logging in, something went wrong");
                return;
            }
            if ("OTP".equals(auth.getError())) {
                showInfoAlert("Your email isn't verified, check your email for OTP");
                gotoOTPPage(event);
                return;
            }
            if (Utility.isNotEmpty(auth.getError())) {
                showErrorAlert(auth.getError());
                return;
            }
            setAuth(auth);
            setUser(UserUtil.getUser(user.getEmail()).orElseThrow());
            getPreferences().put("token", auth.getToken());
            getPreferences().put("refreshToken", auth.getRefreshToken());
            getPreferences().put("refreshTokenExpiry", Utility.formatDateTimeString(Utility.getDate(auth.getRefreshTokenExpiry())));
            goTo(event, "/fxml/home.fxml");
        }
    }
}

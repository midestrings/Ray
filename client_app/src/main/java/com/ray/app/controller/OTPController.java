package com.ray.app.controller;

import com.jfoenix.controls.JFXTextField;
import com.ray.app.grpc.Authentication;
import com.ray.app.grpc.User;
import com.ray.app.util.Utility;
import com.ray.app.util.user.UserUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

import static com.ray.app.Main.*;

public class OTPController extends BaseController implements Initializable {

    @FXML
    private JFXTextField otpField;
    @FXML
    private HBox verify;
    @FXML
    public Label resend;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        resend.setOnMouseClicked(mouseEvent -> {
            var auth = UserUtil.resendOTP(getPreferences().get("userEmail", "")).orElse(Authentication.getDefaultInstance());
            if (!"OTP".equals(auth.getError())) {
                showInfoAlert("Something went wrong");
                return;
            }
            showInfoAlert("OTP sent, check your email");
        });
        verify.setOnMouseClicked(event -> {
            var auth = UserUtil.activateUser(otpField.getText(), getPreferences().get("userEmail", "")).orElse(null);
            if (auth == null) {
                showErrorAlert("Something went wrong");
                return;
            }
            if (Utility.isNotEmpty(auth.getError())) {
                showErrorAlert(auth.getError());
                return;
            }
            setAuth(auth);
            setUser(UserUtil.getUser(getPreferences().get("userEmail", "")).orElseThrow());
            getPreferences().put("token", auth.getToken());
            getPreferences().put("refreshToken", auth.getRefreshToken());
            getPreferences().put("refreshTokenExpiry", Utility.formatDateTimeString(Utility.getDate(auth.getToken())));
            goTo(event, "/fxml/home.fxml");
        });
    }
}

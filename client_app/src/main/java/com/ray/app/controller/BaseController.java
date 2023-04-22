package com.ray.app.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.ray.app.Main;
import com.ray.app.grpc.Reservation;
import com.ray.app.util.Utility;
import com.ray.app.util.user.UserUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static com.ray.app.Main.getPreferences;

public abstract class BaseController {
    private final static Logger LOG = LogManager.getLogger(BaseController.class.getName());
    protected File selectedFile;
    @FXML
    protected JFXTextField imagePath;
    @FXML
    protected ImageView image;
    @FXML
    protected ImageView imageChooser;
    @FXML
    protected ImageView close;
    @FXML
    protected JFXButton confirm;
    protected static HomeController home;



    protected void gotoSignupPage(MouseEvent event) {
        goTo(event, "/fxml/signup.fxml");
    }

    protected void gotoLoginPage(MouseEvent event) {
        goTo(event, "/fxml/login.fxml");
    }

    protected void gotoOTPPage(MouseEvent event) {
        goTo(event, "/fxml/otp.fxml");
    }

    protected void goTo(MouseEvent event, String path) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(BaseController.class.getResource(path)));
            goTo(event, root);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    protected void goTo(MouseEvent event, Parent root) {
        var source = (Node) event.getSource();
        var stage = (Stage) source.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    protected void gotoHomePage(MouseEvent event) {
        try {
            var loader = new FXMLLoader(Objects.requireNonNull(Main.class.getResource("/fxml/home.fxml")));
            Parent root = loader.load();
            HomeController controller = loader.getController();
            UserUtil.setHomeController(controller);
            goTo(event, root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showErrorAlert(String message) {
        showAlert(message, Alert.AlertType.ERROR);
    }

    public static void showInfoAlert(String message) {
        showAlert(message, Alert.AlertType.INFORMATION);
    }

    private static void showAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(type.name());
        alert.setContentText(message);
        alert.showAndWait();
    }


    protected File transcodeToPNG(File sourceFile) throws IOException {
        Path tempFile = Files.createTempFile(Paths.get(System.getProperty("java.io.tmpdir")), "temp", ".png");
        var file = new File(tempFile.toUri());
        ImageIO.write(ImageIO.read(sourceFile), "png", file);
        return file;
    }

    protected void closePopUp(MouseEvent event) {
        var source = (Node) event.getSource();
        var stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    protected void chooseImage(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        long maxSize = 1024 * 200; // 10MB in bytes
        fileChooser.setInitialDirectory(new File(getPreferences().get("initialDirectory", System.getProperty("user.home"))));

        var source = (Node) event.getSource();
        var stage = (Stage) source.getScene().getWindow();
        var file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            getPreferences().put("initialDirectory", file.getParentFile().getPath());
            if (file.length() > maxSize) {
                showErrorAlert("The selected file is too large. \nPlease choose a file smaller than 200Kb.");
            } else {
                try {
                    selectedFile = transcodeToPNG(file);
                    imagePath.setText(selectedFile.getAbsolutePath());
                    image.setImage(new Image(selectedFile.toURI().toString()));
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }

    protected void popupNewStage(MouseEvent event, Parent root) {
        var source = (Node) event.getSource();
        var stage = (Stage) source.getScene().getWindow();
        popupNewStage(stage, root);
    }

    private void popupNewStage(Stage stage, Parent root) {
        Scene scene = new Scene(root);

        // Create the child stage
        Stage childStage = new Stage();
        childStage.initStyle(StageStyle.UNDECORATED);
        childStage.setScene(scene);

        // Set the parent of the child stage
        childStage.initOwner(stage);

        // Set the modality of the child stage
        childStage.initModality(Modality.WINDOW_MODAL);

        // Show the child stage
        childStage.show();
    }

    protected void validateReservationCreation(MouseEvent event, Reservation reservation) {
        if (reservation == null) {
            showErrorAlert("Error creating reservation");
            return;
        }
        if (Utility.isNotEmpty(reservation.getError())) {
            showErrorAlert(reservation.getError());
            return;
        }
        showInfoAlert("Reservation has been created");
        closePopUp(event);
        home.reloadExplorePage();
    }



    protected void addVehicle(MouseEvent event) {
        try {
            var loader = new FXMLLoader(Objects.requireNonNull(HomeController.class.getResource("/fxml/vehicleform.fxml")));
            Parent root = loader.load();
            VehicleFormController controller = loader.getController();
            controller.setHome((HomeController) this);
            popupNewStage(event, root);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }

    }

    protected void addCategory(MouseEvent event) {
        try {
            var loader = new FXMLLoader(Objects.requireNonNull(HomeController.class.getResource("/fxml/categoryform.fxml")));
            Parent root = loader.load();
            CategoryFormController controller = loader.getController();
            controller.setHome((HomeController) this);
            popupNewStage(event, root);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }


    public void setHome(HomeController home) {
        BaseController.home = home;
    }

}

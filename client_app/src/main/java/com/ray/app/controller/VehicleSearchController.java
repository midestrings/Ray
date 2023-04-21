package com.ray.app.controller;

import com.ray.app.grpc.Vehicle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Objects;
import java.util.ResourceBundle;

public class VehicleSearchController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(VehicleSearchController.class.getName());
    public FlowPane pageBody;
    public Label notFound;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setVehicles(Iterator<Vehicle> vehicleIterator) {
        if (vehicleIterator.hasNext()) {
            pageBody.getChildren().remove(notFound);
            while (vehicleIterator.hasNext()) {
                var vehicle = vehicleIterator.next();
                try {
                    var loader = new FXMLLoader(Objects.requireNonNull(VehicleSearchController.class.getResource("/fxml/vehicle.fxml")));
                    Parent root = loader.load();
                    VehicleCardController controller = loader.getController();
                    controller.setVehicle(vehicle);
                    pageBody.getChildren().add(root);
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
}

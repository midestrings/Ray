package com.ray.app.controller;

import com.ray.app.grpc.Vehicle;
import com.ray.app.grpc.VehicleCategory;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Objects;
import java.util.ResourceBundle;

public class SearchController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(SearchController.class.getName());
    public FlowPane pageBody;
    public Label notFound;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setVehicles(Iterator<Vehicle> vehicleIterator, boolean isUpdate, HomeController home) {
        if (vehicleIterator != null && vehicleIterator.hasNext()) {
            pageBody.getChildren().remove(notFound);
            while (vehicleIterator.hasNext()) {
                var vehicle = vehicleIterator.next();
                try {
                    var loader = new FXMLLoader(Objects.requireNonNull(SearchController.class.getResource("/fxml/vehicle.fxml")));
                    Parent root = loader.load();
                    VehicleCardController controller = loader.getController();
                    controller.setVehicle(vehicle);
                    if (isUpdate) {
                        controller.isUpdate();
                        root.setOnMouseClicked(event -> updateVehicle(event, vehicle, home));
                    }
                    pageBody.getChildren().add(root);
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
    protected void updateVehicle(MouseEvent event, Vehicle vehicle, HomeController home) {
        try {
            var loader = new FXMLLoader(Objects.requireNonNull(HomeController.class.getResource("/fxml/vehicleform.fxml")));
            Parent root = loader.load();
            VehicleFormController controller = loader.getController();
            controller.setHome(home);
            controller.setVehicle(vehicle);
            popupNewStage(event, root);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }

    }
    public void setCategories(Iterator<VehicleCategory> categoryIterator) {
        if (categoryIterator != null && categoryIterator.hasNext()) {
            pageBody.getChildren().remove(notFound);
            while (categoryIterator.hasNext()) {
                var category = categoryIterator.next();
                try {
                    var loader = new FXMLLoader(Objects.requireNonNull(SearchController.class.getResource("/fxml/category.fxml")));
                    Parent root = loader.load();
                    CategoryCardController controller = loader.getController();
                    controller.setCategory(category);
                    pageBody.getChildren().add(root);
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
}

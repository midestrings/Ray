package com.ray.app.controller;

import com.jfoenix.controls.JFXTextField;
import com.ray.app.grpc.CategoryFilter;
import com.ray.app.grpc.Vehicle;
import com.ray.app.grpc.VehicleCategory;
import com.ray.app.grpc.VehicleFilter;
import com.ray.app.util.Utility;
import com.ray.app.util.vehicle.VehicleUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Objects;
import java.util.ResourceBundle;

public class ExploreController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(ExploreController.class.getName());
    @FXML
    private JFXTextField query;
    @FXML
    private ImageView search;
    @FXML
    private AnchorPane pageBody;
    @FXML
    private HBox categories;
    @FXML
    private HBox recentlyAdded;
    @FXML
    private HBox topRentals;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categories.setSpacing(10);
        recentlyAdded.setSpacing(10);
        topRentals.setSpacing(10);
        categories.setMaxWidth(1000);
        recentlyAdded.setMaxWidth(1000);
        topRentals.setMaxWidth(1000);
        Platform.runLater(() -> {
            var iterator = VehicleUtil.getCategories(CategoryFilter.newBuilder().setLimit(20).build());
            if (iterator != null) {
                loadCategories(iterator);
            }
            var vehicleIterator = VehicleUtil.getVehicles(VehicleFilter.newBuilder().setLimit(20).setByDateAdded(true).build());
            if (vehicleIterator != null) {
                loadVehicles(vehicleIterator, recentlyAdded);
            }
            vehicleIterator = VehicleUtil.getVehicles(VehicleFilter.newBuilder().setLimit(20).setByRating(true).build());
            if (vehicleIterator != null) {
                loadVehicles(vehicleIterator, topRentals);
            }
        });
        search.setOnMouseClicked(this::search);
    }

    private void loadCategories(Iterator<VehicleCategory> iterator) {
        while (iterator.hasNext()) {
            var category = iterator.next();
            try {
                var loader = new FXMLLoader(Objects.requireNonNull(BaseController.class.getResource("/fxml/category.fxml")));
                Parent root = loader.load();
                CategoryCardController controller = loader.getController();
                controller.setCategory(category);
                root.setOnMouseClicked(event -> search(category.getName()));
                categories.getChildren().add(root);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    private void loadVehicles(Iterator<Vehicle> iterator, HBox vehicles) {
        while (iterator.hasNext()) {
            var vehicle = iterator.next();
            try {
                var loader = new FXMLLoader(Objects.requireNonNull(BaseController.class.getResource("/fxml/vehicle.fxml")));
                Parent root = loader.load();
                VehicleCardController controller = loader.getController();
                controller.setVehicle(vehicle);
                vehicles.getChildren().add(root);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    private void search(VehicleFilter filter) {
        var vehicleIterator = VehicleUtil.getVehicles(filter);
        if (vehicleIterator != null) {
                try {
                    var loader = new FXMLLoader(Objects.requireNonNull(ExploreController.class.getResource("/fxml/vehicle_search.fxml")));
                    Parent root = loader.load();
                    SearchController controller = loader.getController();
                    controller.setVehicles(vehicleIterator, false, null);
                    pageBody.getChildren().setAll(root);
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
        }
    }

    private void search(String categoryName) {
        search(VehicleFilter.newBuilder().setCategoryName(categoryName).build());
    }

    private void search(MouseEvent event) {
        if (Utility.isEmpty(query.getText())) {
            showErrorAlert("Enter a search query");
            return;
        }
        search(VehicleFilter.newBuilder().setQuery(query.getText()).build());
    }
}

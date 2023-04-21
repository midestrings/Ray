package com.ray.app.controller;

import com.jfoenix.controls.JFXTextField;
import com.ray.app.grpc.CategoryFilter;
import com.ray.app.grpc.Vehicle;
import com.ray.app.grpc.VehicleCategory;
import com.ray.app.grpc.VehicleFilter;
import com.ray.app.util.Utility;
import com.ray.app.util.vehicle.VehicleUtil;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.util.Duration;
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
        int width = 0;
        while (iterator.hasNext()) {
            var category = iterator.next();
            try {
                var loader = new FXMLLoader(Objects.requireNonNull(BaseController.class.getResource("/fxml/category.fxml")));
                Parent root = loader.load();
                CategoryCardController controller = loader.getController();
                controller.setCategory(category);
                root.setOnMouseClicked(event -> search(category.getName()));
                categories.getChildren().add(root);
                width += ((Region) root).getWidth() + 10;
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        createCarousel(categories, width);
    }

    private void loadVehicles(Iterator<Vehicle> iterator, HBox vehicles) {
        int width = 0;
        while (iterator.hasNext()) {
            var vehicle = iterator.next();
            try {
                var loader = new FXMLLoader(Objects.requireNonNull(BaseController.class.getResource("/fxml/vehicle.fxml")));
                Parent root = loader.load();
                VehicleCardController controller = loader.getController();
                controller.setVehicle(vehicle);
                vehicles.getChildren().add(root);
                width += ((Region) root).getWidth() + 10;
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        createCarousel(vehicles, width);
    }

    private void createCarousel(HBox entitiesHbox, int width) {
        if (width > entitiesHbox.getWidth()) {
            // Create a transition to move the HBox left or right
            TranslateTransition transition = new TranslateTransition(Duration.seconds(1), entitiesHbox);

            // Set the initial position to the left of the scene
            entitiesHbox.setTranslateX(-entitiesHbox.getWidth());

            // Animate the HBox to move to the right of the scene
            transition.setToX(0);

            // Set the cycle count to indefinite to make the animation loop
            transition.setCycleCount(Animation.INDEFINITE);

            // Set the auto reverse flag to true to make the HBox move back and forth
            transition.setAutoReverse(true);

            // Start the animation
            transition.play();
        }
    }

    private void search(VehicleFilter filter) {
        var vehicleIterator = VehicleUtil.getVehicles(filter);
        if (vehicleIterator != null) {
                try {
                    var loader = new FXMLLoader(Objects.requireNonNull(ExploreController.class.getResource("/fxml/vehicle_search.fxml")));
                    Parent root = loader.load();
                    VehicleSearchController controller = loader.getController();
                    controller.setVehicles(vehicleIterator);
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

package com.ray.app.controller;

import com.ray.app.grpc.Reservation;
import com.ray.app.grpc.ReservationFilter;
import com.ray.app.grpc.Vehicle;
import com.ray.app.util.Utility;
import com.ray.app.util.schedule.ScheduleUtil;
import com.ray.app.util.vehicle.VehicleUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.ray.app.Main.getUser;

public class ReservationsController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(ReservationsController.class.getName());
    @FXML
    private AnchorPane body;
    @FXML
    private Label notFound;
    @FXML
    private VBox listing;
    @FXML
    private Label type;
    @FXML
    private Label pickup;
    @FXML
    private Label dropOff;
    @FXML
    private Label rating;
    @FXML
    private Label status;
    @FXML
    private Label plateNo;
    @FXML
    private Label model;
    @FXML
    private Label make;
    @FXML
    private Label price;
    @FXML
    private Label owner;
    @FXML
    private Label vehicleRating;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            var iterator = ScheduleUtil.getReservations(ReservationFilter.newBuilder()
                    .setClientEmail(getUser().getEmail()).build());
            if (iterator != null && iterator.hasNext()) {
                listing.setSpacing(10);
                listing.getChildren().remove(notFound);
                while (iterator.hasNext()) {
                    var reservation = iterator.next();
                    try {
                        var loader = new FXMLLoader(Objects.requireNonNull(ReservationsController.class.getResource("/fxml/reservationcard.fxml")));
                        Parent root = loader.load();
                        ReservationCardController controller = loader.getController();
                        controller.setReservation(reservation);
                        listing.getChildren().add(root);
                        root.setOnMouseClicked(event -> showBody(event, reservation));
                    } catch (IOException e) {
                        LOG.error(e.getMessage(), e);
                    }
                }
            }
        });

    }

    private void showBody(MouseEvent event, Reservation reservation) {
        type.setText(reservation.getType().toUpperCase());
        if("rent".equalsIgnoreCase(reservation.getType())) {
            pickup.setText(reservation.getPickupAddress() + Utility.formatDateTimeString(Utility.getDate(reservation.getPickupTime()), " @"));
        } else {
            dropOff.setText(reservation.getDropOffAddress() + Utility.formatDateTimeString(Utility.getDate(reservation.getDropOffTime()), " @"));
        }
        rating.setText(String.valueOf(reservation.getRating()));
        status.setText(reservation.getStatus());
        Platform.runLater(() -> {
            VehicleUtil.getVehicle(Vehicle.newBuilder().setId(reservation.getVehicleId()).setPlateNo(reservation.getVehiclePlateNo())
                    .setLoadImage(true).build()).ifPresent(vehicle -> {
                        plateNo.setText(vehicle.getPlateNo());
                        make.setText(vehicle.getMake());
                        model.setText(vehicle.getModel());
                        owner.setText(vehicle.getOwnerName() + " " + vehicle.getOwnerEmail());
                        vehicleRating.setText(String.valueOf(vehicle.getRating()));
                        if ("rent".equalsIgnoreCase(reservation.getType())) {
                            price.setText(NumberFormat.getCurrencyInstance().format(vehicle.getRentPrice()));
                        } else {
                            price.setText(NumberFormat.getCurrencyInstance().format(vehicle.getRidePrice()));
                        }
                        if (!vehicle.getImage().isEmpty()) {
                            image.setImage(new Image(vehicle.getImage().newInput()));
                        }
            });

        });
        body.setVisible(true);
    }


}

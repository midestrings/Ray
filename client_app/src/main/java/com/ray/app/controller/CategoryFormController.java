package com.ray.app.controller;

import com.google.protobuf.ByteString;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.ray.app.grpc.CategoryFilter;
import com.ray.app.grpc.Success;
import com.ray.app.grpc.VehicleCategory;
import com.ray.app.grpc.VehicleServiceGrpc;
import com.ray.app.util.Utility;
import com.ray.app.util.vehicle.VehicleUtil;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

import static com.ray.app.Main.getUser;

public class CategoryFormController extends BaseController implements Initializable {
    private final static Logger LOG = LogManager.getLogger(CategoryFormController.class.getName());
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextArea description;
    private StreamObserver<VehicleCategory> requestObserver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        close.setOnMouseClicked(this::close);
        imageChooser.setOnMouseClicked(this::chooseImage);
        confirm.setOnMouseClicked(this::createCategory);
        Platform.runLater(() -> {
            VehicleServiceGrpc.VehicleServiceStub stub = VehicleUtil.createCategory();
            if (stub == null) {
                showErrorAlert("Vehicle service is down");
                return;
            }
            StreamObserver<Success> successStreamObserver = new StreamObserver<Success>() {
                @Override
                public void onNext(Success success) {
                    LOG.info("Vehicle categories were created successfully");
                }

                @Override
                public void onError(Throwable throwable) {
                    LOG.error(throwable.getMessage(), throwable);
                }

                @Override
                public void onCompleted() {
                    LOG.info("Categories created successfully");
                }
            };
            requestObserver = stub.addCategory(successStreamObserver);
        });


    }

    private void createCategory(MouseEvent event) {
        if (Utility.isEmpty(name.getText())) showErrorAlert("Enter name");
        else {
            var savedCategoryIter = VehicleUtil.getCategories(CategoryFilter.newBuilder().setQuery(name.getText()).build());
            if (savedCategoryIter != null && savedCategoryIter.hasNext()) {
                showErrorAlert("Category with name already exist");
                return;
            }
            var categoryBuilder = VehicleCategory.newBuilder()
                    .setName(name.getText())
                    .setOwnerEmail(getUser().getEmail())
                    .setDescription(description.getText());
            if (selectedFile != null) {
                try {
                    categoryBuilder.setFileName(selectedFile.getName())
                            .setImage(ByteString.copyFrom(Files.readAllBytes(selectedFile.toPath())));
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
            var category = categoryBuilder.build();
            requestObserver.onNext(category);
            showInfoAlert("Category submitted you can create more!");
            name.setText("");
            description.setText("");
            home.reloadCategoriesPage();
        }
    }

    public void close(MouseEvent event) {
        requestObserver.onCompleted();
        closePopUp(event);
    }

}

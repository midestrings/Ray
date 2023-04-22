package com.ray.vehicle.entity;

import com.google.protobuf.ByteString;
import com.ray.vehicle.grpc.Vehicle;
import com.ray.vehicle.grpc.VehicleCategory;
import com.ray.vehicle.util.Utility;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Vehicle")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ownerName;
    @Column
    private String ownerEmail;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private int year;
    @Column
    private String color;
    @Column
    private String bodyType;
    @Column
    private String engineType;
    @Column
    private String fuelType;
    @Column
    private String transmission;
    @Column
    private int mileage;
    @Column
    private double ridePrice;
    @Column
    private double rentPrice;
    @Column
    private boolean isAvailableForRent;
    @Column
    private boolean isAvailableForRideHailing;
    @Column
    private String status;
    @Column
    private double rating;
    @Column
    private String fileName;
    @Column(unique = true)
    private String plateNo;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private VehicleCategoryEntity vehicleCategory;

    // Getters and Setters for all the fields
    public String getMake() {
        return make;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getRidePrice() {
        return ridePrice;
    }

    public void setRidePrice(double ridePrice) {
        this.ridePrice = ridePrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public boolean isAvailableForRent() {
        return isAvailableForRent;
    }

    public void setAvailableForRent(boolean availableForRent) {
        isAvailableForRent = availableForRent;
    }

    public boolean isAvailableForRideHailing() {
        return isAvailableForRideHailing;
    }

    public void setAvailableForRideHailing(boolean availableForRideHailing) {
        isAvailableForRideHailing = availableForRideHailing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public VehicleCategoryEntity getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategoryEntity vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public static VehicleEntity getInstance(Vehicle vehicle) {
        var entity = new VehicleEntity();
        entity.make = vehicle.getMake();
        entity.model = vehicle.getModel();
        entity.year = vehicle.getYear();
        entity.color = vehicle.getColor();
        entity.bodyType = vehicle.getBodyType();
        entity.engineType = vehicle.getEngineType();
        entity.fuelType = vehicle.getFuelType();
        entity.transmission = vehicle.getTransmission();
        entity.mileage = vehicle.getMileage();
        entity.ridePrice = vehicle.getRidePrice();
        entity.rentPrice = vehicle.getRentPrice();
        entity.status = vehicle.getStatus();
        entity.rating = vehicle.getRating();
        entity.isAvailableForRent = vehicle.getIsAvailableForRent();
        entity.ownerEmail = vehicle.getOwnerEmail();
        entity.ownerName = vehicle.getOwnerName();
        entity.isAvailableForRideHailing = vehicle.getIsAvailableForRideHailing();
        if (!Utility.isEmpty(vehicle.getFileName())) {
            entity.fileName = vehicle.getFileName();
            entity.image = vehicle.getImage().toByteArray();
        }
        entity.plateNo = vehicle.getPlateNo();

        entity.createdAt = LocalDateTime.now();
        return entity;
    }

    public static void updateInstance(Vehicle vehicle, VehicleEntity entity) {
        entity.make = Utility.isNotEmpty(vehicle.getMake()) ? vehicle.getMake() : entity.make;
        entity.model = Utility.isNotEmpty(vehicle.getModel()) ? vehicle.getModel() : entity.model;
        entity.year = vehicle.getYear() > 1900 ? vehicle.getYear() : entity.year;
        entity.color = Utility.isNotEmpty(vehicle.getColor()) ? vehicle.getColor() : entity.color;
        entity.bodyType = Utility.isNotEmpty(vehicle.getBodyType()) ? vehicle.getBodyType() : entity.bodyType;
        entity.engineType = Utility.isNotEmpty(vehicle.getEngineType()) ? vehicle.getEngineType() : entity.engineType;
        entity.fuelType = Utility.isNotEmpty(vehicle.getFuelType()) ? vehicle.getFuelType() : entity.fuelType;
        entity.transmission = Utility.isNotEmpty(vehicle.getTransmission()) ? vehicle.getTransmission() : entity.transmission;
        entity.mileage = vehicle.getMileage() > entity.mileage ? vehicle.getMileage() : entity.mileage;
        entity.ridePrice = vehicle.getRidePrice() > 0 ? vehicle.getRidePrice() : entity.ridePrice;
        entity.rentPrice = vehicle.getRentPrice() > 0 ? vehicle.getRentPrice() : entity.rentPrice;
        entity.rating = vehicle.getRating() > 0 ? vehicle.getRating() : entity.rating;
        entity.isAvailableForRent = vehicle.getIsAvailableForRent();
        entity.isAvailableForRideHailing = vehicle.getIsAvailableForRideHailing();
        entity.status = Utility.isNotEmpty(vehicle.getStatus()) ? entity.status : vehicle.getStatus();
        if (!Utility.isEmpty(vehicle.getFileName()) && !vehicle.getFileName().equals(entity.fileName)) {
            entity.fileName = vehicle.getFileName();
            entity.image = vehicle.getImage().toByteArray();
        }
        entity.updatedAt = LocalDateTime.now();
    }

    public static Vehicle getVehicle(VehicleEntity vehicle, boolean loadImage) {
        var vehicleBuilder = Vehicle.newBuilder()
                .setId(vehicle.id)
                .setPlateNo(vehicle.plateNo)
                .setOwnerEmail(vehicle.ownerEmail)
                .setOwnerName(vehicle.ownerName)
                .setMake(vehicle.make)
                .setModel(vehicle.model)
                .setYear(vehicle.year)
                .setColor(vehicle.color)
                .setBodyType(vehicle.bodyType)
                .setEngineType(vehicle.engineType)
                .setFuelType(vehicle.fuelType)
                .setTransmission(vehicle.transmission)
                .setStatus(vehicle.status)
                .setMileage(vehicle.mileage)
                .setRidePrice(vehicle.ridePrice)
                .setRentPrice(vehicle.rentPrice)
                .setRating(vehicle.rating)
                .setIsAvailableForRent(vehicle.isAvailableForRent)
                .setIsAvailableForRideHailing(vehicle.isAvailableForRideHailing)
                .setCategory(VehicleCategoryEntity.getCategory(vehicle.vehicleCategory, false));
        if (loadImage) {
            vehicleBuilder.setFileName(vehicle.fileName)
                    .setImage(ByteString.copyFrom(vehicle.image));
        }
        return vehicleBuilder.build();
    }
}

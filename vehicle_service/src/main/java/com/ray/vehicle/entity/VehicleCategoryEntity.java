package com.ray.vehicle.entity;

import com.google.protobuf.ByteString;
import com.ray.vehicle.grpc.Vehicle;
import com.ray.vehicle.grpc.VehicleCategory;
import com.ray.vehicle.util.Utility;
import io.grpc.Context;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "VehicleCategory")
public class VehicleCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    @Column
    private String description;
    @Column
    private String ownerEmail;
    @Column
    private String fileName;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "vehicleCategory")
    private List<VehicleEntity> vehicles;

    public VehicleCategoryEntity() {
    }

    public VehicleCategoryEntity(String name, String description) {
        this.name = name;
        this.description = description;
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

    // Getters and Setters for the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<VehicleEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity> vehicles) {
        this.vehicles = vehicles;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public static VehicleCategory getCategory(VehicleCategoryEntity vehicleCategory, boolean loadImage) {
        if (vehicleCategory == null) return VehicleCategory.getDefaultInstance();
        var categoryBuilder = VehicleCategory.newBuilder()
                .setDescription(vehicleCategory.description)
                .setName(vehicleCategory.name)
                .setId(vehicleCategory.id);
        if (loadImage) {
            categoryBuilder.setFileName(vehicleCategory.fileName)
                    .setImage(ByteString.copyFrom(vehicleCategory.image));
        }
        return categoryBuilder.build();
    }

    public static VehicleCategoryEntity getInstance(VehicleCategory category) {
        var entity = new VehicleCategoryEntity(category.getName(), category.getDescription());
        if (!Utility.isEmpty(category.getFileName())) {
            entity.fileName = category.getFileName();
            entity.image = category.getImage().toByteArray();
        }
        entity.createdAt = LocalDateTime.now();
        entity.ownerEmail = category.getOwnerEmail();
        return entity;
    }
}

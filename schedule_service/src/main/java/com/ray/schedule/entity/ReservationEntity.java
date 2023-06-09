package com.ray.schedule.entity;

import com.ray.schedule.grpc.DateTime;
import com.ray.schedule.grpc.Reservation;
import com.ray.schedule.util.Utility;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "Reservation")
public class ReservationEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String type;
    @Column
    private int vehicleId;
    @Column
    private String clientEmail;
    @Column
    private String clientName;
    @Column
    private String pickupAddress;
    @Column
    private String destinationAddress;
    @Column
    private Date pickupTime;
    @Column
    private Date dropOffTime;
    @Column
    private String dropOffAddress;
    @Column
    private Date expectedEndTime;
    @Column
    private double pickupLatitude;
    @Column
    private double pickupLongitude;
    @Column
    private double dropOffLatitude;
    @Column
    private double dropOffLongitude;
    @Column
    private double destinationLatitude;
    @Column
    private double destinationLongitude;
    @Column
    private String status;
    @Column
    private double rating;
    @Column
    private String vehiclePlateNo;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Date getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(Date dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    public String getDropOffAddress() {
        return dropOffAddress;
    }

    public void setDropOffAddress(String dropOffAddress) {
        this.dropOffAddress = dropOffAddress;
    }

    public Date getExpectedEndTime() {
        return expectedEndTime;
    }

    public void setExpectedEndTime(Date expectedEndTime) {
        this.expectedEndTime = expectedEndTime;
    }

    public double getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public double getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(double pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public double getDropOffLatitude() {
        return dropOffLatitude;
    }

    public void setDropOffLatitude(double dropOffLatitude) {
        this.dropOffLatitude = dropOffLatitude;
    }

    public double getDropOffLongitude() {
        return dropOffLongitude;
    }

    public void setDropOffLongitude(double dropOffLongitude) {
        this.dropOffLongitude = dropOffLongitude;
    }

    public double getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(double destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public double getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(double destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getVehiclePlateNo() {
        return vehiclePlateNo;
    }

    public void setVehiclePlateNo(String vehiclePlateNo) {
        this.vehiclePlateNo = vehiclePlateNo;
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

    public static ReservationEntity getInstance(Reservation reservation) {
        var entity = new ReservationEntity();
        entity.vehicleId = reservation.getVehicleId();
        entity.vehiclePlateNo = reservation.getVehiclePlateNo();
        entity.clientEmail = reservation.getClientEmail();
        entity.clientName = reservation.getClientName();
        entity.type = reservation.getType();
        entity.pickupAddress = reservation.getPickupAddress();
        entity.destinationAddress = reservation.getDestinationAddress();
        entity.dropOffAddress = reservation.getDropOffAddress();
        setDefaultFields(entity, reservation);
        entity.vehiclePlateNo = reservation.getVehiclePlateNo();
        entity.createdAt = LocalDateTime.now();
        return entity;
    }

    public static Reservation getReservation(ReservationEntity entity) {
        return Reservation.newBuilder()
                .setId(entity.id)
                .setVehicleId(entity.vehicleId)
                .setClientEmail(entity.clientEmail)
                .setClientName(entity.clientName)
                .setType(entity.type)
                .setPickupAddress(entity.pickupAddress)
                .setDestinationAddress(entity.destinationAddress)
                .setDropOffAddress(entity.dropOffAddress)
                .setPickupTime(Utility.getDateTime(entity.pickupTime))
                .setDropOffTime(Utility.getDateTime(entity.dropOffTime))
                .setExpectedEndTime(Utility.getDateTime(entity.expectedEndTime))
                .setPickupLatitude(entity.pickupLatitude)
                .setPickupLongitude(entity.pickupLongitude)
                .setDropOffLatitude(entity.dropOffLatitude)
                .setDropOffLongitude(entity.dropOffLongitude)
                .setDestinationLatitude(entity.destinationLatitude)
                .setDestinationLongitude(entity.destinationLongitude)
                .setStatus(entity.status)
                .setRating(entity.rating)
                .setVehiclePlateNo(entity.vehiclePlateNo)
                .build();
    }

    public static void updateInstance(ReservationEntity entity, Reservation reservation) {
        entity.pickupAddress = Utility.isEmpty(reservation.getPickupAddress()) ? entity.pickupAddress : reservation.getPickupAddress();
        entity.destinationAddress = Utility.isEmpty(reservation.getDestinationAddress()) ? entity.destinationAddress : reservation.getDestinationAddress();
        entity.dropOffAddress = Utility.isEmpty(reservation.getDropOffAddress()) ? entity.dropOffAddress : reservation.getDropOffAddress();
        setDefaultFields(entity, reservation);
        entity.updatedAt = LocalDateTime.now();

    }

    private static void setDefaultFields(ReservationEntity entity, Reservation reservation) {
        entity.pickupTime = Utility.getDate(reservation.getPickupTime());
        entity.dropOffTime = Utility.getDate(reservation.getDropOffTime());
        entity.expectedEndTime = Utility.getDate(reservation.getExpectedEndTime());
        entity.pickupLatitude = reservation.getPickupLatitude();
        entity.pickupLongitude = reservation.getPickupLongitude();
        entity.dropOffLatitude = reservation.getDropOffLatitude();
        entity.dropOffLongitude = reservation.getDropOffLongitude();
        entity.destinationLatitude = reservation.getDestinationLatitude();
        entity.destinationLongitude = reservation.getDestinationLongitude();
        entity.status = reservation.getStatus();
        entity.rating = reservation.getRating();
    }

}

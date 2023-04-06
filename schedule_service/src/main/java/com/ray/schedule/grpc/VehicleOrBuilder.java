// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vehicle.proto

package com.ray.schedule.grpc;

public interface VehicleOrBuilder extends
    // @@protoc_insertion_point(interface_extends:vehicle.Vehicle)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string make = 1;</code>
   */
  java.lang.String getMake();
  /**
   * <code>string make = 1;</code>
   */
  com.google.protobuf.ByteString
      getMakeBytes();

  /**
   * <code>string model = 2;</code>
   */
  java.lang.String getModel();
  /**
   * <code>string model = 2;</code>
   */
  com.google.protobuf.ByteString
      getModelBytes();

  /**
   * <code>int32 year = 3;</code>
   */
  int getYear();

  /**
   * <code>string color = 4;</code>
   */
  java.lang.String getColor();
  /**
   * <code>string color = 4;</code>
   */
  com.google.protobuf.ByteString
      getColorBytes();

  /**
   * <code>int32 mileage = 5;</code>
   */
  int getMileage();

  /**
   * <code>double rent_price = 6;</code>
   */
  double getRentPrice();

  /**
   * <code>string engine_type = 7;</code>
   */
  java.lang.String getEngineType();
  /**
   * <code>string engine_type = 7;</code>
   */
  com.google.protobuf.ByteString
      getEngineTypeBytes();

  /**
   * <code>string fuel_type = 8;</code>
   */
  java.lang.String getFuelType();
  /**
   * <code>string fuel_type = 8;</code>
   */
  com.google.protobuf.ByteString
      getFuelTypeBytes();

  /**
   * <code>string transmission = 9;</code>
   */
  java.lang.String getTransmission();
  /**
   * <code>string transmission = 9;</code>
   */
  com.google.protobuf.ByteString
      getTransmissionBytes();

  /**
   * <code>double ride_price = 10;</code>
   */
  double getRidePrice();

  /**
   * <code>string fileName = 11;</code>
   */
  java.lang.String getFileName();
  /**
   * <code>string fileName = 11;</code>
   */
  com.google.protobuf.ByteString
      getFileNameBytes();

  /**
   * <code>bytes image = 12;</code>
   */
  com.google.protobuf.ByteString getImage();

  /**
   * <code>string owner_name = 13;</code>
   */
  java.lang.String getOwnerName();
  /**
   * <code>string owner_name = 13;</code>
   */
  com.google.protobuf.ByteString
      getOwnerNameBytes();

  /**
   * <code>string owner_email = 14;</code>
   */
  java.lang.String getOwnerEmail();
  /**
   * <code>string owner_email = 14;</code>
   */
  com.google.protobuf.ByteString
      getOwnerEmailBytes();

  /**
   * <code>bool is_available_for_rent = 15;</code>
   */
  boolean getIsAvailableForRent();

  /**
   * <code>bool is_available_for_ride_hailing = 16;</code>
   */
  boolean getIsAvailableForRideHailing();

  /**
   * <code>.vehicle.VehicleCategory category = 17;</code>
   */
  boolean hasCategory();
  /**
   * <code>.vehicle.VehicleCategory category = 17;</code>
   */
  com.ray.schedule.grpc.VehicleCategory getCategory();
  /**
   * <code>.vehicle.VehicleCategory category = 17;</code>
   */
  com.ray.schedule.grpc.VehicleCategoryOrBuilder getCategoryOrBuilder();

  /**
   * <code>int32 id = 18;</code>
   */
  int getId();

  /**
   * <code>string plate_no = 19;</code>
   */
  java.lang.String getPlateNo();
  /**
   * <code>string plate_no = 19;</code>
   */
  com.google.protobuf.ByteString
      getPlateNoBytes();

  /**
   * <code>string body_type = 20;</code>
   */
  java.lang.String getBodyType();
  /**
   * <code>string body_type = 20;</code>
   */
  com.google.protobuf.ByteString
      getBodyTypeBytes();

  /**
   * <code>bool loadImage = 21;</code>
   */
  boolean getLoadImage();
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vehicle.proto

package com.ray.vehicle.grpc;

public interface VehicleCategoryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:vehicle.VehicleCategory)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string description = 2;</code>
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 2;</code>
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>string fileName = 3;</code>
   */
  java.lang.String getFileName();
  /**
   * <code>string fileName = 3;</code>
   */
  com.google.protobuf.ByteString
      getFileNameBytes();

  /**
   * <code>bytes image = 4;</code>
   */
  com.google.protobuf.ByteString getImage();

  /**
   * <code>int32 id = 6;</code>
   */
  int getId();

  /**
   * <code>bool loadImage = 7;</code>
   */
  boolean getLoadImage();

  /**
   * <code>string error = 8;</code>
   */
  java.lang.String getError();
  /**
   * <code>string error = 8;</code>
   */
  com.google.protobuf.ByteString
      getErrorBytes();

  /**
   * <code>string ownerEmail = 9;</code>
   */
  java.lang.String getOwnerEmail();
  /**
   * <code>string ownerEmail = 9;</code>
   */
  com.google.protobuf.ByteString
      getOwnerEmailBytes();
}

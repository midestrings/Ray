// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vehicle.proto

package com.ray.app.grpc;

public interface VehicleFilterOrBuilder extends
    // @@protoc_insertion_point(interface_extends:vehicle.VehicleFilter)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool byRating = 1;</code>
   */
  boolean getByRating();

  /**
   * <code>bool byDateAdded = 2;</code>
   */
  boolean getByDateAdded();

  /**
   * <code>string query = 3;</code>
   */
  java.lang.String getQuery();
  /**
   * <code>string query = 3;</code>
   */
  com.google.protobuf.ByteString
      getQueryBytes();

  /**
   * <code>int32 limit = 4;</code>
   */
  int getLimit();

  /**
   * <code>string category_name = 5;</code>
   */
  java.lang.String getCategoryName();
  /**
   * <code>string category_name = 5;</code>
   */
  com.google.protobuf.ByteString
      getCategoryNameBytes();
}

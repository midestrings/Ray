// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.ray.schedule.grpc;

public interface UserFilterOrBuilder extends
    // @@protoc_insertion_point(interface_extends:user.UserFilter)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string status = 1;</code>
   */
  java.util.List<java.lang.String>
      getStatusList();
  /**
   * <code>repeated string status = 1;</code>
   */
  int getStatusCount();
  /**
   * <code>repeated string status = 1;</code>
   */
  java.lang.String getStatus(int index);
  /**
   * <code>repeated string status = 1;</code>
   */
  com.google.protobuf.ByteString
      getStatusBytes(int index);

  /**
   * <code>string type = 2;</code>
   */
  java.lang.String getType();
  /**
   * <code>string type = 2;</code>
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>string gender = 3;</code>
   */
  java.lang.String getGender();
  /**
   * <code>string gender = 3;</code>
   */
  com.google.protobuf.ByteString
      getGenderBytes();

  /**
   * <code>repeated string roles = 4;</code>
   */
  java.util.List<java.lang.String>
      getRolesList();
  /**
   * <code>repeated string roles = 4;</code>
   */
  int getRolesCount();
  /**
   * <code>repeated string roles = 4;</code>
   */
  java.lang.String getRoles(int index);
  /**
   * <code>repeated string roles = 4;</code>
   */
  com.google.protobuf.ByteString
      getRolesBytes(int index);

  /**
   * <code>int32 page = 5;</code>
   */
  int getPage();

  /**
   * <code>int32 limit = 6;</code>
   */
  int getLimit();
}

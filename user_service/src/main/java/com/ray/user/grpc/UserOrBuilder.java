// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.ray.user.grpc;

public interface UserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:user.User)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>repeated .user.UserRole roles = 3;</code>
   */
  java.util.List<com.ray.user.grpc.UserRole> 
      getRolesList();
  /**
   * <code>repeated .user.UserRole roles = 3;</code>
   */
  com.ray.user.grpc.UserRole getRoles(int index);
  /**
   * <code>repeated .user.UserRole roles = 3;</code>
   */
  int getRolesCount();
  /**
   * <code>repeated .user.UserRole roles = 3;</code>
   */
  java.util.List<? extends com.ray.user.grpc.UserRoleOrBuilder> 
      getRolesOrBuilderList();
  /**
   * <code>repeated .user.UserRole roles = 3;</code>
   */
  com.ray.user.grpc.UserRoleOrBuilder getRolesOrBuilder(
      int index);

  /**
   * <code>string email = 5;</code>
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 5;</code>
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>string phone = 6;</code>
   */
  java.lang.String getPhone();
  /**
   * <code>string phone = 6;</code>
   */
  com.google.protobuf.ByteString
      getPhoneBytes();

  /**
   * <code>string gender = 7;</code>
   */
  java.lang.String getGender();
  /**
   * <code>string gender = 7;</code>
   */
  com.google.protobuf.ByteString
      getGenderBytes();

  /**
   * <code>string nationality = 8;</code>
   */
  java.lang.String getNationality();
  /**
   * <code>string nationality = 8;</code>
   */
  com.google.protobuf.ByteString
      getNationalityBytes();

  /**
   * <code>string address = 9;</code>
   */
  java.lang.String getAddress();
  /**
   * <code>string address = 9;</code>
   */
  com.google.protobuf.ByteString
      getAddressBytes();

  /**
   * <code>string passportNo = 10;</code>
   */
  java.lang.String getPassportNo();
  /**
   * <code>string passportNo = 10;</code>
   */
  com.google.protobuf.ByteString
      getPassportNoBytes();

  /**
   * <code>string type = 11;</code>
   */
  java.lang.String getType();
  /**
   * <code>string type = 11;</code>
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>string otp = 12;</code>
   */
  java.lang.String getOtp();
  /**
   * <code>string otp = 12;</code>
   */
  com.google.protobuf.ByteString
      getOtpBytes();

  /**
   * <code>string status = 13;</code>
   */
  java.lang.String getStatus();
  /**
   * <code>string status = 13;</code>
   */
  com.google.protobuf.ByteString
      getStatusBytes();

  /**
   * <code>string fileName = 14;</code>
   */
  java.lang.String getFileName();
  /**
   * <code>string fileName = 14;</code>
   */
  com.google.protobuf.ByteString
      getFileNameBytes();

  /**
   * <code>string contentType = 15;</code>
   */
  java.lang.String getContentType();
  /**
   * <code>string contentType = 15;</code>
   */
  com.google.protobuf.ByteString
      getContentTypeBytes();

  /**
   * <code>bytes profilePicture = 16;</code>
   */
  com.google.protobuf.ByteString getProfilePicture();

  /**
   * <code>string password = 17;</code>
   */
  java.lang.String getPassword();
  /**
   * <code>string password = 17;</code>
   */
  com.google.protobuf.ByteString
      getPasswordBytes();

  /**
   * <code>bool loadImage = 18;</code>
   */
  boolean getLoadImage();

  /**
   * <code>string error = 19;</code>
   */
  java.lang.String getError();
  /**
   * <code>string error = 19;</code>
   */
  com.google.protobuf.ByteString
      getErrorBytes();
}

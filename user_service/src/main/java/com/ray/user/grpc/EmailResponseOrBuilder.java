// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: email.proto

package com.ray.user.grpc;

public interface EmailResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:user.EmailResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.user.MailStatus status = 1;</code>
   */
  int getStatusValue();
  /**
   * <code>.user.MailStatus status = 1;</code>
   */
  com.ray.user.grpc.MailStatus getStatus();

  /**
   * <code>string to = 2;</code>
   */
  java.lang.String getTo();
  /**
   * <code>string to = 2;</code>
   */
  com.google.protobuf.ByteString
      getToBytes();

  /**
   * <code>string subject = 3;</code>
   */
  java.lang.String getSubject();
  /**
   * <code>string subject = 3;</code>
   */
  com.google.protobuf.ByteString
      getSubjectBytes();
}

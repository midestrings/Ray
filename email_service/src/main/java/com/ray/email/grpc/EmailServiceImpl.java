// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: email.proto

package com.ray.email.grpc;

public final class EmailServiceImpl {
  private EmailServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_email_Email_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_email_Email_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_email_EmailResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_email_EmailResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013email.proto\022\005email\"@\n\005Email\022\n\n\002to\030\001 \001(" +
      "\t\022\014\n\004from\030\002 \001(\t\022\017\n\007subject\030\003 \001(\t\022\014\n\004body" +
      "\030\004 \001(\t\"O\n\rEmailResponse\022!\n\006status\030\001 \001(\0162" +
      "\021.email.MailStatus\022\n\n\002to\030\002 \001(\t\022\017\n\007subjec" +
      "t\030\003 \001(\t*0\n\nMailStatus\022\010\n\004SENT\020\000\022\t\n\005ERROR" +
      "\020\001\022\r\n\tPERSISTED\020\0022>\n\006Mailer\0224\n\010sendMail\022" +
      "\014.email.Email\032\024.email.EmailResponse\"\000(\0010" +
      "\001B(\n\022com.ray.email.grpcB\020EmailServiceImp" +
      "lP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_email_Email_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_email_Email_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_email_Email_descriptor,
        new java.lang.String[] { "To", "From", "Subject", "Body", });
    internal_static_email_EmailResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_email_EmailResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_email_EmailResponse_descriptor,
        new java.lang.String[] { "Status", "To", "Subject", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.ray.user.grpc;

public final class UserServiceImpl {
  private UserServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_User_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_UserRole_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_UserRole_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_Authentication_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_Authentication_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_Date_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_Date_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_UserFilter_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_UserFilter_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nuser.proto\022\004user\"\256\002\n\004User\022\021\n\tfirstName" +
      "\030\002 \001(\t\022\035\n\005roles\030\003 \003(\0132\016.user.UserRole\022\020\n" +
      "\010lastName\030\004 \001(\t\022\r\n\005email\030\005 \001(\t\022\r\n\005phone\030" +
      "\006 \001(\t\022\016\n\006gender\030\007 \001(\t\022\023\n\013nationality\030\010 \001" +
      "(\t\022\017\n\007address\030\t \001(\t\022\022\n\npassportNo\030\n \001(\t\022" +
      "\014\n\004type\030\013 \001(\t\022\013\n\003otp\030\014 \001(\t\022\016\n\006status\030\r \001" +
      "(\t\022\020\n\010fileName\030\016 \001(\t\022\023\n\013contentType\030\017 \001(" +
      "\t\022\026\n\016profilePicture\030\020 \001(\014\022\020\n\010password\030\021 " +
      "\001(\t\"\030\n\010UserRole\022\014\n\004role\030\002 \001(\t\"l\n\016Authent" +
      "ication\022\r\n\005error\030\001 \001(\t\022\r\n\005token\030\002 \001(\t\022\024\n" +
      "\014refreshToken\030\003 \001(\t\022&\n\022refreshTokenExpir" +
      "y\030\004 \001(\0132\n.user.Date\"0\n\004Date\022\014\n\004year\030\001 \001(" +
      "\005\022\r\n\005month\030\002 \001(\005\022\013\n\003day\030\003 \001(\005\"!\n\nUserFil" +
      "ter\022\023\n\013filterQuery\030\001 \001(\t2\321\002\n\013UserService" +
      "\022&\n\ncreateUser\022\n.user.User\032\n.user.User\"\000" +
      "\022+\n\005login\022\n.user.User\032\024.user.Authenticat" +
      "ion\"\000\022<\n\014refreshToken\022\024.user.Authenticat" +
      "ion\032\024.user.Authentication\"\000\022&\n\nupdateUse" +
      "r\022\n.user.User\032\n.user.User\"\000\022#\n\007getUser\022\n" +
      ".user.User\032\n.user.User\"\000\0222\n\014activateUser" +
      "\022\n.user.User\032\024.user.Authentication\"\000\022.\n\n" +
      "getAllUser\022\020.user.UserFilter\032\n.user.User" +
      "\"\0000\001B&\n\021com.ray.user.grpcB\017UserServiceIm" +
      "plP\001b\006proto3"
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
    internal_static_user_User_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_user_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_User_descriptor,
        new java.lang.String[] { "FirstName", "Roles", "LastName", "Email", "Phone", "Gender", "Nationality", "Address", "PassportNo", "Type", "Otp", "Status", "FileName", "ContentType", "ProfilePicture", "Password", });
    internal_static_user_UserRole_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_user_UserRole_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_UserRole_descriptor,
        new java.lang.String[] { "Role", });
    internal_static_user_Authentication_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_user_Authentication_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_Authentication_descriptor,
        new java.lang.String[] { "Error", "Token", "RefreshToken", "RefreshTokenExpiry", });
    internal_static_user_Date_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_user_Date_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_Date_descriptor,
        new java.lang.String[] { "Year", "Month", "Day", });
    internal_static_user_UserFilter_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_user_UserFilter_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_UserFilter_descriptor,
        new java.lang.String[] { "FilterQuery", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
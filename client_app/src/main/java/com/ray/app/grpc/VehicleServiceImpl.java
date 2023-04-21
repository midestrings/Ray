// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vehicle.proto

package com.ray.app.grpc;

public final class VehicleServiceImpl {
  private VehicleServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_vehicle_Vehicle_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_vehicle_Vehicle_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_vehicle_VehicleCategory_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_vehicle_VehicleCategory_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_vehicle_VehicleFilter_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_vehicle_VehicleFilter_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_vehicle_CategoryFilter_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_vehicle_CategoryFilter_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rvehicle.proto\022\007vehicle\"\351\003\n\007Vehicle\022\014\n\004" +
      "make\030\001 \001(\t\022\r\n\005model\030\002 \001(\t\022\014\n\004year\030\003 \001(\005\022" +
      "\r\n\005color\030\004 \001(\t\022\017\n\007mileage\030\005 \001(\005\022\022\n\nrent_" +
      "price\030\006 \001(\001\022\023\n\013engine_type\030\007 \001(\t\022\021\n\tfuel" +
      "_type\030\010 \001(\t\022\024\n\014transmission\030\t \001(\t\022\022\n\nrid" +
      "e_price\030\n \001(\001\022\020\n\010fileName\030\013 \001(\t\022\r\n\005image" +
      "\030\014 \001(\014\022\022\n\nowner_name\030\r \001(\t\022\023\n\013owner_emai" +
      "l\030\016 \001(\t\022\035\n\025is_available_for_rent\030\017 \001(\010\022%" +
      "\n\035is_available_for_ride_hailing\030\020 \001(\010\022*\n" +
      "\010category\030\021 \001(\0132\030.vehicle.VehicleCategor" +
      "y\022\n\n\002id\030\022 \001(\005\022\020\n\010plate_no\030\023 \001(\t\022\021\n\tbody_" +
      "type\030\024 \001(\t\022\021\n\tloadImage\030\025 \001(\010\022\016\n\006status\030" +
      "\027 \001(\t\022\r\n\005error\030\030 \001(\t\022\016\n\006rating\030\031 \001(\001\"\227\001\n" +
      "\017VehicleCategory\022\014\n\004name\030\001 \001(\t\022\023\n\013descri" +
      "ption\030\002 \001(\t\022\020\n\010fileName\030\003 \001(\t\022\r\n\005image\030\004" +
      " \001(\014\022\n\n\002id\030\006 \001(\005\022\021\n\tloadImage\030\007 \001(\010\022\r\n\005e" +
      "rror\030\010 \001(\t\022\022\n\nownerEmail\030\t \001(\t\"k\n\rVehicl" +
      "eFilter\022\020\n\010byRating\030\001 \001(\010\022\023\n\013byDateAdded" +
      "\030\002 \001(\010\022\r\n\005query\030\003 \001(\t\022\r\n\005limit\030\004 \001(\005\022\025\n\r" +
      "category_name\030\005 \001(\t\".\n\016CategoryFilter\022\r\n" +
      "\005query\030\002 \001(\t\022\r\n\005limit\030\004 \001(\0052\257\003\n\016VehicleS" +
      "ervice\0222\n\naddVehicle\022\020.vehicle.Vehicle\032\020" +
      ".vehicle.Vehicle\"\000\022;\n\013getVehicles\022\026.vehi" +
      "cle.VehicleFilter\032\020.vehicle.Vehicle\"\0000\001\022" +
      ".\n\006update\022\020.vehicle.Vehicle\032\020.vehicle.Ve" +
      "hicle\"\000\022C\n\013addCategory\022\030.vehicle.Vehicle" +
      "Category\032\030.vehicle.VehicleCategory\"\000\022F\n\r" +
      "getCategories\022\027.vehicle.CategoryFilter\032\030" +
      ".vehicle.VehicleCategory\"\0000\001\022;\n\023confirmA" +
      "vailability\022\020.vehicle.Vehicle\032\020.vehicle." +
      "Vehicle\"\000\0222\n\ngetVehicle\022\020.vehicle.Vehicl" +
      "e\032\020.vehicle.Vehicle\"\000B(\n\020com.ray.app.grp" +
      "cB\022VehicleServiceImplP\001b\006proto3"
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
    internal_static_vehicle_Vehicle_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_vehicle_Vehicle_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_vehicle_Vehicle_descriptor,
        new java.lang.String[] { "Make", "Model", "Year", "Color", "Mileage", "RentPrice", "EngineType", "FuelType", "Transmission", "RidePrice", "FileName", "Image", "OwnerName", "OwnerEmail", "IsAvailableForRent", "IsAvailableForRideHailing", "Category", "Id", "PlateNo", "BodyType", "LoadImage", "Status", "Error", "Rating", });
    internal_static_vehicle_VehicleCategory_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_vehicle_VehicleCategory_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_vehicle_VehicleCategory_descriptor,
        new java.lang.String[] { "Name", "Description", "FileName", "Image", "Id", "LoadImage", "Error", "OwnerEmail", });
    internal_static_vehicle_VehicleFilter_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_vehicle_VehicleFilter_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_vehicle_VehicleFilter_descriptor,
        new java.lang.String[] { "ByRating", "ByDateAdded", "Query", "Limit", "CategoryName", });
    internal_static_vehicle_CategoryFilter_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_vehicle_CategoryFilter_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_vehicle_CategoryFilter_descriptor,
        new java.lang.String[] { "Query", "Limit", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

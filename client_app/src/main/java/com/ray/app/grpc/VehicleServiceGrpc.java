package com.ray.app.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: vehicle.proto")
public final class VehicleServiceGrpc {

  private VehicleServiceGrpc() {}

  public static final String SERVICE_NAME = "vehicle.VehicleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle,
      com.ray.app.grpc.Vehicle> getAddVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addVehicle",
      requestType = com.ray.app.grpc.Vehicle.class,
      responseType = com.ray.app.grpc.Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle,
      com.ray.app.grpc.Vehicle> getAddVehicleMethod() {
    io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle, com.ray.app.grpc.Vehicle> getAddVehicleMethod;
    if ((getAddVehicleMethod = VehicleServiceGrpc.getAddVehicleMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getAddVehicleMethod = VehicleServiceGrpc.getAddVehicleMethod) == null) {
          VehicleServiceGrpc.getAddVehicleMethod = getAddVehicleMethod = 
              io.grpc.MethodDescriptor.<com.ray.app.grpc.Vehicle, com.ray.app.grpc.Vehicle>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vehicle.VehicleService", "addVehicle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.Vehicle.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.Vehicle.getDefaultInstance()))
                  .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("addVehicle"))
                  .build();
          }
        }
     }
     return getAddVehicleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.app.grpc.VehicleFilter,
      com.ray.app.grpc.Vehicle> getGetVehiclesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVehicles",
      requestType = com.ray.app.grpc.VehicleFilter.class,
      responseType = com.ray.app.grpc.Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ray.app.grpc.VehicleFilter,
      com.ray.app.grpc.Vehicle> getGetVehiclesMethod() {
    io.grpc.MethodDescriptor<com.ray.app.grpc.VehicleFilter, com.ray.app.grpc.Vehicle> getGetVehiclesMethod;
    if ((getGetVehiclesMethod = VehicleServiceGrpc.getGetVehiclesMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getGetVehiclesMethod = VehicleServiceGrpc.getGetVehiclesMethod) == null) {
          VehicleServiceGrpc.getGetVehiclesMethod = getGetVehiclesMethod = 
              io.grpc.MethodDescriptor.<com.ray.app.grpc.VehicleFilter, com.ray.app.grpc.Vehicle>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "vehicle.VehicleService", "getVehicles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.VehicleFilter.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.Vehicle.getDefaultInstance()))
                  .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("getVehicles"))
                  .build();
          }
        }
     }
     return getGetVehiclesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle,
      com.ray.app.grpc.Vehicle> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = com.ray.app.grpc.Vehicle.class,
      responseType = com.ray.app.grpc.Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle,
      com.ray.app.grpc.Vehicle> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle, com.ray.app.grpc.Vehicle> getUpdateMethod;
    if ((getUpdateMethod = VehicleServiceGrpc.getUpdateMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getUpdateMethod = VehicleServiceGrpc.getUpdateMethod) == null) {
          VehicleServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.ray.app.grpc.Vehicle, com.ray.app.grpc.Vehicle>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vehicle.VehicleService", "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.Vehicle.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.Vehicle.getDefaultInstance()))
                  .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.app.grpc.VehicleCategory,
      com.ray.app.grpc.VehicleCategory> getAddCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addCategory",
      requestType = com.ray.app.grpc.VehicleCategory.class,
      responseType = com.ray.app.grpc.VehicleCategory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.app.grpc.VehicleCategory,
      com.ray.app.grpc.VehicleCategory> getAddCategoryMethod() {
    io.grpc.MethodDescriptor<com.ray.app.grpc.VehicleCategory, com.ray.app.grpc.VehicleCategory> getAddCategoryMethod;
    if ((getAddCategoryMethod = VehicleServiceGrpc.getAddCategoryMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getAddCategoryMethod = VehicleServiceGrpc.getAddCategoryMethod) == null) {
          VehicleServiceGrpc.getAddCategoryMethod = getAddCategoryMethod = 
              io.grpc.MethodDescriptor.<com.ray.app.grpc.VehicleCategory, com.ray.app.grpc.VehicleCategory>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vehicle.VehicleService", "addCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.VehicleCategory.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.VehicleCategory.getDefaultInstance()))
                  .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("addCategory"))
                  .build();
          }
        }
     }
     return getAddCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.app.grpc.CategoryFilter,
      com.ray.app.grpc.VehicleCategory> getGetCategoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCategories",
      requestType = com.ray.app.grpc.CategoryFilter.class,
      responseType = com.ray.app.grpc.VehicleCategory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ray.app.grpc.CategoryFilter,
      com.ray.app.grpc.VehicleCategory> getGetCategoriesMethod() {
    io.grpc.MethodDescriptor<com.ray.app.grpc.CategoryFilter, com.ray.app.grpc.VehicleCategory> getGetCategoriesMethod;
    if ((getGetCategoriesMethod = VehicleServiceGrpc.getGetCategoriesMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getGetCategoriesMethod = VehicleServiceGrpc.getGetCategoriesMethod) == null) {
          VehicleServiceGrpc.getGetCategoriesMethod = getGetCategoriesMethod = 
              io.grpc.MethodDescriptor.<com.ray.app.grpc.CategoryFilter, com.ray.app.grpc.VehicleCategory>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "vehicle.VehicleService", "getCategories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.CategoryFilter.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.VehicleCategory.getDefaultInstance()))
                  .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("getCategories"))
                  .build();
          }
        }
     }
     return getGetCategoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle,
      com.ray.app.grpc.Vehicle> getConfirmAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "confirmAvailability",
      requestType = com.ray.app.grpc.Vehicle.class,
      responseType = com.ray.app.grpc.Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle,
      com.ray.app.grpc.Vehicle> getConfirmAvailabilityMethod() {
    io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle, com.ray.app.grpc.Vehicle> getConfirmAvailabilityMethod;
    if ((getConfirmAvailabilityMethod = VehicleServiceGrpc.getConfirmAvailabilityMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getConfirmAvailabilityMethod = VehicleServiceGrpc.getConfirmAvailabilityMethod) == null) {
          VehicleServiceGrpc.getConfirmAvailabilityMethod = getConfirmAvailabilityMethod = 
              io.grpc.MethodDescriptor.<com.ray.app.grpc.Vehicle, com.ray.app.grpc.Vehicle>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vehicle.VehicleService", "confirmAvailability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.Vehicle.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.Vehicle.getDefaultInstance()))
                  .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("confirmAvailability"))
                  .build();
          }
        }
     }
     return getConfirmAvailabilityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle,
      com.ray.app.grpc.Vehicle> getGetVehicleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVehicle",
      requestType = com.ray.app.grpc.Vehicle.class,
      responseType = com.ray.app.grpc.Vehicle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle,
      com.ray.app.grpc.Vehicle> getGetVehicleMethod() {
    io.grpc.MethodDescriptor<com.ray.app.grpc.Vehicle, com.ray.app.grpc.Vehicle> getGetVehicleMethod;
    if ((getGetVehicleMethod = VehicleServiceGrpc.getGetVehicleMethod) == null) {
      synchronized (VehicleServiceGrpc.class) {
        if ((getGetVehicleMethod = VehicleServiceGrpc.getGetVehicleMethod) == null) {
          VehicleServiceGrpc.getGetVehicleMethod = getGetVehicleMethod = 
              io.grpc.MethodDescriptor.<com.ray.app.grpc.Vehicle, com.ray.app.grpc.Vehicle>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vehicle.VehicleService", "getVehicle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.Vehicle.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.app.grpc.Vehicle.getDefaultInstance()))
                  .setSchemaDescriptor(new VehicleServiceMethodDescriptorSupplier("getVehicle"))
                  .build();
          }
        }
     }
     return getGetVehicleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VehicleServiceStub newStub(io.grpc.Channel channel) {
    return new VehicleServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VehicleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VehicleServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VehicleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VehicleServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class VehicleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addVehicle(com.ray.app.grpc.Vehicle request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle> responseObserver) {
      asyncUnimplementedUnaryCall(getAddVehicleMethod(), responseObserver);
    }

    /**
     */
    public void getVehicles(com.ray.app.grpc.VehicleFilter request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVehiclesMethod(), responseObserver);
    }

    /**
     */
    public void update(com.ray.app.grpc.Vehicle request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void addCategory(com.ray.app.grpc.VehicleCategory request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.VehicleCategory> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCategoryMethod(), responseObserver);
    }

    /**
     */
    public void getCategories(com.ray.app.grpc.CategoryFilter request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.VehicleCategory> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCategoriesMethod(), responseObserver);
    }

    /**
     */
    public void confirmAvailability(com.ray.app.grpc.Vehicle request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle> responseObserver) {
      asyncUnimplementedUnaryCall(getConfirmAvailabilityMethod(), responseObserver);
    }

    /**
     */
    public void getVehicle(com.ray.app.grpc.Vehicle request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVehicleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddVehicleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.app.grpc.Vehicle,
                com.ray.app.grpc.Vehicle>(
                  this, METHODID_ADD_VEHICLE)))
          .addMethod(
            getGetVehiclesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ray.app.grpc.VehicleFilter,
                com.ray.app.grpc.Vehicle>(
                  this, METHODID_GET_VEHICLES)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.app.grpc.Vehicle,
                com.ray.app.grpc.Vehicle>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getAddCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.app.grpc.VehicleCategory,
                com.ray.app.grpc.VehicleCategory>(
                  this, METHODID_ADD_CATEGORY)))
          .addMethod(
            getGetCategoriesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ray.app.grpc.CategoryFilter,
                com.ray.app.grpc.VehicleCategory>(
                  this, METHODID_GET_CATEGORIES)))
          .addMethod(
            getConfirmAvailabilityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.app.grpc.Vehicle,
                com.ray.app.grpc.Vehicle>(
                  this, METHODID_CONFIRM_AVAILABILITY)))
          .addMethod(
            getGetVehicleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.app.grpc.Vehicle,
                com.ray.app.grpc.Vehicle>(
                  this, METHODID_GET_VEHICLE)))
          .build();
    }
  }

  /**
   */
  public static final class VehicleServiceStub extends io.grpc.stub.AbstractStub<VehicleServiceStub> {
    private VehicleServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VehicleServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VehicleServiceStub(channel, callOptions);
    }

    /**
     */
    public void addVehicle(com.ray.app.grpc.Vehicle request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddVehicleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVehicles(com.ray.app.grpc.VehicleFilter request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetVehiclesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.ray.app.grpc.Vehicle request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCategory(com.ray.app.grpc.VehicleCategory request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.VehicleCategory> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCategories(com.ray.app.grpc.CategoryFilter request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.VehicleCategory> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetCategoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void confirmAvailability(com.ray.app.grpc.Vehicle request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConfirmAvailabilityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVehicle(com.ray.app.grpc.Vehicle request,
        io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVehicleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VehicleServiceBlockingStub extends io.grpc.stub.AbstractStub<VehicleServiceBlockingStub> {
    private VehicleServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VehicleServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VehicleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ray.app.grpc.Vehicle addVehicle(com.ray.app.grpc.Vehicle request) {
      return blockingUnaryCall(
          getChannel(), getAddVehicleMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.ray.app.grpc.Vehicle> getVehicles(
        com.ray.app.grpc.VehicleFilter request) {
      return blockingServerStreamingCall(
          getChannel(), getGetVehiclesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.app.grpc.Vehicle update(com.ray.app.grpc.Vehicle request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.app.grpc.VehicleCategory addCategory(com.ray.app.grpc.VehicleCategory request) {
      return blockingUnaryCall(
          getChannel(), getAddCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.ray.app.grpc.VehicleCategory> getCategories(
        com.ray.app.grpc.CategoryFilter request) {
      return blockingServerStreamingCall(
          getChannel(), getGetCategoriesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.app.grpc.Vehicle confirmAvailability(com.ray.app.grpc.Vehicle request) {
      return blockingUnaryCall(
          getChannel(), getConfirmAvailabilityMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.app.grpc.Vehicle getVehicle(com.ray.app.grpc.Vehicle request) {
      return blockingUnaryCall(
          getChannel(), getGetVehicleMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VehicleServiceFutureStub extends io.grpc.stub.AbstractStub<VehicleServiceFutureStub> {
    private VehicleServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VehicleServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VehicleServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VehicleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.app.grpc.Vehicle> addVehicle(
        com.ray.app.grpc.Vehicle request) {
      return futureUnaryCall(
          getChannel().newCall(getAddVehicleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.app.grpc.Vehicle> update(
        com.ray.app.grpc.Vehicle request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.app.grpc.VehicleCategory> addCategory(
        com.ray.app.grpc.VehicleCategory request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.app.grpc.Vehicle> confirmAvailability(
        com.ray.app.grpc.Vehicle request) {
      return futureUnaryCall(
          getChannel().newCall(getConfirmAvailabilityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.app.grpc.Vehicle> getVehicle(
        com.ray.app.grpc.Vehicle request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVehicleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_VEHICLE = 0;
  private static final int METHODID_GET_VEHICLES = 1;
  private static final int METHODID_UPDATE = 2;
  private static final int METHODID_ADD_CATEGORY = 3;
  private static final int METHODID_GET_CATEGORIES = 4;
  private static final int METHODID_CONFIRM_AVAILABILITY = 5;
  private static final int METHODID_GET_VEHICLE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VehicleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VehicleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_VEHICLE:
          serviceImpl.addVehicle((com.ray.app.grpc.Vehicle) request,
              (io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle>) responseObserver);
          break;
        case METHODID_GET_VEHICLES:
          serviceImpl.getVehicles((com.ray.app.grpc.VehicleFilter) request,
              (io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.ray.app.grpc.Vehicle) request,
              (io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle>) responseObserver);
          break;
        case METHODID_ADD_CATEGORY:
          serviceImpl.addCategory((com.ray.app.grpc.VehicleCategory) request,
              (io.grpc.stub.StreamObserver<com.ray.app.grpc.VehicleCategory>) responseObserver);
          break;
        case METHODID_GET_CATEGORIES:
          serviceImpl.getCategories((com.ray.app.grpc.CategoryFilter) request,
              (io.grpc.stub.StreamObserver<com.ray.app.grpc.VehicleCategory>) responseObserver);
          break;
        case METHODID_CONFIRM_AVAILABILITY:
          serviceImpl.confirmAvailability((com.ray.app.grpc.Vehicle) request,
              (io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle>) responseObserver);
          break;
        case METHODID_GET_VEHICLE:
          serviceImpl.getVehicle((com.ray.app.grpc.Vehicle) request,
              (io.grpc.stub.StreamObserver<com.ray.app.grpc.Vehicle>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class VehicleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VehicleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ray.app.grpc.VehicleServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VehicleService");
    }
  }

  private static final class VehicleServiceFileDescriptorSupplier
      extends VehicleServiceBaseDescriptorSupplier {
    VehicleServiceFileDescriptorSupplier() {}
  }

  private static final class VehicleServiceMethodDescriptorSupplier
      extends VehicleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VehicleServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (VehicleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VehicleServiceFileDescriptorSupplier())
              .addMethod(getAddVehicleMethod())
              .addMethod(getGetVehiclesMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getAddCategoryMethod())
              .addMethod(getGetCategoriesMethod())
              .addMethod(getConfirmAvailabilityMethod())
              .addMethod(getGetVehicleMethod())
              .build();
        }
      }
    }
    return result;
  }
}

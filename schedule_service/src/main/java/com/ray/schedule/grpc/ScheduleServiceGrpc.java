package com.ray.schedule.grpc;

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
    comments = "Source: schedule.proto")
public final class ScheduleServiceGrpc {

  private ScheduleServiceGrpc() {}

  public static final String SERVICE_NAME = "schedule.ScheduleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.Reservation,
      com.ray.schedule.grpc.Reservation> getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createReservation",
      requestType = com.ray.schedule.grpc.Reservation.class,
      responseType = com.ray.schedule.grpc.Reservation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.Reservation,
      com.ray.schedule.grpc.Reservation> getCreateReservationMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.Reservation, com.ray.schedule.grpc.Reservation> getCreateReservationMethod;
    if ((getCreateReservationMethod = ScheduleServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getCreateReservationMethod = ScheduleServiceGrpc.getCreateReservationMethod) == null) {
          ScheduleServiceGrpc.getCreateReservationMethod = getCreateReservationMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.Reservation, com.ray.schedule.grpc.Reservation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "schedule.ScheduleService", "createReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Reservation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Reservation.getDefaultInstance()))
                  .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("createReservation"))
                  .build();
          }
        }
     }
     return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.ReservationFilter,
      com.ray.schedule.grpc.Reservation> getGetReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getReservations",
      requestType = com.ray.schedule.grpc.ReservationFilter.class,
      responseType = com.ray.schedule.grpc.Reservation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.ReservationFilter,
      com.ray.schedule.grpc.Reservation> getGetReservationsMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.ReservationFilter, com.ray.schedule.grpc.Reservation> getGetReservationsMethod;
    if ((getGetReservationsMethod = ScheduleServiceGrpc.getGetReservationsMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getGetReservationsMethod = ScheduleServiceGrpc.getGetReservationsMethod) == null) {
          ScheduleServiceGrpc.getGetReservationsMethod = getGetReservationsMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.ReservationFilter, com.ray.schedule.grpc.Reservation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "schedule.ScheduleService", "getReservations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.ReservationFilter.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Reservation.getDefaultInstance()))
                  .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("getReservations"))
                  .build();
          }
        }
     }
     return getGetReservationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.Reservation,
      com.ray.schedule.grpc.Reservation> getUpdateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateReservation",
      requestType = com.ray.schedule.grpc.Reservation.class,
      responseType = com.ray.schedule.grpc.Reservation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.Reservation,
      com.ray.schedule.grpc.Reservation> getUpdateReservationMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.Reservation, com.ray.schedule.grpc.Reservation> getUpdateReservationMethod;
    if ((getUpdateReservationMethod = ScheduleServiceGrpc.getUpdateReservationMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getUpdateReservationMethod = ScheduleServiceGrpc.getUpdateReservationMethod) == null) {
          ScheduleServiceGrpc.getUpdateReservationMethod = getUpdateReservationMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.Reservation, com.ray.schedule.grpc.Reservation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "schedule.ScheduleService", "updateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Reservation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Reservation.getDefaultInstance()))
                  .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("updateReservation"))
                  .build();
          }
        }
     }
     return getUpdateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.Reservation,
      com.ray.schedule.grpc.Reservation> getGetReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getReservation",
      requestType = com.ray.schedule.grpc.Reservation.class,
      responseType = com.ray.schedule.grpc.Reservation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.Reservation,
      com.ray.schedule.grpc.Reservation> getGetReservationMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.Reservation, com.ray.schedule.grpc.Reservation> getGetReservationMethod;
    if ((getGetReservationMethod = ScheduleServiceGrpc.getGetReservationMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getGetReservationMethod = ScheduleServiceGrpc.getGetReservationMethod) == null) {
          ScheduleServiceGrpc.getGetReservationMethod = getGetReservationMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.Reservation, com.ray.schedule.grpc.Reservation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "schedule.ScheduleService", "getReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Reservation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Reservation.getDefaultInstance()))
                  .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("getReservation"))
                  .build();
          }
        }
     }
     return getGetReservationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ScheduleServiceStub newStub(io.grpc.Channel channel) {
    return new ScheduleServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ScheduleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ScheduleServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ScheduleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ScheduleServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ScheduleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createReservation(com.ray.schedule.grpc.Reservation request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /**
     */
    public void getReservations(com.ray.schedule.grpc.ReservationFilter request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationsMethod(), responseObserver);
    }

    /**
     */
    public void updateReservation(com.ray.schedule.grpc.Reservation request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateReservationMethod(), responseObserver);
    }

    /**
     */
    public void getReservation(com.ray.schedule.grpc.Reservation request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.schedule.grpc.Reservation,
                com.ray.schedule.grpc.Reservation>(
                  this, METHODID_CREATE_RESERVATION)))
          .addMethod(
            getGetReservationsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ray.schedule.grpc.ReservationFilter,
                com.ray.schedule.grpc.Reservation>(
                  this, METHODID_GET_RESERVATIONS)))
          .addMethod(
            getUpdateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.schedule.grpc.Reservation,
                com.ray.schedule.grpc.Reservation>(
                  this, METHODID_UPDATE_RESERVATION)))
          .addMethod(
            getGetReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.schedule.grpc.Reservation,
                com.ray.schedule.grpc.Reservation>(
                  this, METHODID_GET_RESERVATION)))
          .build();
    }
  }

  /**
   */
  public static final class ScheduleServiceStub extends io.grpc.stub.AbstractStub<ScheduleServiceStub> {
    private ScheduleServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScheduleServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScheduleServiceStub(channel, callOptions);
    }

    /**
     */
    public void createReservation(com.ray.schedule.grpc.Reservation request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservations(com.ray.schedule.grpc.ReservationFilter request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetReservationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateReservation(com.ray.schedule.grpc.Reservation request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservation(com.ray.schedule.grpc.Reservation request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ScheduleServiceBlockingStub extends io.grpc.stub.AbstractStub<ScheduleServiceBlockingStub> {
    private ScheduleServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScheduleServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScheduleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ray.schedule.grpc.Reservation createReservation(com.ray.schedule.grpc.Reservation request) {
      return blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.ray.schedule.grpc.Reservation> getReservations(
        com.ray.schedule.grpc.ReservationFilter request) {
      return blockingServerStreamingCall(
          getChannel(), getGetReservationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.schedule.grpc.Reservation updateReservation(com.ray.schedule.grpc.Reservation request) {
      return blockingUnaryCall(
          getChannel(), getUpdateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.schedule.grpc.Reservation getReservation(com.ray.schedule.grpc.Reservation request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ScheduleServiceFutureStub extends io.grpc.stub.AbstractStub<ScheduleServiceFutureStub> {
    private ScheduleServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScheduleServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScheduleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.schedule.grpc.Reservation> createReservation(
        com.ray.schedule.grpc.Reservation request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.schedule.grpc.Reservation> updateReservation(
        com.ray.schedule.grpc.Reservation request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.schedule.grpc.Reservation> getReservation(
        com.ray.schedule.grpc.Reservation request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RESERVATION = 0;
  private static final int METHODID_GET_RESERVATIONS = 1;
  private static final int METHODID_UPDATE_RESERVATION = 2;
  private static final int METHODID_GET_RESERVATION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ScheduleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ScheduleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation((com.ray.schedule.grpc.Reservation) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation>) responseObserver);
          break;
        case METHODID_GET_RESERVATIONS:
          serviceImpl.getReservations((com.ray.schedule.grpc.ReservationFilter) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation>) responseObserver);
          break;
        case METHODID_UPDATE_RESERVATION:
          serviceImpl.updateReservation((com.ray.schedule.grpc.Reservation) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation>) responseObserver);
          break;
        case METHODID_GET_RESERVATION:
          serviceImpl.getReservation((com.ray.schedule.grpc.Reservation) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Reservation>) responseObserver);
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

  private static abstract class ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ScheduleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ray.schedule.grpc.ScheduleServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ScheduleService");
    }
  }

  private static final class ScheduleServiceFileDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier {
    ScheduleServiceFileDescriptorSupplier() {}
  }

  private static final class ScheduleServiceMethodDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ScheduleServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ScheduleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ScheduleServiceFileDescriptorSupplier())
              .addMethod(getCreateReservationMethod())
              .addMethod(getGetReservationsMethod())
              .addMethod(getUpdateReservationMethod())
              .addMethod(getGetReservationMethod())
              .build();
        }
      }
    }
    return result;
  }
}

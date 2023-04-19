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
    comments = "Source: user.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "user.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.User> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createUser",
      requestType = com.ray.schedule.grpc.User.class,
      responseType = com.ray.schedule.grpc.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.User> getCreateUserMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.User, com.ray.schedule.grpc.User> getCreateUserMethod;
    if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
          UserServiceGrpc.getCreateUserMethod = getCreateUserMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.User, com.ray.schedule.grpc.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "createUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.User.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("createUser"))
                  .build();
          }
        }
     }
     return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.Authentication> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = com.ray.schedule.grpc.User.class,
      responseType = com.ray.schedule.grpc.Authentication.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.Authentication> getLoginMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.User, com.ray.schedule.grpc.Authentication> getLoginMethod;
    if ((getLoginMethod = UserServiceGrpc.getLoginMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getLoginMethod = UserServiceGrpc.getLoginMethod) == null) {
          UserServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.User, com.ray.schedule.grpc.Authentication>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Authentication.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.Authentication,
      com.ray.schedule.grpc.Authentication> getRefreshTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "refreshToken",
      requestType = com.ray.schedule.grpc.Authentication.class,
      responseType = com.ray.schedule.grpc.Authentication.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.Authentication,
      com.ray.schedule.grpc.Authentication> getRefreshTokenMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.Authentication, com.ray.schedule.grpc.Authentication> getRefreshTokenMethod;
    if ((getRefreshTokenMethod = UserServiceGrpc.getRefreshTokenMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRefreshTokenMethod = UserServiceGrpc.getRefreshTokenMethod) == null) {
          UserServiceGrpc.getRefreshTokenMethod = getRefreshTokenMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.Authentication, com.ray.schedule.grpc.Authentication>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "refreshToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Authentication.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Authentication.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("refreshToken"))
                  .build();
          }
        }
     }
     return getRefreshTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.User> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateUser",
      requestType = com.ray.schedule.grpc.User.class,
      responseType = com.ray.schedule.grpc.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.User> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.User, com.ray.schedule.grpc.User> getUpdateUserMethod;
    if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUpdateUserMethod = UserServiceGrpc.getUpdateUserMethod) == null) {
          UserServiceGrpc.getUpdateUserMethod = getUpdateUserMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.User, com.ray.schedule.grpc.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "updateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.User.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("updateUser"))
                  .build();
          }
        }
     }
     return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.User> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUser",
      requestType = com.ray.schedule.grpc.User.class,
      responseType = com.ray.schedule.grpc.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.User> getGetUserMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.User, com.ray.schedule.grpc.User> getGetUserMethod;
    if ((getGetUserMethod = UserServiceGrpc.getGetUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserMethod = UserServiceGrpc.getGetUserMethod) == null) {
          UserServiceGrpc.getGetUserMethod = getGetUserMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.User, com.ray.schedule.grpc.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "getUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.User.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("getUser"))
                  .build();
          }
        }
     }
     return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.Authentication> getActivateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "activateUser",
      requestType = com.ray.schedule.grpc.User.class,
      responseType = com.ray.schedule.grpc.Authentication.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.Authentication> getActivateUserMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.User, com.ray.schedule.grpc.Authentication> getActivateUserMethod;
    if ((getActivateUserMethod = UserServiceGrpc.getActivateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getActivateUserMethod = UserServiceGrpc.getActivateUserMethod) == null) {
          UserServiceGrpc.getActivateUserMethod = getActivateUserMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.User, com.ray.schedule.grpc.Authentication>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "activateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Authentication.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("activateUser"))
                  .build();
          }
        }
     }
     return getActivateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.UserFilter,
      com.ray.schedule.grpc.User> getGetAllUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllUser",
      requestType = com.ray.schedule.grpc.UserFilter.class,
      responseType = com.ray.schedule.grpc.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.UserFilter,
      com.ray.schedule.grpc.User> getGetAllUserMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.UserFilter, com.ray.schedule.grpc.User> getGetAllUserMethod;
    if ((getGetAllUserMethod = UserServiceGrpc.getGetAllUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetAllUserMethod = UserServiceGrpc.getGetAllUserMethod) == null) {
          UserServiceGrpc.getGetAllUserMethod = getGetAllUserMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.UserFilter, com.ray.schedule.grpc.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "getAllUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.UserFilter.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.User.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("getAllUser"))
                  .build();
          }
        }
     }
     return getGetAllUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.Authentication> getResendOTPMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "resendOTP",
      requestType = com.ray.schedule.grpc.User.class,
      responseType = com.ray.schedule.grpc.Authentication.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.User,
      com.ray.schedule.grpc.Authentication> getResendOTPMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.User, com.ray.schedule.grpc.Authentication> getResendOTPMethod;
    if ((getResendOTPMethod = UserServiceGrpc.getResendOTPMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getResendOTPMethod = UserServiceGrpc.getResendOTPMethod) == null) {
          UserServiceGrpc.getResendOTPMethod = getResendOTPMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.User, com.ray.schedule.grpc.Authentication>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserService", "resendOTP"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Authentication.getDefaultInstance()))
                  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("resendOTP"))
                  .build();
          }
        }
     }
     return getResendOTPMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createUser(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    public void login(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void refreshToken(com.ray.schedule.grpc.Authentication request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication> responseObserver) {
      asyncUnimplementedUnaryCall(getRefreshTokenMethod(), responseObserver);
    }

    /**
     */
    public void updateUser(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     */
    public void getUser(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     */
    public void activateUser(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication> responseObserver) {
      asyncUnimplementedUnaryCall(getActivateUserMethod(), responseObserver);
    }

    /**
     */
    public void getAllUser(com.ray.schedule.grpc.UserFilter request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllUserMethod(), responseObserver);
    }

    /**
     */
    public void resendOTP(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication> responseObserver) {
      asyncUnimplementedUnaryCall(getResendOTPMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.schedule.grpc.User,
                com.ray.schedule.grpc.User>(
                  this, METHODID_CREATE_USER)))
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.schedule.grpc.User,
                com.ray.schedule.grpc.Authentication>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getRefreshTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.schedule.grpc.Authentication,
                com.ray.schedule.grpc.Authentication>(
                  this, METHODID_REFRESH_TOKEN)))
          .addMethod(
            getUpdateUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.schedule.grpc.User,
                com.ray.schedule.grpc.User>(
                  this, METHODID_UPDATE_USER)))
          .addMethod(
            getGetUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.schedule.grpc.User,
                com.ray.schedule.grpc.User>(
                  this, METHODID_GET_USER)))
          .addMethod(
            getActivateUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.schedule.grpc.User,
                com.ray.schedule.grpc.Authentication>(
                  this, METHODID_ACTIVATE_USER)))
          .addMethod(
            getGetAllUserMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ray.schedule.grpc.UserFilter,
                com.ray.schedule.grpc.User>(
                  this, METHODID_GET_ALL_USER)))
          .addMethod(
            getResendOTPMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ray.schedule.grpc.User,
                com.ray.schedule.grpc.Authentication>(
                  this, METHODID_RESEND_OTP)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void refreshToken(com.ray.schedule.grpc.Authentication request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRefreshTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUser(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void activateUser(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getActivateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllUser(com.ray.schedule.grpc.UserFilter request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void resendOTP(com.ray.schedule.grpc.User request,
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResendOTPMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ray.schedule.grpc.User createUser(com.ray.schedule.grpc.User request) {
      return blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.schedule.grpc.Authentication login(com.ray.schedule.grpc.User request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.schedule.grpc.Authentication refreshToken(com.ray.schedule.grpc.Authentication request) {
      return blockingUnaryCall(
          getChannel(), getRefreshTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.schedule.grpc.User updateUser(com.ray.schedule.grpc.User request) {
      return blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.schedule.grpc.User getUser(com.ray.schedule.grpc.User request) {
      return blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.schedule.grpc.Authentication activateUser(com.ray.schedule.grpc.User request) {
      return blockingUnaryCall(
          getChannel(), getActivateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.ray.schedule.grpc.User> getAllUser(
        com.ray.schedule.grpc.UserFilter request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ray.schedule.grpc.Authentication resendOTP(com.ray.schedule.grpc.User request) {
      return blockingUnaryCall(
          getChannel(), getResendOTPMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.schedule.grpc.User> createUser(
        com.ray.schedule.grpc.User request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.schedule.grpc.Authentication> login(
        com.ray.schedule.grpc.User request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.schedule.grpc.Authentication> refreshToken(
        com.ray.schedule.grpc.Authentication request) {
      return futureUnaryCall(
          getChannel().newCall(getRefreshTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.schedule.grpc.User> updateUser(
        com.ray.schedule.grpc.User request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.schedule.grpc.User> getUser(
        com.ray.schedule.grpc.User request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.schedule.grpc.Authentication> activateUser(
        com.ray.schedule.grpc.User request) {
      return futureUnaryCall(
          getChannel().newCall(getActivateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ray.schedule.grpc.Authentication> resendOTP(
        com.ray.schedule.grpc.User request) {
      return futureUnaryCall(
          getChannel().newCall(getResendOTPMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_LOGIN = 1;
  private static final int METHODID_REFRESH_TOKEN = 2;
  private static final int METHODID_UPDATE_USER = 3;
  private static final int METHODID_GET_USER = 4;
  private static final int METHODID_ACTIVATE_USER = 5;
  private static final int METHODID_GET_ALL_USER = 6;
  private static final int METHODID_RESEND_OTP = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER:
          serviceImpl.createUser((com.ray.schedule.grpc.User) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.ray.schedule.grpc.User) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication>) responseObserver);
          break;
        case METHODID_REFRESH_TOKEN:
          serviceImpl.refreshToken((com.ray.schedule.grpc.Authentication) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((com.ray.schedule.grpc.User) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User>) responseObserver);
          break;
        case METHODID_GET_USER:
          serviceImpl.getUser((com.ray.schedule.grpc.User) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User>) responseObserver);
          break;
        case METHODID_ACTIVATE_USER:
          serviceImpl.activateUser((com.ray.schedule.grpc.User) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication>) responseObserver);
          break;
        case METHODID_GET_ALL_USER:
          serviceImpl.getAllUser((com.ray.schedule.grpc.UserFilter) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.User>) responseObserver);
          break;
        case METHODID_RESEND_OTP:
          serviceImpl.resendOTP((com.ray.schedule.grpc.User) request,
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Authentication>) responseObserver);
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

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ray.schedule.grpc.UserServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getCreateUserMethod())
              .addMethod(getLoginMethod())
              .addMethod(getRefreshTokenMethod())
              .addMethod(getUpdateUserMethod())
              .addMethod(getGetUserMethod())
              .addMethod(getActivateUserMethod())
              .addMethod(getGetAllUserMethod())
              .addMethod(getResendOTPMethod())
              .build();
        }
      }
    }
    return result;
  }
}

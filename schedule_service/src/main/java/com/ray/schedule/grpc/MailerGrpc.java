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
    comments = "Source: email.proto")
public final class MailerGrpc {

  private MailerGrpc() {}

  public static final String SERVICE_NAME = "email.Mailer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ray.schedule.grpc.Email,
      com.ray.schedule.grpc.EmailResponse> getSendMailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMail",
      requestType = com.ray.schedule.grpc.Email.class,
      responseType = com.ray.schedule.grpc.EmailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.ray.schedule.grpc.Email,
      com.ray.schedule.grpc.EmailResponse> getSendMailMethod() {
    io.grpc.MethodDescriptor<com.ray.schedule.grpc.Email, com.ray.schedule.grpc.EmailResponse> getSendMailMethod;
    if ((getSendMailMethod = MailerGrpc.getSendMailMethod) == null) {
      synchronized (MailerGrpc.class) {
        if ((getSendMailMethod = MailerGrpc.getSendMailMethod) == null) {
          MailerGrpc.getSendMailMethod = getSendMailMethod = 
              io.grpc.MethodDescriptor.<com.ray.schedule.grpc.Email, com.ray.schedule.grpc.EmailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "email.Mailer", "sendMail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.Email.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ray.schedule.grpc.EmailResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MailerMethodDescriptorSupplier("sendMail"))
                  .build();
          }
        }
     }
     return getSendMailMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MailerStub newStub(io.grpc.Channel channel) {
    return new MailerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MailerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MailerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MailerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MailerFutureStub(channel);
  }

  /**
   */
  public static abstract class MailerImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Email> sendMail(
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.EmailResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendMailMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMailMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.ray.schedule.grpc.Email,
                com.ray.schedule.grpc.EmailResponse>(
                  this, METHODID_SEND_MAIL)))
          .build();
    }
  }

  /**
   */
  public static final class MailerStub extends io.grpc.stub.AbstractStub<MailerStub> {
    private MailerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MailerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MailerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MailerStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.ray.schedule.grpc.Email> sendMail(
        io.grpc.stub.StreamObserver<com.ray.schedule.grpc.EmailResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendMailMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class MailerBlockingStub extends io.grpc.stub.AbstractStub<MailerBlockingStub> {
    private MailerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MailerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MailerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MailerBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class MailerFutureStub extends io.grpc.stub.AbstractStub<MailerFutureStub> {
    private MailerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MailerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MailerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MailerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_MAIL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MailerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MailerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MAIL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendMail(
              (io.grpc.stub.StreamObserver<com.ray.schedule.grpc.EmailResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MailerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MailerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ray.schedule.grpc.EmailServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Mailer");
    }
  }

  private static final class MailerFileDescriptorSupplier
      extends MailerBaseDescriptorSupplier {
    MailerFileDescriptorSupplier() {}
  }

  private static final class MailerMethodDescriptorSupplier
      extends MailerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MailerMethodDescriptorSupplier(String methodName) {
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
      synchronized (MailerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MailerFileDescriptorSupplier())
              .addMethod(getSendMailMethod())
              .build();
        }
      }
    }
    return result;
  }
}

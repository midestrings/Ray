// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schedule.proto

package com.ray.schedule.grpc;

/**
 * Protobuf type {@code schedule.ReservationFilter}
 */
public  final class ReservationFilter extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:schedule.ReservationFilter)
    ReservationFilterOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ReservationFilter.newBuilder() to construct.
  private ReservationFilter(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ReservationFilter() {
    clientEmail_ = "";
    limit_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ReservationFilter(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            clientEmail_ = s;
            break;
          }
          case 32: {

            limit_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ray.schedule.grpc.ScheduleServiceImpl.internal_static_schedule_ReservationFilter_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ray.schedule.grpc.ScheduleServiceImpl.internal_static_schedule_ReservationFilter_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ray.schedule.grpc.ReservationFilter.class, com.ray.schedule.grpc.ReservationFilter.Builder.class);
  }

  public static final int CLIENTEMAIL_FIELD_NUMBER = 1;
  private volatile java.lang.Object clientEmail_;
  /**
   * <code>string clientEmail = 1;</code>
   */
  public java.lang.String getClientEmail() {
    java.lang.Object ref = clientEmail_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      clientEmail_ = s;
      return s;
    }
  }
  /**
   * <code>string clientEmail = 1;</code>
   */
  public com.google.protobuf.ByteString
      getClientEmailBytes() {
    java.lang.Object ref = clientEmail_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      clientEmail_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LIMIT_FIELD_NUMBER = 4;
  private int limit_;
  /**
   * <code>int32 limit = 4;</code>
   */
  public int getLimit() {
    return limit_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getClientEmailBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, clientEmail_);
    }
    if (limit_ != 0) {
      output.writeInt32(4, limit_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getClientEmailBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, clientEmail_);
    }
    if (limit_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, limit_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ray.schedule.grpc.ReservationFilter)) {
      return super.equals(obj);
    }
    com.ray.schedule.grpc.ReservationFilter other = (com.ray.schedule.grpc.ReservationFilter) obj;

    boolean result = true;
    result = result && getClientEmail()
        .equals(other.getClientEmail());
    result = result && (getLimit()
        == other.getLimit());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CLIENTEMAIL_FIELD_NUMBER;
    hash = (53 * hash) + getClientEmail().hashCode();
    hash = (37 * hash) + LIMIT_FIELD_NUMBER;
    hash = (53 * hash) + getLimit();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ray.schedule.grpc.ReservationFilter parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ray.schedule.grpc.ReservationFilter parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.ray.schedule.grpc.ReservationFilter prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code schedule.ReservationFilter}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:schedule.ReservationFilter)
      com.ray.schedule.grpc.ReservationFilterOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ray.schedule.grpc.ScheduleServiceImpl.internal_static_schedule_ReservationFilter_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ray.schedule.grpc.ScheduleServiceImpl.internal_static_schedule_ReservationFilter_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ray.schedule.grpc.ReservationFilter.class, com.ray.schedule.grpc.ReservationFilter.Builder.class);
    }

    // Construct using com.ray.schedule.grpc.ReservationFilter.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      clientEmail_ = "";

      limit_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ray.schedule.grpc.ScheduleServiceImpl.internal_static_schedule_ReservationFilter_descriptor;
    }

    @java.lang.Override
    public com.ray.schedule.grpc.ReservationFilter getDefaultInstanceForType() {
      return com.ray.schedule.grpc.ReservationFilter.getDefaultInstance();
    }

    @java.lang.Override
    public com.ray.schedule.grpc.ReservationFilter build() {
      com.ray.schedule.grpc.ReservationFilter result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ray.schedule.grpc.ReservationFilter buildPartial() {
      com.ray.schedule.grpc.ReservationFilter result = new com.ray.schedule.grpc.ReservationFilter(this);
      result.clientEmail_ = clientEmail_;
      result.limit_ = limit_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ray.schedule.grpc.ReservationFilter) {
        return mergeFrom((com.ray.schedule.grpc.ReservationFilter)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ray.schedule.grpc.ReservationFilter other) {
      if (other == com.ray.schedule.grpc.ReservationFilter.getDefaultInstance()) return this;
      if (!other.getClientEmail().isEmpty()) {
        clientEmail_ = other.clientEmail_;
        onChanged();
      }
      if (other.getLimit() != 0) {
        setLimit(other.getLimit());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.ray.schedule.grpc.ReservationFilter parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ray.schedule.grpc.ReservationFilter) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object clientEmail_ = "";
    /**
     * <code>string clientEmail = 1;</code>
     */
    public java.lang.String getClientEmail() {
      java.lang.Object ref = clientEmail_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientEmail_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string clientEmail = 1;</code>
     */
    public com.google.protobuf.ByteString
        getClientEmailBytes() {
      java.lang.Object ref = clientEmail_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        clientEmail_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string clientEmail = 1;</code>
     */
    public Builder setClientEmail(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      clientEmail_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string clientEmail = 1;</code>
     */
    public Builder clearClientEmail() {
      
      clientEmail_ = getDefaultInstance().getClientEmail();
      onChanged();
      return this;
    }
    /**
     * <code>string clientEmail = 1;</code>
     */
    public Builder setClientEmailBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      clientEmail_ = value;
      onChanged();
      return this;
    }

    private int limit_ ;
    /**
     * <code>int32 limit = 4;</code>
     */
    public int getLimit() {
      return limit_;
    }
    /**
     * <code>int32 limit = 4;</code>
     */
    public Builder setLimit(int value) {
      
      limit_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 limit = 4;</code>
     */
    public Builder clearLimit() {
      
      limit_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:schedule.ReservationFilter)
  }

  // @@protoc_insertion_point(class_scope:schedule.ReservationFilter)
  private static final com.ray.schedule.grpc.ReservationFilter DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ray.schedule.grpc.ReservationFilter();
  }

  public static com.ray.schedule.grpc.ReservationFilter getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ReservationFilter>
      PARSER = new com.google.protobuf.AbstractParser<ReservationFilter>() {
    @java.lang.Override
    public ReservationFilter parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ReservationFilter(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ReservationFilter> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ReservationFilter> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ray.schedule.grpc.ReservationFilter getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


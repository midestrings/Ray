// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.ray.vehicle.grpc;

/**
 * Protobuf type {@code user.Authentication}
 */
public  final class Authentication extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:user.Authentication)
    AuthenticationOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Authentication.newBuilder() to construct.
  private Authentication(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Authentication() {
    error_ = "";
    token_ = "";
    refreshToken_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Authentication(
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

            error_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            token_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            refreshToken_ = s;
            break;
          }
          case 34: {
            com.ray.vehicle.grpc.Date.Builder subBuilder = null;
            if (refreshTokenExpiry_ != null) {
              subBuilder = refreshTokenExpiry_.toBuilder();
            }
            refreshTokenExpiry_ = input.readMessage(com.ray.vehicle.grpc.Date.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(refreshTokenExpiry_);
              refreshTokenExpiry_ = subBuilder.buildPartial();
            }

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
    return com.ray.vehicle.grpc.UserServiceImpl.internal_static_user_Authentication_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ray.vehicle.grpc.UserServiceImpl.internal_static_user_Authentication_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ray.vehicle.grpc.Authentication.class, com.ray.vehicle.grpc.Authentication.Builder.class);
  }

  public static final int ERROR_FIELD_NUMBER = 1;
  private volatile java.lang.Object error_;
  /**
   * <code>string error = 1;</code>
   */
  public java.lang.String getError() {
    java.lang.Object ref = error_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      error_ = s;
      return s;
    }
  }
  /**
   * <code>string error = 1;</code>
   */
  public com.google.protobuf.ByteString
      getErrorBytes() {
    java.lang.Object ref = error_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      error_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOKEN_FIELD_NUMBER = 2;
  private volatile java.lang.Object token_;
  /**
   * <code>string token = 2;</code>
   */
  public java.lang.String getToken() {
    java.lang.Object ref = token_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      token_ = s;
      return s;
    }
  }
  /**
   * <code>string token = 2;</code>
   */
  public com.google.protobuf.ByteString
      getTokenBytes() {
    java.lang.Object ref = token_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      token_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int REFRESHTOKEN_FIELD_NUMBER = 3;
  private volatile java.lang.Object refreshToken_;
  /**
   * <code>string refreshToken = 3;</code>
   */
  public java.lang.String getRefreshToken() {
    java.lang.Object ref = refreshToken_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      refreshToken_ = s;
      return s;
    }
  }
  /**
   * <code>string refreshToken = 3;</code>
   */
  public com.google.protobuf.ByteString
      getRefreshTokenBytes() {
    java.lang.Object ref = refreshToken_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      refreshToken_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int REFRESHTOKENEXPIRY_FIELD_NUMBER = 4;
  private com.ray.vehicle.grpc.Date refreshTokenExpiry_;
  /**
   * <code>.user.Date refreshTokenExpiry = 4;</code>
   */
  public boolean hasRefreshTokenExpiry() {
    return refreshTokenExpiry_ != null;
  }
  /**
   * <code>.user.Date refreshTokenExpiry = 4;</code>
   */
  public com.ray.vehicle.grpc.Date getRefreshTokenExpiry() {
    return refreshTokenExpiry_ == null ? com.ray.vehicle.grpc.Date.getDefaultInstance() : refreshTokenExpiry_;
  }
  /**
   * <code>.user.Date refreshTokenExpiry = 4;</code>
   */
  public com.ray.vehicle.grpc.DateOrBuilder getRefreshTokenExpiryOrBuilder() {
    return getRefreshTokenExpiry();
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
    if (!getErrorBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, error_);
    }
    if (!getTokenBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, token_);
    }
    if (!getRefreshTokenBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, refreshToken_);
    }
    if (refreshTokenExpiry_ != null) {
      output.writeMessage(4, getRefreshTokenExpiry());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getErrorBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, error_);
    }
    if (!getTokenBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, token_);
    }
    if (!getRefreshTokenBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, refreshToken_);
    }
    if (refreshTokenExpiry_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getRefreshTokenExpiry());
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
    if (!(obj instanceof com.ray.vehicle.grpc.Authentication)) {
      return super.equals(obj);
    }
    com.ray.vehicle.grpc.Authentication other = (com.ray.vehicle.grpc.Authentication) obj;

    boolean result = true;
    result = result && getError()
        .equals(other.getError());
    result = result && getToken()
        .equals(other.getToken());
    result = result && getRefreshToken()
        .equals(other.getRefreshToken());
    result = result && (hasRefreshTokenExpiry() == other.hasRefreshTokenExpiry());
    if (hasRefreshTokenExpiry()) {
      result = result && getRefreshTokenExpiry()
          .equals(other.getRefreshTokenExpiry());
    }
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
    hash = (37 * hash) + ERROR_FIELD_NUMBER;
    hash = (53 * hash) + getError().hashCode();
    hash = (37 * hash) + TOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getToken().hashCode();
    hash = (37 * hash) + REFRESHTOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getRefreshToken().hashCode();
    if (hasRefreshTokenExpiry()) {
      hash = (37 * hash) + REFRESHTOKENEXPIRY_FIELD_NUMBER;
      hash = (53 * hash) + getRefreshTokenExpiry().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ray.vehicle.grpc.Authentication parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ray.vehicle.grpc.Authentication parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ray.vehicle.grpc.Authentication parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ray.vehicle.grpc.Authentication parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ray.vehicle.grpc.Authentication parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ray.vehicle.grpc.Authentication parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ray.vehicle.grpc.Authentication parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ray.vehicle.grpc.Authentication parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ray.vehicle.grpc.Authentication parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ray.vehicle.grpc.Authentication parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ray.vehicle.grpc.Authentication parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ray.vehicle.grpc.Authentication parseFrom(
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
  public static Builder newBuilder(com.ray.vehicle.grpc.Authentication prototype) {
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
   * Protobuf type {@code user.Authentication}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:user.Authentication)
      com.ray.vehicle.grpc.AuthenticationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ray.vehicle.grpc.UserServiceImpl.internal_static_user_Authentication_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ray.vehicle.grpc.UserServiceImpl.internal_static_user_Authentication_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ray.vehicle.grpc.Authentication.class, com.ray.vehicle.grpc.Authentication.Builder.class);
    }

    // Construct using com.ray.vehicle.grpc.Authentication.newBuilder()
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
      error_ = "";

      token_ = "";

      refreshToken_ = "";

      if (refreshTokenExpiryBuilder_ == null) {
        refreshTokenExpiry_ = null;
      } else {
        refreshTokenExpiry_ = null;
        refreshTokenExpiryBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ray.vehicle.grpc.UserServiceImpl.internal_static_user_Authentication_descriptor;
    }

    @java.lang.Override
    public com.ray.vehicle.grpc.Authentication getDefaultInstanceForType() {
      return com.ray.vehicle.grpc.Authentication.getDefaultInstance();
    }

    @java.lang.Override
    public com.ray.vehicle.grpc.Authentication build() {
      com.ray.vehicle.grpc.Authentication result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ray.vehicle.grpc.Authentication buildPartial() {
      com.ray.vehicle.grpc.Authentication result = new com.ray.vehicle.grpc.Authentication(this);
      result.error_ = error_;
      result.token_ = token_;
      result.refreshToken_ = refreshToken_;
      if (refreshTokenExpiryBuilder_ == null) {
        result.refreshTokenExpiry_ = refreshTokenExpiry_;
      } else {
        result.refreshTokenExpiry_ = refreshTokenExpiryBuilder_.build();
      }
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
      if (other instanceof com.ray.vehicle.grpc.Authentication) {
        return mergeFrom((com.ray.vehicle.grpc.Authentication)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ray.vehicle.grpc.Authentication other) {
      if (other == com.ray.vehicle.grpc.Authentication.getDefaultInstance()) return this;
      if (!other.getError().isEmpty()) {
        error_ = other.error_;
        onChanged();
      }
      if (!other.getToken().isEmpty()) {
        token_ = other.token_;
        onChanged();
      }
      if (!other.getRefreshToken().isEmpty()) {
        refreshToken_ = other.refreshToken_;
        onChanged();
      }
      if (other.hasRefreshTokenExpiry()) {
        mergeRefreshTokenExpiry(other.getRefreshTokenExpiry());
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
      com.ray.vehicle.grpc.Authentication parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ray.vehicle.grpc.Authentication) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object error_ = "";
    /**
     * <code>string error = 1;</code>
     */
    public java.lang.String getError() {
      java.lang.Object ref = error_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        error_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string error = 1;</code>
     */
    public com.google.protobuf.ByteString
        getErrorBytes() {
      java.lang.Object ref = error_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        error_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string error = 1;</code>
     */
    public Builder setError(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      error_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string error = 1;</code>
     */
    public Builder clearError() {
      
      error_ = getDefaultInstance().getError();
      onChanged();
      return this;
    }
    /**
     * <code>string error = 1;</code>
     */
    public Builder setErrorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      error_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object token_ = "";
    /**
     * <code>string token = 2;</code>
     */
    public java.lang.String getToken() {
      java.lang.Object ref = token_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        token_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string token = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTokenBytes() {
      java.lang.Object ref = token_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        token_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string token = 2;</code>
     */
    public Builder setToken(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      token_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string token = 2;</code>
     */
    public Builder clearToken() {
      
      token_ = getDefaultInstance().getToken();
      onChanged();
      return this;
    }
    /**
     * <code>string token = 2;</code>
     */
    public Builder setTokenBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      token_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object refreshToken_ = "";
    /**
     * <code>string refreshToken = 3;</code>
     */
    public java.lang.String getRefreshToken() {
      java.lang.Object ref = refreshToken_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        refreshToken_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string refreshToken = 3;</code>
     */
    public com.google.protobuf.ByteString
        getRefreshTokenBytes() {
      java.lang.Object ref = refreshToken_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        refreshToken_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string refreshToken = 3;</code>
     */
    public Builder setRefreshToken(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      refreshToken_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string refreshToken = 3;</code>
     */
    public Builder clearRefreshToken() {
      
      refreshToken_ = getDefaultInstance().getRefreshToken();
      onChanged();
      return this;
    }
    /**
     * <code>string refreshToken = 3;</code>
     */
    public Builder setRefreshTokenBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      refreshToken_ = value;
      onChanged();
      return this;
    }

    private com.ray.vehicle.grpc.Date refreshTokenExpiry_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ray.vehicle.grpc.Date, com.ray.vehicle.grpc.Date.Builder, com.ray.vehicle.grpc.DateOrBuilder> refreshTokenExpiryBuilder_;
    /**
     * <code>.user.Date refreshTokenExpiry = 4;</code>
     */
    public boolean hasRefreshTokenExpiry() {
      return refreshTokenExpiryBuilder_ != null || refreshTokenExpiry_ != null;
    }
    /**
     * <code>.user.Date refreshTokenExpiry = 4;</code>
     */
    public com.ray.vehicle.grpc.Date getRefreshTokenExpiry() {
      if (refreshTokenExpiryBuilder_ == null) {
        return refreshTokenExpiry_ == null ? com.ray.vehicle.grpc.Date.getDefaultInstance() : refreshTokenExpiry_;
      } else {
        return refreshTokenExpiryBuilder_.getMessage();
      }
    }
    /**
     * <code>.user.Date refreshTokenExpiry = 4;</code>
     */
    public Builder setRefreshTokenExpiry(com.ray.vehicle.grpc.Date value) {
      if (refreshTokenExpiryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        refreshTokenExpiry_ = value;
        onChanged();
      } else {
        refreshTokenExpiryBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.user.Date refreshTokenExpiry = 4;</code>
     */
    public Builder setRefreshTokenExpiry(
        com.ray.vehicle.grpc.Date.Builder builderForValue) {
      if (refreshTokenExpiryBuilder_ == null) {
        refreshTokenExpiry_ = builderForValue.build();
        onChanged();
      } else {
        refreshTokenExpiryBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.user.Date refreshTokenExpiry = 4;</code>
     */
    public Builder mergeRefreshTokenExpiry(com.ray.vehicle.grpc.Date value) {
      if (refreshTokenExpiryBuilder_ == null) {
        if (refreshTokenExpiry_ != null) {
          refreshTokenExpiry_ =
            com.ray.vehicle.grpc.Date.newBuilder(refreshTokenExpiry_).mergeFrom(value).buildPartial();
        } else {
          refreshTokenExpiry_ = value;
        }
        onChanged();
      } else {
        refreshTokenExpiryBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.user.Date refreshTokenExpiry = 4;</code>
     */
    public Builder clearRefreshTokenExpiry() {
      if (refreshTokenExpiryBuilder_ == null) {
        refreshTokenExpiry_ = null;
        onChanged();
      } else {
        refreshTokenExpiry_ = null;
        refreshTokenExpiryBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.user.Date refreshTokenExpiry = 4;</code>
     */
    public com.ray.vehicle.grpc.Date.Builder getRefreshTokenExpiryBuilder() {
      
      onChanged();
      return getRefreshTokenExpiryFieldBuilder().getBuilder();
    }
    /**
     * <code>.user.Date refreshTokenExpiry = 4;</code>
     */
    public com.ray.vehicle.grpc.DateOrBuilder getRefreshTokenExpiryOrBuilder() {
      if (refreshTokenExpiryBuilder_ != null) {
        return refreshTokenExpiryBuilder_.getMessageOrBuilder();
      } else {
        return refreshTokenExpiry_ == null ?
            com.ray.vehicle.grpc.Date.getDefaultInstance() : refreshTokenExpiry_;
      }
    }
    /**
     * <code>.user.Date refreshTokenExpiry = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ray.vehicle.grpc.Date, com.ray.vehicle.grpc.Date.Builder, com.ray.vehicle.grpc.DateOrBuilder> 
        getRefreshTokenExpiryFieldBuilder() {
      if (refreshTokenExpiryBuilder_ == null) {
        refreshTokenExpiryBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.ray.vehicle.grpc.Date, com.ray.vehicle.grpc.Date.Builder, com.ray.vehicle.grpc.DateOrBuilder>(
                getRefreshTokenExpiry(),
                getParentForChildren(),
                isClean());
        refreshTokenExpiry_ = null;
      }
      return refreshTokenExpiryBuilder_;
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


    // @@protoc_insertion_point(builder_scope:user.Authentication)
  }

  // @@protoc_insertion_point(class_scope:user.Authentication)
  private static final com.ray.vehicle.grpc.Authentication DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ray.vehicle.grpc.Authentication();
  }

  public static com.ray.vehicle.grpc.Authentication getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Authentication>
      PARSER = new com.google.protobuf.AbstractParser<Authentication>() {
    @java.lang.Override
    public Authentication parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Authentication(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Authentication> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Authentication> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ray.vehicle.grpc.Authentication getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


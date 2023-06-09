// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.ray.app.grpc;

/**
 * Protobuf type {@code user.UserFilter}
 */
public  final class UserFilter extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:user.UserFilter)
    UserFilterOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UserFilter.newBuilder() to construct.
  private UserFilter(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserFilter() {
    status_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    type_ = "";
    gender_ = "";
    roles_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    page_ = 0;
    limit_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UserFilter(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              status_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            status_.add(s);
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            type_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            gender_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              roles_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000008;
            }
            roles_.add(s);
            break;
          }
          case 40: {

            page_ = input.readInt32();
            break;
          }
          case 48: {

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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        status_ = status_.getUnmodifiableView();
      }
      if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
        roles_ = roles_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ray.app.grpc.UserServiceImpl.internal_static_user_UserFilter_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ray.app.grpc.UserServiceImpl.internal_static_user_UserFilter_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ray.app.grpc.UserFilter.class, com.ray.app.grpc.UserFilter.Builder.class);
  }

  private int bitField0_;
  public static final int STATUS_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList status_;
  /**
   * <code>repeated string status = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getStatusList() {
    return status_;
  }
  /**
   * <code>repeated string status = 1;</code>
   */
  public int getStatusCount() {
    return status_.size();
  }
  /**
   * <code>repeated string status = 1;</code>
   */
  public java.lang.String getStatus(int index) {
    return status_.get(index);
  }
  /**
   * <code>repeated string status = 1;</code>
   */
  public com.google.protobuf.ByteString
      getStatusBytes(int index) {
    return status_.getByteString(index);
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private volatile java.lang.Object type_;
  /**
   * <code>string type = 2;</code>
   */
  public java.lang.String getType() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      type_ = s;
      return s;
    }
  }
  /**
   * <code>string type = 2;</code>
   */
  public com.google.protobuf.ByteString
      getTypeBytes() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      type_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int GENDER_FIELD_NUMBER = 3;
  private volatile java.lang.Object gender_;
  /**
   * <code>string gender = 3;</code>
   */
  public java.lang.String getGender() {
    java.lang.Object ref = gender_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      gender_ = s;
      return s;
    }
  }
  /**
   * <code>string gender = 3;</code>
   */
  public com.google.protobuf.ByteString
      getGenderBytes() {
    java.lang.Object ref = gender_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      gender_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ROLES_FIELD_NUMBER = 4;
  private com.google.protobuf.LazyStringList roles_;
  /**
   * <code>repeated string roles = 4;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getRolesList() {
    return roles_;
  }
  /**
   * <code>repeated string roles = 4;</code>
   */
  public int getRolesCount() {
    return roles_.size();
  }
  /**
   * <code>repeated string roles = 4;</code>
   */
  public java.lang.String getRoles(int index) {
    return roles_.get(index);
  }
  /**
   * <code>repeated string roles = 4;</code>
   */
  public com.google.protobuf.ByteString
      getRolesBytes(int index) {
    return roles_.getByteString(index);
  }

  public static final int PAGE_FIELD_NUMBER = 5;
  private int page_;
  /**
   * <code>int32 page = 5;</code>
   */
  public int getPage() {
    return page_;
  }

  public static final int LIMIT_FIELD_NUMBER = 6;
  private int limit_;
  /**
   * <code>int32 limit = 6;</code>
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
    for (int i = 0; i < status_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, status_.getRaw(i));
    }
    if (!getTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, type_);
    }
    if (!getGenderBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, gender_);
    }
    for (int i = 0; i < roles_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, roles_.getRaw(i));
    }
    if (page_ != 0) {
      output.writeInt32(5, page_);
    }
    if (limit_ != 0) {
      output.writeInt32(6, limit_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < status_.size(); i++) {
        dataSize += computeStringSizeNoTag(status_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getStatusList().size();
    }
    if (!getTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, type_);
    }
    if (!getGenderBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, gender_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < roles_.size(); i++) {
        dataSize += computeStringSizeNoTag(roles_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getRolesList().size();
    }
    if (page_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, page_);
    }
    if (limit_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, limit_);
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
    if (!(obj instanceof com.ray.app.grpc.UserFilter)) {
      return super.equals(obj);
    }
    com.ray.app.grpc.UserFilter other = (com.ray.app.grpc.UserFilter) obj;

    boolean result = true;
    result = result && getStatusList()
        .equals(other.getStatusList());
    result = result && getType()
        .equals(other.getType());
    result = result && getGender()
        .equals(other.getGender());
    result = result && getRolesList()
        .equals(other.getRolesList());
    result = result && (getPage()
        == other.getPage());
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
    if (getStatusCount() > 0) {
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + getStatusList().hashCode();
    }
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType().hashCode();
    hash = (37 * hash) + GENDER_FIELD_NUMBER;
    hash = (53 * hash) + getGender().hashCode();
    if (getRolesCount() > 0) {
      hash = (37 * hash) + ROLES_FIELD_NUMBER;
      hash = (53 * hash) + getRolesList().hashCode();
    }
    hash = (37 * hash) + PAGE_FIELD_NUMBER;
    hash = (53 * hash) + getPage();
    hash = (37 * hash) + LIMIT_FIELD_NUMBER;
    hash = (53 * hash) + getLimit();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ray.app.grpc.UserFilter parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ray.app.grpc.UserFilter parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ray.app.grpc.UserFilter parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ray.app.grpc.UserFilter parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ray.app.grpc.UserFilter parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ray.app.grpc.UserFilter parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ray.app.grpc.UserFilter parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ray.app.grpc.UserFilter parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ray.app.grpc.UserFilter parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ray.app.grpc.UserFilter parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ray.app.grpc.UserFilter parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ray.app.grpc.UserFilter parseFrom(
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
  public static Builder newBuilder(com.ray.app.grpc.UserFilter prototype) {
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
   * Protobuf type {@code user.UserFilter}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:user.UserFilter)
      com.ray.app.grpc.UserFilterOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ray.app.grpc.UserServiceImpl.internal_static_user_UserFilter_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ray.app.grpc.UserServiceImpl.internal_static_user_UserFilter_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ray.app.grpc.UserFilter.class, com.ray.app.grpc.UserFilter.Builder.class);
    }

    // Construct using com.ray.app.grpc.UserFilter.newBuilder()
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
      status_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = "";

      gender_ = "";

      roles_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000008);
      page_ = 0;

      limit_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ray.app.grpc.UserServiceImpl.internal_static_user_UserFilter_descriptor;
    }

    @java.lang.Override
    public com.ray.app.grpc.UserFilter getDefaultInstanceForType() {
      return com.ray.app.grpc.UserFilter.getDefaultInstance();
    }

    @java.lang.Override
    public com.ray.app.grpc.UserFilter build() {
      com.ray.app.grpc.UserFilter result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ray.app.grpc.UserFilter buildPartial() {
      com.ray.app.grpc.UserFilter result = new com.ray.app.grpc.UserFilter(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        status_ = status_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.status_ = status_;
      result.type_ = type_;
      result.gender_ = gender_;
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        roles_ = roles_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000008);
      }
      result.roles_ = roles_;
      result.page_ = page_;
      result.limit_ = limit_;
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof com.ray.app.grpc.UserFilter) {
        return mergeFrom((com.ray.app.grpc.UserFilter)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ray.app.grpc.UserFilter other) {
      if (other == com.ray.app.grpc.UserFilter.getDefaultInstance()) return this;
      if (!other.status_.isEmpty()) {
        if (status_.isEmpty()) {
          status_ = other.status_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureStatusIsMutable();
          status_.addAll(other.status_);
        }
        onChanged();
      }
      if (!other.getType().isEmpty()) {
        type_ = other.type_;
        onChanged();
      }
      if (!other.getGender().isEmpty()) {
        gender_ = other.gender_;
        onChanged();
      }
      if (!other.roles_.isEmpty()) {
        if (roles_.isEmpty()) {
          roles_ = other.roles_;
          bitField0_ = (bitField0_ & ~0x00000008);
        } else {
          ensureRolesIsMutable();
          roles_.addAll(other.roles_);
        }
        onChanged();
      }
      if (other.getPage() != 0) {
        setPage(other.getPage());
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
      com.ray.app.grpc.UserFilter parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ray.app.grpc.UserFilter) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList status_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureStatusIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        status_ = new com.google.protobuf.LazyStringArrayList(status_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string status = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getStatusList() {
      return status_.getUnmodifiableView();
    }
    /**
     * <code>repeated string status = 1;</code>
     */
    public int getStatusCount() {
      return status_.size();
    }
    /**
     * <code>repeated string status = 1;</code>
     */
    public java.lang.String getStatus(int index) {
      return status_.get(index);
    }
    /**
     * <code>repeated string status = 1;</code>
     */
    public com.google.protobuf.ByteString
        getStatusBytes(int index) {
      return status_.getByteString(index);
    }
    /**
     * <code>repeated string status = 1;</code>
     */
    public Builder setStatus(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureStatusIsMutable();
      status_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string status = 1;</code>
     */
    public Builder addStatus(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureStatusIsMutable();
      status_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string status = 1;</code>
     */
    public Builder addAllStatus(
        java.lang.Iterable<java.lang.String> values) {
      ensureStatusIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, status_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string status = 1;</code>
     */
    public Builder clearStatus() {
      status_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string status = 1;</code>
     */
    public Builder addStatusBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureStatusIsMutable();
      status_.add(value);
      onChanged();
      return this;
    }

    private java.lang.Object type_ = "";
    /**
     * <code>string type = 2;</code>
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string type = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string type = 2;</code>
     */
    public Builder setType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string type = 2;</code>
     */
    public Builder clearType() {
      
      type_ = getDefaultInstance().getType();
      onChanged();
      return this;
    }
    /**
     * <code>string type = 2;</code>
     */
    public Builder setTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      type_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object gender_ = "";
    /**
     * <code>string gender = 3;</code>
     */
    public java.lang.String getGender() {
      java.lang.Object ref = gender_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gender_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string gender = 3;</code>
     */
    public com.google.protobuf.ByteString
        getGenderBytes() {
      java.lang.Object ref = gender_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gender_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string gender = 3;</code>
     */
    public Builder setGender(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      gender_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string gender = 3;</code>
     */
    public Builder clearGender() {
      
      gender_ = getDefaultInstance().getGender();
      onChanged();
      return this;
    }
    /**
     * <code>string gender = 3;</code>
     */
    public Builder setGenderBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      gender_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList roles_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureRolesIsMutable() {
      if (!((bitField0_ & 0x00000008) == 0x00000008)) {
        roles_ = new com.google.protobuf.LazyStringArrayList(roles_);
        bitField0_ |= 0x00000008;
       }
    }
    /**
     * <code>repeated string roles = 4;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getRolesList() {
      return roles_.getUnmodifiableView();
    }
    /**
     * <code>repeated string roles = 4;</code>
     */
    public int getRolesCount() {
      return roles_.size();
    }
    /**
     * <code>repeated string roles = 4;</code>
     */
    public java.lang.String getRoles(int index) {
      return roles_.get(index);
    }
    /**
     * <code>repeated string roles = 4;</code>
     */
    public com.google.protobuf.ByteString
        getRolesBytes(int index) {
      return roles_.getByteString(index);
    }
    /**
     * <code>repeated string roles = 4;</code>
     */
    public Builder setRoles(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureRolesIsMutable();
      roles_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string roles = 4;</code>
     */
    public Builder addRoles(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureRolesIsMutable();
      roles_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string roles = 4;</code>
     */
    public Builder addAllRoles(
        java.lang.Iterable<java.lang.String> values) {
      ensureRolesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, roles_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string roles = 4;</code>
     */
    public Builder clearRoles() {
      roles_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string roles = 4;</code>
     */
    public Builder addRolesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureRolesIsMutable();
      roles_.add(value);
      onChanged();
      return this;
    }

    private int page_ ;
    /**
     * <code>int32 page = 5;</code>
     */
    public int getPage() {
      return page_;
    }
    /**
     * <code>int32 page = 5;</code>
     */
    public Builder setPage(int value) {
      
      page_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 page = 5;</code>
     */
    public Builder clearPage() {
      
      page_ = 0;
      onChanged();
      return this;
    }

    private int limit_ ;
    /**
     * <code>int32 limit = 6;</code>
     */
    public int getLimit() {
      return limit_;
    }
    /**
     * <code>int32 limit = 6;</code>
     */
    public Builder setLimit(int value) {
      
      limit_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 limit = 6;</code>
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


    // @@protoc_insertion_point(builder_scope:user.UserFilter)
  }

  // @@protoc_insertion_point(class_scope:user.UserFilter)
  private static final com.ray.app.grpc.UserFilter DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ray.app.grpc.UserFilter();
  }

  public static com.ray.app.grpc.UserFilter getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserFilter>
      PARSER = new com.google.protobuf.AbstractParser<UserFilter>() {
    @java.lang.Override
    public UserFilter parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UserFilter(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserFilter> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserFilter> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ray.app.grpc.UserFilter getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


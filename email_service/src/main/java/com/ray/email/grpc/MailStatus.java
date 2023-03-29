// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: email.proto

package com.ray.email.grpc;

/**
 * Protobuf enum {@code email.MailStatus}
 */
public enum MailStatus
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>SENT = 0;</code>
   */
  SENT(0),
  /**
   * <code>ERROR = 1;</code>
   */
  ERROR(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>SENT = 0;</code>
   */
  public static final int SENT_VALUE = 0;
  /**
   * <code>ERROR = 1;</code>
   */
  public static final int ERROR_VALUE = 1;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static MailStatus valueOf(int value) {
    return forNumber(value);
  }

  public static MailStatus forNumber(int value) {
    switch (value) {
      case 0: return SENT;
      case 1: return ERROR;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<MailStatus>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      MailStatus> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MailStatus>() {
          public MailStatus findValueByNumber(int number) {
            return MailStatus.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.ray.email.grpc.EmailServiceImpl.getDescriptor().getEnumTypes().get(0);
  }

  private static final MailStatus[] VALUES = values();

  public static MailStatus valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private MailStatus(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:email.MailStatus)
}

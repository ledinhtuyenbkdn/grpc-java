// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route_guide.proto

package com.ledinhtuyenbkdn.myapp.grpc;

/**
 * Protobuf type {@code tutorial.RouteNote}
 */
public final class RouteNote extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tutorial.RouteNote)
    RouteNoteOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RouteNote.newBuilder() to construct.
  private RouteNote(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RouteNote() {
    message_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RouteNote();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RouteNote(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
            com.ledinhtuyenbkdn.myapp.grpc.Point.Builder subBuilder = null;
            if (location_ != null) {
              subBuilder = location_.toBuilder();
            }
            location_ = input.readMessage(com.ledinhtuyenbkdn.myapp.grpc.Point.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(location_);
              location_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            message_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
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
    return com.ledinhtuyenbkdn.myapp.grpc.RouteGuideProto.internal_static_tutorial_RouteNote_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ledinhtuyenbkdn.myapp.grpc.RouteGuideProto.internal_static_tutorial_RouteNote_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ledinhtuyenbkdn.myapp.grpc.RouteNote.class, com.ledinhtuyenbkdn.myapp.grpc.RouteNote.Builder.class);
  }

  public static final int LOCATION_FIELD_NUMBER = 1;
  private com.ledinhtuyenbkdn.myapp.grpc.Point location_;
  /**
   * <pre>
   * The location from which the message is sent.
   * </pre>
   *
   * <code>.tutorial.Point location = 1;</code>
   * @return Whether the location field is set.
   */
  @java.lang.Override
  public boolean hasLocation() {
    return location_ != null;
  }
  /**
   * <pre>
   * The location from which the message is sent.
   * </pre>
   *
   * <code>.tutorial.Point location = 1;</code>
   * @return The location.
   */
  @java.lang.Override
  public com.ledinhtuyenbkdn.myapp.grpc.Point getLocation() {
    return location_ == null ? com.ledinhtuyenbkdn.myapp.grpc.Point.getDefaultInstance() : location_;
  }
  /**
   * <pre>
   * The location from which the message is sent.
   * </pre>
   *
   * <code>.tutorial.Point location = 1;</code>
   */
  @java.lang.Override
  public com.ledinhtuyenbkdn.myapp.grpc.PointOrBuilder getLocationOrBuilder() {
    return getLocation();
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object message_;
  /**
   * <pre>
   * The message to be sent.
   * </pre>
   *
   * <code>string message = 2;</code>
   * @return The message.
   */
  @java.lang.Override
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * The message to be sent.
   * </pre>
   *
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (location_ != null) {
      output.writeMessage(1, getLocation());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(message_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (location_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getLocation());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(message_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, message_);
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
    if (!(obj instanceof com.ledinhtuyenbkdn.myapp.grpc.RouteNote)) {
      return super.equals(obj);
    }
    com.ledinhtuyenbkdn.myapp.grpc.RouteNote other = (com.ledinhtuyenbkdn.myapp.grpc.RouteNote) obj;

    if (hasLocation() != other.hasLocation()) return false;
    if (hasLocation()) {
      if (!getLocation()
          .equals(other.getLocation())) return false;
    }
    if (!getMessage()
        .equals(other.getMessage())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasLocation()) {
      hash = (37 * hash) + LOCATION_FIELD_NUMBER;
      hash = (53 * hash) + getLocation().hashCode();
    }
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote parseFrom(
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
  public static Builder newBuilder(com.ledinhtuyenbkdn.myapp.grpc.RouteNote prototype) {
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
   * Protobuf type {@code tutorial.RouteNote}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tutorial.RouteNote)
      com.ledinhtuyenbkdn.myapp.grpc.RouteNoteOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ledinhtuyenbkdn.myapp.grpc.RouteGuideProto.internal_static_tutorial_RouteNote_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ledinhtuyenbkdn.myapp.grpc.RouteGuideProto.internal_static_tutorial_RouteNote_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ledinhtuyenbkdn.myapp.grpc.RouteNote.class, com.ledinhtuyenbkdn.myapp.grpc.RouteNote.Builder.class);
    }

    // Construct using com.ledinhtuyenbkdn.myapp.grpc.RouteNote.newBuilder()
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
      if (locationBuilder_ == null) {
        location_ = null;
      } else {
        location_ = null;
        locationBuilder_ = null;
      }
      message_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ledinhtuyenbkdn.myapp.grpc.RouteGuideProto.internal_static_tutorial_RouteNote_descriptor;
    }

    @java.lang.Override
    public com.ledinhtuyenbkdn.myapp.grpc.RouteNote getDefaultInstanceForType() {
      return com.ledinhtuyenbkdn.myapp.grpc.RouteNote.getDefaultInstance();
    }

    @java.lang.Override
    public com.ledinhtuyenbkdn.myapp.grpc.RouteNote build() {
      com.ledinhtuyenbkdn.myapp.grpc.RouteNote result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ledinhtuyenbkdn.myapp.grpc.RouteNote buildPartial() {
      com.ledinhtuyenbkdn.myapp.grpc.RouteNote result = new com.ledinhtuyenbkdn.myapp.grpc.RouteNote(this);
      if (locationBuilder_ == null) {
        result.location_ = location_;
      } else {
        result.location_ = locationBuilder_.build();
      }
      result.message_ = message_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ledinhtuyenbkdn.myapp.grpc.RouteNote) {
        return mergeFrom((com.ledinhtuyenbkdn.myapp.grpc.RouteNote)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ledinhtuyenbkdn.myapp.grpc.RouteNote other) {
      if (other == com.ledinhtuyenbkdn.myapp.grpc.RouteNote.getDefaultInstance()) return this;
      if (other.hasLocation()) {
        mergeLocation(other.getLocation());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
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
      com.ledinhtuyenbkdn.myapp.grpc.RouteNote parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ledinhtuyenbkdn.myapp.grpc.RouteNote) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.ledinhtuyenbkdn.myapp.grpc.Point location_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ledinhtuyenbkdn.myapp.grpc.Point, com.ledinhtuyenbkdn.myapp.grpc.Point.Builder, com.ledinhtuyenbkdn.myapp.grpc.PointOrBuilder> locationBuilder_;
    /**
     * <pre>
     * The location from which the message is sent.
     * </pre>
     *
     * <code>.tutorial.Point location = 1;</code>
     * @return Whether the location field is set.
     */
    public boolean hasLocation() {
      return locationBuilder_ != null || location_ != null;
    }
    /**
     * <pre>
     * The location from which the message is sent.
     * </pre>
     *
     * <code>.tutorial.Point location = 1;</code>
     * @return The location.
     */
    public com.ledinhtuyenbkdn.myapp.grpc.Point getLocation() {
      if (locationBuilder_ == null) {
        return location_ == null ? com.ledinhtuyenbkdn.myapp.grpc.Point.getDefaultInstance() : location_;
      } else {
        return locationBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The location from which the message is sent.
     * </pre>
     *
     * <code>.tutorial.Point location = 1;</code>
     */
    public Builder setLocation(com.ledinhtuyenbkdn.myapp.grpc.Point value) {
      if (locationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        location_ = value;
        onChanged();
      } else {
        locationBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The location from which the message is sent.
     * </pre>
     *
     * <code>.tutorial.Point location = 1;</code>
     */
    public Builder setLocation(
        com.ledinhtuyenbkdn.myapp.grpc.Point.Builder builderForValue) {
      if (locationBuilder_ == null) {
        location_ = builderForValue.build();
        onChanged();
      } else {
        locationBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The location from which the message is sent.
     * </pre>
     *
     * <code>.tutorial.Point location = 1;</code>
     */
    public Builder mergeLocation(com.ledinhtuyenbkdn.myapp.grpc.Point value) {
      if (locationBuilder_ == null) {
        if (location_ != null) {
          location_ =
            com.ledinhtuyenbkdn.myapp.grpc.Point.newBuilder(location_).mergeFrom(value).buildPartial();
        } else {
          location_ = value;
        }
        onChanged();
      } else {
        locationBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The location from which the message is sent.
     * </pre>
     *
     * <code>.tutorial.Point location = 1;</code>
     */
    public Builder clearLocation() {
      if (locationBuilder_ == null) {
        location_ = null;
        onChanged();
      } else {
        location_ = null;
        locationBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The location from which the message is sent.
     * </pre>
     *
     * <code>.tutorial.Point location = 1;</code>
     */
    public com.ledinhtuyenbkdn.myapp.grpc.Point.Builder getLocationBuilder() {
      
      onChanged();
      return getLocationFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The location from which the message is sent.
     * </pre>
     *
     * <code>.tutorial.Point location = 1;</code>
     */
    public com.ledinhtuyenbkdn.myapp.grpc.PointOrBuilder getLocationOrBuilder() {
      if (locationBuilder_ != null) {
        return locationBuilder_.getMessageOrBuilder();
      } else {
        return location_ == null ?
            com.ledinhtuyenbkdn.myapp.grpc.Point.getDefaultInstance() : location_;
      }
    }
    /**
     * <pre>
     * The location from which the message is sent.
     * </pre>
     *
     * <code>.tutorial.Point location = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.ledinhtuyenbkdn.myapp.grpc.Point, com.ledinhtuyenbkdn.myapp.grpc.Point.Builder, com.ledinhtuyenbkdn.myapp.grpc.PointOrBuilder> 
        getLocationFieldBuilder() {
      if (locationBuilder_ == null) {
        locationBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.ledinhtuyenbkdn.myapp.grpc.Point, com.ledinhtuyenbkdn.myapp.grpc.Point.Builder, com.ledinhtuyenbkdn.myapp.grpc.PointOrBuilder>(
                getLocation(),
                getParentForChildren(),
                isClean());
        location_ = null;
      }
      return locationBuilder_;
    }

    private java.lang.Object message_ = "";
    /**
     * <pre>
     * The message to be sent.
     * </pre>
     *
     * <code>string message = 2;</code>
     * @return The message.
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * The message to be sent.
     * </pre>
     *
     * <code>string message = 2;</code>
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * The message to be sent.
     * </pre>
     *
     * <code>string message = 2;</code>
     * @param value The message to set.
     * @return This builder for chaining.
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The message to be sent.
     * </pre>
     *
     * <code>string message = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The message to be sent.
     * </pre>
     *
     * <code>string message = 2;</code>
     * @param value The bytes for message to set.
     * @return This builder for chaining.
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      message_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:tutorial.RouteNote)
  }

  // @@protoc_insertion_point(class_scope:tutorial.RouteNote)
  private static final com.ledinhtuyenbkdn.myapp.grpc.RouteNote DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ledinhtuyenbkdn.myapp.grpc.RouteNote();
  }

  public static com.ledinhtuyenbkdn.myapp.grpc.RouteNote getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RouteNote>
      PARSER = new com.google.protobuf.AbstractParser<RouteNote>() {
    @java.lang.Override
    public RouteNote parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RouteNote(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RouteNote> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RouteNote> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ledinhtuyenbkdn.myapp.grpc.RouteNote getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

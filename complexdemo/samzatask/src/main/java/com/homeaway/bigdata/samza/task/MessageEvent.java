package com.homeaway.bigdata.samza.task;
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class MessageEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MessageEvent\",\"namespace\":\"com.homeaway.bigdata.core\",\"fields\":[{\"name\":\"time\",\"type\":\"long\"},{\"name\":\"host\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"message\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private long time;
   private java.lang.String host;
   private java.lang.String message;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MessageEvent() {}

  /**
   * All-args constructor.
   */
  public MessageEvent(java.lang.Long time, java.lang.String host, java.lang.String message) {
    this.time = time;
    this.host = host;
    this.message = message;
  }

  @Override
public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  @Override
public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return time;
    case 1: return host;
    case 2: return message;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call.
  @Override
@SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: time = (java.lang.Long)value$; break;
    case 1: host = (java.lang.String)value$; break;
    case 2: message = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'time' field.
   */
  public java.lang.Long getTime() {
    return time;
  }

  /**
   * Sets the value of the 'time' field.
   * @param value the value to set.
   */
  public void setTime(java.lang.Long value) {
    this.time = value;
  }

  /**
   * Gets the value of the 'host' field.
   */
  public java.lang.String getHost() {
    return host;
  }

  /**
   * Sets the value of the 'host' field.
   * @param value the value to set.
   */
  public void setHost(java.lang.String value) {
    this.host = value;
  }

  /**
   * Gets the value of the 'message' field.
   */
  public java.lang.String getMessage() {
    return message;
  }

  /**
   * Sets the value of the 'message' field.
   * @param value the value to set.
   */
  public void setMessage(java.lang.String value) {
    this.message = value;
  }

  /** Creates a new MessageEvent RecordBuilder */
  public static MessageEvent.Builder newBuilder() {
    return new MessageEvent.Builder();
  }

  /** Creates a new MessageEvent RecordBuilder by copying an existing Builder */
  public static MessageEvent.Builder newBuilder(MessageEvent.Builder other) {
    return new MessageEvent.Builder(other);
  }

  /** Creates a new MessageEvent RecordBuilder by copying an existing MessageEvent instance */
  public static MessageEvent.Builder newBuilder(MessageEvent other) {
    return new MessageEvent.Builder(other);
  }

  /**
   * RecordBuilder for MessageEvent instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MessageEvent>
    implements org.apache.avro.data.RecordBuilder<MessageEvent> {

    private long time;
    private java.lang.String host;
    private java.lang.String message;

    /** Creates a new Builder */
    private Builder() {
      super(MessageEvent.SCHEMA$);
    }

    /** Creates a Builder by copying an existing Builder */
    private Builder(MessageEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.time)) {
        this.time = data().deepCopy(fields()[0].schema(), other.time);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.host)) {
        this.host = data().deepCopy(fields()[1].schema(), other.host);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.message)) {
        this.message = data().deepCopy(fields()[2].schema(), other.message);
        fieldSetFlags()[2] = true;
      }
    }

    /** Creates a Builder by copying an existing MessageEvent instance */
    private Builder(MessageEvent other) {
            super(MessageEvent.SCHEMA$);
      if (isValidValue(fields()[0], other.time)) {
        this.time = data().deepCopy(fields()[0].schema(), other.time);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.host)) {
        this.host = data().deepCopy(fields()[1].schema(), other.host);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.message)) {
        this.message = data().deepCopy(fields()[2].schema(), other.message);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'time' field */
    public java.lang.Long getTime() {
      return time;
    }

    /** Sets the value of the 'time' field */
    public MessageEvent.Builder setTime(long value) {
      validate(fields()[0], value);
      this.time = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /** Checks whether the 'time' field has been set */
    public boolean hasTime() {
      return fieldSetFlags()[0];
    }

    /** Clears the value of the 'time' field */
    public MessageEvent.Builder clearTime() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'host' field */
    public java.lang.String getHost() {
      return host;
    }

    /** Sets the value of the 'host' field */
    public MessageEvent.Builder setHost(java.lang.String value) {
      validate(fields()[1], value);
      this.host = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /** Checks whether the 'host' field has been set */
    public boolean hasHost() {
      return fieldSetFlags()[1];
    }

    /** Clears the value of the 'host' field */
    public MessageEvent.Builder clearHost() {
      host = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'message' field */
    public java.lang.String getMessage() {
      return message;
    }

    /** Sets the value of the 'message' field */
    public MessageEvent.Builder setMessage(java.lang.String value) {
      validate(fields()[2], value);
      this.message = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /** Checks whether the 'message' field has been set */
    public boolean hasMessage() {
      return fieldSetFlags()[2];
    }

    /** Clears the value of the 'message' field */
    public MessageEvent.Builder clearMessage() {
      message = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public MessageEvent build() {
      try {
        MessageEvent record = new MessageEvent();
        record.time = fieldSetFlags()[0] ? this.time : (java.lang.Long) defaultValue(fields()[0]);
        record.host = fieldSetFlags()[1] ? this.host : (java.lang.String) defaultValue(fields()[1]);
        record.message = fieldSetFlags()[2] ? this.message : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}

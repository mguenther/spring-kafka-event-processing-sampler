/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.mguenther.springkafka.eventprocessing.serialization;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class TurbineMetrics extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8267315594068426L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TurbineMetrics\",\"namespace\":\"net.mguenther.springkafka.eventprocessing.serialization\",\"fields\":[{\"name\":\"turbineId\",\"type\":\"long\",\"doc\":\"Unique identifier for a wind turbine in the field.\"},{\"name\":\"timestamp\",\"type\":\"long\",\"doc\":\"Turbine time (in UTC) at which the data was collected. This is a Unix timestamp in seconds.\"},{\"name\":\"turbineState\",\"type\":{\"type\":\"enum\",\"name\":\"TurbineState\",\"symbols\":[\"NORMAL_OPERATION\",\"CURTAILED_OPERATION\",\"ERROR\",\"UNKNOWN\"]},\"doc\":\"The operational state of the wind turbine for the last timestep.\",\"default\":\"UNKNOWN\"},{\"name\":\"powerOutput\",\"type\":\"double\",\"doc\":\"Represents the average produced wattage for the last timestep in kW\"},{\"name\":\"windSpeed\",\"type\":\"double\",\"doc\":\"Represents the average wind speed for the last timestep in m/s\"},{\"name\":\"temperature\",\"type\":\"double\",\"doc\":\"Represents the average temperature for the last timestep in °C\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** Unique identifier for a wind turbine in the field. */
  @Deprecated public long turbineId;
  /** Turbine time (in UTC) at which the data was collected. This is a Unix timestamp in seconds. */
  @Deprecated public long timestamp;
  /** The operational state of the wind turbine for the last timestep. */
  @Deprecated public net.mguenther.springkafka.eventprocessing.serialization.TurbineState turbineState;
  /** Represents the average produced wattage for the last timestep in kW */
  @Deprecated public double powerOutput;
  /** Represents the average wind speed for the last timestep in m/s */
  @Deprecated public double windSpeed;
  /** Represents the average temperature for the last timestep in °C */
  @Deprecated public double temperature;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TurbineMetrics() {}

  /**
   * All-args constructor.
   * @param turbineId Unique identifier for a wind turbine in the field.
   * @param timestamp Turbine time (in UTC) at which the data was collected. This is a Unix timestamp in seconds.
   * @param turbineState The operational state of the wind turbine for the last timestep.
   * @param powerOutput Represents the average produced wattage for the last timestep in kW
   * @param windSpeed Represents the average wind speed for the last timestep in m/s
   * @param temperature Represents the average temperature for the last timestep in °C
   */
  public TurbineMetrics(java.lang.Long turbineId, java.lang.Long timestamp, net.mguenther.springkafka.eventprocessing.serialization.TurbineState turbineState, java.lang.Double powerOutput, java.lang.Double windSpeed, java.lang.Double temperature) {
    this.turbineId = turbineId;
    this.timestamp = timestamp;
    this.turbineState = turbineState;
    this.powerOutput = powerOutput;
    this.windSpeed = windSpeed;
    this.temperature = temperature;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return turbineId;
    case 1: return timestamp;
    case 2: return turbineState;
    case 3: return powerOutput;
    case 4: return windSpeed;
    case 5: return temperature;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: turbineId = (java.lang.Long)value$; break;
    case 1: timestamp = (java.lang.Long)value$; break;
    case 2: turbineState = (net.mguenther.springkafka.eventprocessing.serialization.TurbineState)value$; break;
    case 3: powerOutput = (java.lang.Double)value$; break;
    case 4: windSpeed = (java.lang.Double)value$; break;
    case 5: temperature = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'turbineId' field.
   * @return Unique identifier for a wind turbine in the field.
   */
  public java.lang.Long getTurbineId() {
    return turbineId;
  }

  /**
   * Sets the value of the 'turbineId' field.
   * Unique identifier for a wind turbine in the field.
   * @param value the value to set.
   */
  public void setTurbineId(java.lang.Long value) {
    this.turbineId = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return Turbine time (in UTC) at which the data was collected. This is a Unix timestamp in seconds.
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * Turbine time (in UTC) at which the data was collected. This is a Unix timestamp in seconds.
   * @param value the value to set.
   */
  public void setTimestamp(java.lang.Long value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'turbineState' field.
   * @return The operational state of the wind turbine for the last timestep.
   */
  public net.mguenther.springkafka.eventprocessing.serialization.TurbineState getTurbineState() {
    return turbineState;
  }

  /**
   * Sets the value of the 'turbineState' field.
   * The operational state of the wind turbine for the last timestep.
   * @param value the value to set.
   */
  public void setTurbineState(net.mguenther.springkafka.eventprocessing.serialization.TurbineState value) {
    this.turbineState = value;
  }

  /**
   * Gets the value of the 'powerOutput' field.
   * @return Represents the average produced wattage for the last timestep in kW
   */
  public java.lang.Double getPowerOutput() {
    return powerOutput;
  }

  /**
   * Sets the value of the 'powerOutput' field.
   * Represents the average produced wattage for the last timestep in kW
   * @param value the value to set.
   */
  public void setPowerOutput(java.lang.Double value) {
    this.powerOutput = value;
  }

  /**
   * Gets the value of the 'windSpeed' field.
   * @return Represents the average wind speed for the last timestep in m/s
   */
  public java.lang.Double getWindSpeed() {
    return windSpeed;
  }

  /**
   * Sets the value of the 'windSpeed' field.
   * Represents the average wind speed for the last timestep in m/s
   * @param value the value to set.
   */
  public void setWindSpeed(java.lang.Double value) {
    this.windSpeed = value;
  }

  /**
   * Gets the value of the 'temperature' field.
   * @return Represents the average temperature for the last timestep in °C
   */
  public java.lang.Double getTemperature() {
    return temperature;
  }

  /**
   * Sets the value of the 'temperature' field.
   * Represents the average temperature for the last timestep in °C
   * @param value the value to set.
   */
  public void setTemperature(java.lang.Double value) {
    this.temperature = value;
  }

  /**
   * Creates a new TurbineMetrics RecordBuilder.
   * @return A new TurbineMetrics RecordBuilder
   */
  public static net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder newBuilder() {
    return new net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder();
  }

  /**
   * Creates a new TurbineMetrics RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TurbineMetrics RecordBuilder
   */
  public static net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder newBuilder(net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder other) {
    return new net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder(other);
  }

  /**
   * Creates a new TurbineMetrics RecordBuilder by copying an existing TurbineMetrics instance.
   * @param other The existing instance to copy.
   * @return A new TurbineMetrics RecordBuilder
   */
  public static net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder newBuilder(net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics other) {
    return new net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder(other);
  }

  /**
   * RecordBuilder for TurbineMetrics instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TurbineMetrics>
    implements org.apache.avro.data.RecordBuilder<TurbineMetrics> {

    /** Unique identifier for a wind turbine in the field. */
    private long turbineId;
    /** Turbine time (in UTC) at which the data was collected. This is a Unix timestamp in seconds. */
    private long timestamp;
    /** The operational state of the wind turbine for the last timestep. */
    private net.mguenther.springkafka.eventprocessing.serialization.TurbineState turbineState;
    /** Represents the average produced wattage for the last timestep in kW */
    private double powerOutput;
    /** Represents the average wind speed for the last timestep in m/s */
    private double windSpeed;
    /** Represents the average temperature for the last timestep in °C */
    private double temperature;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.turbineId)) {
        this.turbineId = data().deepCopy(fields()[0].schema(), other.turbineId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.turbineState)) {
        this.turbineState = data().deepCopy(fields()[2].schema(), other.turbineState);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.powerOutput)) {
        this.powerOutput = data().deepCopy(fields()[3].schema(), other.powerOutput);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.windSpeed)) {
        this.windSpeed = data().deepCopy(fields()[4].schema(), other.windSpeed);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.temperature)) {
        this.temperature = data().deepCopy(fields()[5].schema(), other.temperature);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing TurbineMetrics instance
     * @param other The existing instance to copy.
     */
    private Builder(net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.turbineId)) {
        this.turbineId = data().deepCopy(fields()[0].schema(), other.turbineId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.turbineState)) {
        this.turbineState = data().deepCopy(fields()[2].schema(), other.turbineState);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.powerOutput)) {
        this.powerOutput = data().deepCopy(fields()[3].schema(), other.powerOutput);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.windSpeed)) {
        this.windSpeed = data().deepCopy(fields()[4].schema(), other.windSpeed);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.temperature)) {
        this.temperature = data().deepCopy(fields()[5].schema(), other.temperature);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'turbineId' field.
      * Unique identifier for a wind turbine in the field.
      * @return The value.
      */
    public java.lang.Long getTurbineId() {
      return turbineId;
    }

    /**
      * Sets the value of the 'turbineId' field.
      * Unique identifier for a wind turbine in the field.
      * @param value The value of 'turbineId'.
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder setTurbineId(long value) {
      validate(fields()[0], value);
      this.turbineId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'turbineId' field has been set.
      * Unique identifier for a wind turbine in the field.
      * @return True if the 'turbineId' field has been set, false otherwise.
      */
    public boolean hasTurbineId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'turbineId' field.
      * Unique identifier for a wind turbine in the field.
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder clearTurbineId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * Turbine time (in UTC) at which the data was collected. This is a Unix timestamp in seconds.
      * @return The value.
      */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }

    /**
      * Sets the value of the 'timestamp' field.
      * Turbine time (in UTC) at which the data was collected. This is a Unix timestamp in seconds.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder setTimestamp(long value) {
      validate(fields()[1], value);
      this.timestamp = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * Turbine time (in UTC) at which the data was collected. This is a Unix timestamp in seconds.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * Turbine time (in UTC) at which the data was collected. This is a Unix timestamp in seconds.
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder clearTimestamp() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'turbineState' field.
      * The operational state of the wind turbine for the last timestep.
      * @return The value.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineState getTurbineState() {
      return turbineState;
    }

    /**
      * Sets the value of the 'turbineState' field.
      * The operational state of the wind turbine for the last timestep.
      * @param value The value of 'turbineState'.
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder setTurbineState(net.mguenther.springkafka.eventprocessing.serialization.TurbineState value) {
      validate(fields()[2], value);
      this.turbineState = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'turbineState' field has been set.
      * The operational state of the wind turbine for the last timestep.
      * @return True if the 'turbineState' field has been set, false otherwise.
      */
    public boolean hasTurbineState() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'turbineState' field.
      * The operational state of the wind turbine for the last timestep.
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder clearTurbineState() {
      turbineState = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'powerOutput' field.
      * Represents the average produced wattage for the last timestep in kW
      * @return The value.
      */
    public java.lang.Double getPowerOutput() {
      return powerOutput;
    }

    /**
      * Sets the value of the 'powerOutput' field.
      * Represents the average produced wattage for the last timestep in kW
      * @param value The value of 'powerOutput'.
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder setPowerOutput(double value) {
      validate(fields()[3], value);
      this.powerOutput = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'powerOutput' field has been set.
      * Represents the average produced wattage for the last timestep in kW
      * @return True if the 'powerOutput' field has been set, false otherwise.
      */
    public boolean hasPowerOutput() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'powerOutput' field.
      * Represents the average produced wattage for the last timestep in kW
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder clearPowerOutput() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'windSpeed' field.
      * Represents the average wind speed for the last timestep in m/s
      * @return The value.
      */
    public java.lang.Double getWindSpeed() {
      return windSpeed;
    }

    /**
      * Sets the value of the 'windSpeed' field.
      * Represents the average wind speed for the last timestep in m/s
      * @param value The value of 'windSpeed'.
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder setWindSpeed(double value) {
      validate(fields()[4], value);
      this.windSpeed = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'windSpeed' field has been set.
      * Represents the average wind speed for the last timestep in m/s
      * @return True if the 'windSpeed' field has been set, false otherwise.
      */
    public boolean hasWindSpeed() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'windSpeed' field.
      * Represents the average wind speed for the last timestep in m/s
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder clearWindSpeed() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'temperature' field.
      * Represents the average temperature for the last timestep in °C
      * @return The value.
      */
    public java.lang.Double getTemperature() {
      return temperature;
    }

    /**
      * Sets the value of the 'temperature' field.
      * Represents the average temperature for the last timestep in °C
      * @param value The value of 'temperature'.
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder setTemperature(double value) {
      validate(fields()[5], value);
      this.temperature = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'temperature' field has been set.
      * Represents the average temperature for the last timestep in °C
      * @return True if the 'temperature' field has been set, false otherwise.
      */
    public boolean hasTemperature() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'temperature' field.
      * Represents the average temperature for the last timestep in °C
      * @return This builder.
      */
    public net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics.Builder clearTemperature() {
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public TurbineMetrics build() {
      try {
        TurbineMetrics record = new TurbineMetrics();
        record.turbineId = fieldSetFlags()[0] ? this.turbineId : (java.lang.Long) defaultValue(fields()[0]);
        record.timestamp = fieldSetFlags()[1] ? this.timestamp : (java.lang.Long) defaultValue(fields()[1]);
        record.turbineState = fieldSetFlags()[2] ? this.turbineState : (net.mguenther.springkafka.eventprocessing.serialization.TurbineState) defaultValue(fields()[2]);
        record.powerOutput = fieldSetFlags()[3] ? this.powerOutput : (java.lang.Double) defaultValue(fields()[3]);
        record.windSpeed = fieldSetFlags()[4] ? this.windSpeed : (java.lang.Double) defaultValue(fields()[4]);
        record.temperature = fieldSetFlags()[5] ? this.temperature : (java.lang.Double) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
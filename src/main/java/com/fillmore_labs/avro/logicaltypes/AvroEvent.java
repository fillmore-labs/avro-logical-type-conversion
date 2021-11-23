package com.fillmore_labs.avro.logicaltypes;

import com.google.common.base.MoreObjects;
import java.time.ZonedDateTime;
import java.util.Objects;
import org.apache.avro.Schema;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.reflect.AvroDoc;
import org.apache.avro.reflect.ReflectData;
import org.checkerframework.checker.nullness.qual.Nullable;

@SuppressWarnings("nullness:initialization.field.uninitialized")
@AvroDoc("Type documentation")
public final class AvroEvent {
  public static final ReflectData MODEL;
  public static final Schema SCHEMA;
  public static final BinaryMessageEncoder<AvroEvent> ENCODER;
  public static final BinaryMessageDecoder<AvroEvent> DECODER;

  static {
    MODEL = new ReflectData();
    MODEL.addLogicalTypeConversion(new ZonedDateTimeConversion());
    MODEL.setFastReaderEnabled(true);

    SCHEMA = MODEL.getSchema(AvroEvent.class);
    ENCODER = new BinaryMessageEncoder<>(MODEL, SCHEMA);
    DECODER = new BinaryMessageDecoder<>(MODEL, SCHEMA);
  }

  @org.apache.avro.reflect.Nullable
  public @Nullable String name;

  public ZonedDateTime time;

  @Override
  public int hashCode() {
    return Objects.hash(name, time);
  }

  @Override
  @SuppressWarnings("OperatorPrecedence")
  public boolean equals(@Nullable Object o) {
    return o == this
        || o instanceof AvroEvent
            && Objects.equals(name, ((AvroEvent) o).name)
            && Objects.equals(time, ((AvroEvent) o).time);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).omitNullValues().add("name", name).add("time", time).toString();
  }
}

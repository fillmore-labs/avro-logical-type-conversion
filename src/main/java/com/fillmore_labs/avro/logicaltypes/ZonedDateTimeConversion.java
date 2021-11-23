package com.fillmore_labs.avro.logicaltypes;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.avro.Conversion;
import org.apache.avro.LogicalType;
import org.apache.avro.Schema;

public final class ZonedDateTimeConversion extends Conversion<ZonedDateTime> {
  private static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ISO_ZONED_DATE_TIME;
  private static final String ZONEDDATETIME_STRING = "zoneddatetime-string";
  private static final ZonedDateTimeString ZONED_DATE_TIME_TYPE = new ZonedDateTimeString();

  public static ZonedDateTimeString zonedDateTimeString() {
    return ZONED_DATE_TIME_TYPE;
  }

  @Override
  public Class<ZonedDateTime> getConvertedType() {
    return ZonedDateTime.class;
  }

  @Override
  public String getLogicalTypeName() {
    return ZONEDDATETIME_STRING;
  }

  @Override
  public Schema getRecommendedSchema() {
    return zonedDateTimeString().addToSchema(Schema.create(Schema.Type.STRING));
  }

  @Override
  public ZonedDateTime fromCharSequence(CharSequence value, Schema schema, LogicalType type) {
    return ZonedDateTime.parse(value, DATE_TIME_FORMATTER);
  }

  @Override
  public CharSequence toCharSequence(ZonedDateTime value, Schema schema, LogicalType type) {
    return value.format(DATE_TIME_FORMATTER);
  }

  public static final class ZonedDateTimeString extends LogicalType {
    private ZonedDateTimeString() {
      super(ZONEDDATETIME_STRING);
    }

    @Override
    public void validate(Schema schema) {
      super.validate(schema);
      if (schema.getType() != Schema.Type.STRING) {
        throw new IllegalArgumentException(
            "ZonedDateTime (string) can only be used with an underlying string type");
      }
    }
  }
}

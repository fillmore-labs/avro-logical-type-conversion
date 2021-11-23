package com.fillmore_labs.avro.logicaltypes;

import static org.junit.Assert.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UncheckedIOException;
import org.apache.avro.Schema;
import org.junit.Test;

public final class ZonedDateTimeStringTest {
  @Test
  public void testEncoder() {
    var zonedDateTimeString = ZonedDateTimeConversion.zonedDateTimeString();

    var schema = getSchema("invalid.avsc");
    assertThrows(IllegalArgumentException.class, () -> zonedDateTimeString.validate(schema));
  }

  /**
   * Reads a Avro schame from a relative resource path.
   *
   * @param name the resources name
   * @return an Avro schema
   */
  private Schema getSchema(String name) {
    try (var resourceStream = getClass().getResourceAsStream(name)) {
      if (resourceStream == null) {
        throw new FileNotFoundException(String.format("Resource %s not found", name));
      }
      return new Schema.Parser().parse(resourceStream);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}

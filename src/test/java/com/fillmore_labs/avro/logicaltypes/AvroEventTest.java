package com.fillmore_labs.avro.logicaltypes;

import static com.google.common.truth.Truth.assertThat;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

public final class AvroEventTest {
  @Test
  public void testEncoder() throws IOException {
    var testEvent = new AvroEvent();
    testEvent.time = ZonedDateTime.now(ZoneId.systemDefault());

    var encoded = AvroEvent.ENCODER.encode(testEvent);

    // Check for single-record format (version 1) marker
    // https://avro.apache.org/docs/current/spec.html#single_object_encoding
    assertThat(encoded.get(0)).isEqualTo((byte) 0xc3);
    assertThat(encoded.get(1)).isEqualTo((byte) 0x01);

    var decoded = AvroEvent.DECODER.decode(encoded);

    assertThat(decoded).isEqualTo(testEvent);
  }

  @Test
  public void testEquals() {
    EqualsVerifier.forClass(AvroEvent.class).suppress(Warning.NONFINAL_FIELDS).verify();
  }

  @Test
  public void testToString() {
    assertThat(new AvroEvent().toString()).isNotEmpty();
  }
}

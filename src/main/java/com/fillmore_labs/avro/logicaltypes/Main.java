package com.fillmore_labs.avro.logicaltypes;

import com.google.common.flogger.FluentLogger;
import java.io.IOException;
import java.time.Duration;
import java.time.ZonedDateTime;

public final class Main {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  private Main() {}

  public static void main(String... args) throws IOException {
    logger.atInfo().log("Schema: %s", AvroEvent.SCHEMA.toString(true));

    var sampleEvent = createSampleEvent();
    DemoHelper.demo(sampleEvent);

    logger.atInfo().log("Done");
  }

  private static AvroEvent createSampleEvent() {
    var myAvroData = new AvroEvent();
    myAvroData.name = "Before midnight";
    myAvroData.time =
        ZonedDateTime.parse("2022-01-01T00:00:00-05:00[America/New_York]")
            .minus(Duration.ofNanos(1L));
    return myAvroData;
  }
}

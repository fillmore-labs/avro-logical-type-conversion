package com.fillmore_labs.avro.logicaltypes;

import com.google.common.flogger.FluentLogger;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class DemoHelper {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  private DemoHelper() {}

  public static void demo(AvroEvent event) throws IOException {
    logger.atInfo().log("Original: %s", event);

    var encoded = AvroEvent.ENCODER.encode(event);

    logger.atInfo().log("Encoded: %s", stringify(encoded));

    var decoded = AvroEvent.DECODER.decode(encoded);

    logger.atInfo().log("Decoded: %s", decoded);
  }

  public static String stringify(ByteBuffer buffer) {
    var sb = new StringBuilder(buffer.limit());
    for (var i = 0; i < buffer.limit(); i++) {
      var b = buffer.get();
      sb.append(b >= 0x20 ? (char) b : '.');
    }
    buffer.rewind();
    return sb.toString();
  }
}

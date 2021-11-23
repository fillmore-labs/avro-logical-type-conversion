load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "logicaltypes",
    srcs = glob(
        ["*.java"],
        exclude = ["Main.java"],
    ),
    visibility = ["//visibility:public"],
    deps = [
        "//toolchain:checker",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_flogger_flogger",
        "@maven//:com_google_guava_guava",
        "@maven//:org_apache_avro_avro",
    ],
)

java_binary(
    name = "main",
    srcs = ["Main.java"],
    data = ["//conf:logging"],
    jvm_flags = [
        "-Djava.util.logging.config.file=$(rootpath //conf:logging)",
        "-Dorg.apache.avro.fastread=true",  # https://issues.apache.org/jira/browse/AVRO-2247
        "-Dorg.apache.avro.specific.use_custom_coders=true",  # https://issues.apache.org/jira/browse/AVRO-2090
        "-XX:+CrashOnOutOfMemoryError",
    ],
    main_class = "com.fillmore_labs.avro.logicaltypes.Main",
    visibility = ["//visibility:public"],
    runtime_deps = [
        "@maven//:com_google_flogger_flogger_system_backend",
        "@maven//:org_slf4j_slf4j_jdk14",
    ],
    deps = [
        ":logicaltypes",
        "//toolchain:checker",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_flogger_flogger",
        "@maven//:com_google_guava_guava",
        "@maven//:org_apache_avro_avro",
    ],
)

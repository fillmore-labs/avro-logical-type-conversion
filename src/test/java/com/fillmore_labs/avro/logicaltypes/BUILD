load("@google_bazel_common//testing:test_defs.bzl", "gen_java_tests")
load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "resources",
    testonly = True,
    resources = [
        "//src/test/resources/com/fillmore_labs/avro/logicaltypes",
    ],
)

gen_java_tests(
    name = "tests",
    srcs = glob(["*.java"]),
    test_deps = [":resources"],
    deps = [
        "//src/main/java/com/fillmore_labs/avro/logicaltypes",
        "//toolchain:checker",
        "//toolchain:test",
        "@maven//:nl_jqno_equalsverifier_equalsverifier",
        "@maven//:org_apache_avro_avro",
    ],
)

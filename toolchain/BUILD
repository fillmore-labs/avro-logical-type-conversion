load("@rules_java//java:defs.bzl", "java_library", "java_plugin")

# ---
# https://checkerframework.org/manual/#nullness-checker
# https://checkerframework.org/manual/#optional-checker

java_plugin(
    name = "nullness_checker",
    processor_class = "org.checkerframework.checker.nullness.NullnessChecker",
    deps = ["@maven//:org_checkerframework_checker"],
)

java_plugin(
    name = "optional_checker",
    processor_class = "org.checkerframework.checker.optional.OptionalChecker",
    deps = ["@maven//:org_checkerframework_checker"],
)

java_library(
    name = "checker",
    exported_plugins = [
        "nullness_checker",
        "optional_checker",
    ],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = ["@maven//:org_checkerframework_checker_qual"],
)

# ---
# https://truth.dev
# https://junit.org/junit4/

java_library(
    name = "test",
    testonly = True,
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:com_google_truth_truth",
        "@maven//:junit_junit",
    ],
)

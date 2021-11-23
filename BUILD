load("@com_github_bazelbuild_buildtools//buildifier:def.bzl", "buildifier", "buildifier_test")

alias(
    name = "main",
    actual = "//src/main/java/com/fillmore_labs/avro/logicaltypes:main",
)

buildifier(
    name = "lint_fix",
    lint_mode = "fix",
    lint_warnings = ["all"],
    mode = "fix",
)

buildifier_test(
    name = "lint_check",
    size = "small",
    srcs = glob([
        "**/*.bzl",
        "**/BUILD",
        "**/BUILD.*.bazel",
        "**/BUILD.bazel",
        "**/WORKSPACE",
        "**/WORKSPACE.*.bazel",
        "**/WORKSPACE.bazel",
    ]),
    lint_mode = "warn",
    lint_warnings = ["all"],
    mode = "diff",
)

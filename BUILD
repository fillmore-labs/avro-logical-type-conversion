load("@com_github_bazelbuild_buildtools//buildifier:def.bzl", "buildifier")

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

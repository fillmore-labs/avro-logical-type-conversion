workspace(name = "com_fillmore_labs_avro_logical_type_conversion")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# ---

http_archive(
    name = "bazel_skylib",
    sha256 = "bc283cdfcd526a52c3201279cda4bc298652efa898b10b4db0837dc51652756f",
    urls = [
        "https://github.com/bazelbuild/bazel-skylib/releases/download/1.7.1/bazel-skylib-1.7.1.tar.gz",
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/1.7.1/bazel-skylib-1.7.1.tar.gz",
    ],
)

http_archive(
    name = "io_bazel_rules_go",
    sha256 = "6b65cb7917b4d1709f9410ffe00ecf3e160edf674b78c54a894471320862184f",
    urls = [
        "https://github.com/bazelbuild/rules_go/releases/download/v0.52.0/rules_go-v0.39.0.zip",
        "https://mirror.bazel.build/github.com/bazelbuild/rules_go/releases/download/v0.39.0/rules_go-v0.39.0.zip",
    ],
)

http_archive(
    name = "bazel_gazelle",
    sha256 = "aefbf2fc7c7616c9ed73aa3d51c77100724d5b3ce66cfa16406e8c13e87c8b52",
    urls = [
        "https://github.com/bazelbuild/bazel-gazelle/releases/download/v0.41.0/bazel-gazelle-v0.41.0.tar.gz",
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-gazelle/releases/download/v0.41.0/bazel-gazelle-v0.41.0.tar.gz",
    ],
)

http_archive(
    name = "com_google_protobuf",
    sha256 = "7c3ebd7aaedd86fa5dc479a0fda803f602caaf78d8aff7ce83b89e1b8ae7442a",
    strip_prefix = "protobuf-28.3",
    url = "https://github.com/protocolbuffers/protobuf/archive/refs/tags/v28.3.tar.gz",
)

http_archive(
    name = "rules_jvm_external",
    sha256 = "96f3d62aea5cf03f1d9c6945f1d0320d1b1c06aae898777fb6b4931f4538b863",
    strip_prefix = "rules_jvm_external-6.2",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/6.2.tar.gz",
)

http_archive(
    name = "com_github_bazelbuild_buildtools",
    sha256 = "1a9eaa51b2507eac7fe396811bc15dad4d15533acc61cc5b0d71004e1d0488cb",
    strip_prefix = "buildtools-8.0.0",
    url = "https://github.com/bazelbuild/buildtools/archive/refs/tags/v8.0.0.tar.gz",
)

http_archive(
    name = "google_bazel_common",
    sha256 = "df9e8a47f86866ddd90bddb39954c279250121de73dafe222aeaab22f0939ca4",
    strip_prefix = "bazel-common-9f8175287d46cdd21accb4b504a612b44c0f0564",
    url = "https://github.com/google/bazel-common/archive/9f8175287d46cdd21accb4b504a612b44c0f0564.tar.gz",
)

# ---

load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")

go_register_toolchains(go_version = "1.18")

go_rules_dependencies()

# ---

load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies")

gazelle_dependencies()

# ---

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

# ---

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")

protobuf_deps()

bind(
    name = "error_prone_annotations",
    actual = "@maven//:com_google_errorprone_error_prone_annotations",
)

bind(
    name = "gson",
    actual = "@maven//:com_google_code_gson_gson",
)

bind(
    name = "guava",
    actual = "@maven//:com_google_guava_guava",
)

bind(
    name = "jsr305",
    actual = "@maven//:com_google_code_findbugs_jsr305",
)

bind(
    name = "j2objc_annotations",
    actual = "@maven//:com_google_j2objc_j2objc_annotations",
)

# ---

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

# ---

load("@google_bazel_common//:workspace_defs.bzl", "google_common_workspace_rules")

google_common_workspace_rules()

# ---

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")

maven_install(
    artifacts = [
        "com.google.code.findbugs:jsr305:3.0.2",
        "com.google.code.gson:gson:2.11.0",
        "com.google.errorprone:error_prone_annotations:2.36.0",
        "com.google.flogger:flogger-system-backend:0.8",
        "com.google.flogger:flogger:0.8",
        "com.google.guava:guava:33.4.0-jre",
        "com.google.j2objc:j2objc-annotations:3.0.0",
        "jakarta.annotation:jakarta.annotation-api:3.0.0",
        "javax.inject:javax.inject:1",
        "org.apache.avro:avro:1.12.0",
        "org.checkerframework:checker-qual:3.48.4",
        "org.checkerframework:checker-util:3.48.4",
        "org.checkerframework:checker:3.48.4",
        "org.slf4j:slf4j-api:2.0.16",
        "org.slf4j:slf4j-jdk14:2.0.16",
        maven.artifact(
            "com.google.truth",
            "truth",
            "1.4.4",
            testonly = True,
        ),
        maven.artifact(
            "com.google.truth.extensions",
            "truth-java8-extension",
            "1.4.4",
            testonly = True,
        ),
        maven.artifact(
            "junit",
            "junit",
            "4.13.2",
            testonly = True,
        ),
        maven.artifact(
            "nl.jqno.equalsverifier",
            "equalsverifier",
            "3.18.1",
            testonly = True,
        ),
    ],
    fetch_sources = True,
    maven_install_json = "//:maven_install.json",
    override_targets = {
        "com.google.protobuf:protobuf-java": "@com_google_protobuf//:protobuf_java",
        "com.google.protobuf:protobuf-java-util": "@com_google_protobuf//:protobuf_java_util",
        "javax.annotation:javax.annotation-api": ":jakarta_annotation_jakarta_annotation_api",
        "javax.servlet:javax.servlet-api": ":jakarta_servlet_jakarta_servlet_api",
        "javax.validation:validation-api": ":jakarta_validation_jakarta_validation_api",
        "javax.ws.rs:javax.ws.rs-api": ":jakarta_ws_rs_jakarta_ws_rs_api",
    },
    repositories = [
        "https://repo1.maven.org/maven2",
        "https://repo.maven.apache.org/maven2",
        "https://maven-central-eu.storage-download.googleapis.com/maven2",
    ],
    strict_visibility = True,
)

# ---

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

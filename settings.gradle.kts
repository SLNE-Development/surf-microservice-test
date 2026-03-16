pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.slne.dev/repository/maven-public/") { name = "maven-public" }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
    id("dev.slne.surf.microservice.gradle.plugin.settings") version "1.21.11+"
    id("dev.slne.surf.surfapi.gradle.settings") version "1.21.11+"
}

rootProject.name = "surf-microservice-test"

include("surf-microservice-test-api")
include("surf-microservice-test-core:surf-microservice-test-core-common")
include("surf-microservice-test-core:surf-microservice-test-core-client")
include("surf-microservice-test-microservice")

include("surf-microservice-test-paper")
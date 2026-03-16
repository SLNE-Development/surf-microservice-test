plugins {
    id("dev.slne.surf.surfapi.gradle.core")
    id("dev.slne.surf.microservice.gradle.plugin.core")
}

surfMicroserviceCore {
    withCommon()
}

dependencies {
    api(projects.surfMicroserviceTestCore.surfMicroserviceTestCoreCommon)
}
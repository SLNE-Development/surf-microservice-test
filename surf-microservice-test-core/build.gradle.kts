plugins {
    id("dev.slne.surf.surfapi.gradle.core")
    id("dev.slne.surf.microservice.gradle.plugin.core")
}

dependencies {
    api(projects.surfMicroserviceTestApi)
}

surfMicroserviceCore {
    withCommon()
}
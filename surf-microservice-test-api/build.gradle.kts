plugins {
    id("dev.slne.surf.surfapi.gradle.core")
    id("dev.slne.surf.microservice.gradle.plugin.api")
}

surfMicroserviceApi {
    withCommon()
}
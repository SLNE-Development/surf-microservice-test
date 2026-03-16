import dev.slne.surf.microservice.gradle.plugin.utils.RabbitModule

plugins {
    id("dev.slne.surf.surfapi.gradle.core")
    id("dev.slne.surf.microservice.gradle.plugin.core")
}

surfMicroserviceCore {
    withCommon()

    withRabbitModule(RabbitModule.COMMON_API)
}

dependencies {
    api(projects.surfMicroserviceTestApi)
}
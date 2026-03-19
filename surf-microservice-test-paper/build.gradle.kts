import dev.slne.surf.surfapi.gradle.util.registerRequired

plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
}

surfPaperPluginApi {
    mainClass("dev.slne.surf.microservice.test.paper.PaperMain")

    serverDependencies {
        registerRequired("surf-rabbitmq-paper")
    }
}

dependencies {
    api(projects.surfMicroserviceTestApi)
    runtimeOnly(projects.surfMicroserviceTestCore.surfMicroserviceTestCoreRuntime)
}
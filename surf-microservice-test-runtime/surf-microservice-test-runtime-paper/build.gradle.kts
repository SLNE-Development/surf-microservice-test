import dev.slne.surf.surfapi.gradle.util.registerRequired

plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
    id("dev.slne.surf.microservice.gradle.plugin.runtime")
}

surfPaperPluginApi {
    mainClass("dev.slne.surf.microservice.test.paper.PaperMain")

    serverDependencies {
        registerRequired("surf-rabbitmq-paper")
    }
}

surfMicroserviceRuntime {
    withRuntimePaper()
}

dependencies {
    api(projects.surfMicroserviceTestApi)
    runtimeOnly(projects.surfMicroserviceTestCore.surfMicroserviceTestCoreRuntime)
}
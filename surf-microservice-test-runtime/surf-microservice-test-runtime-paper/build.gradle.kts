plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
    id("dev.slne.surf.microservice.gradle.plugin.runtime")
}

surfPaperPluginApi {
    mainClass("")
}

surfMicroserviceRuntime {
    withRuntimePaper()
}

dependencies {
    api(projects.surfMicroserviceTestApi)
    runtimeOnly(projects.surfMicroserviceTestCore.surfMicroserviceTestCoreRuntime)
}
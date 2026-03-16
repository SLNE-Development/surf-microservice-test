plugins {
    id("dev.slne.surf.surfapi.gradle.standalone")
    id("dev.slne.surf.microservice.gradle.plugin.runtime")
}

dependencies {
    api(projects.surfMicroserviceTestCore.surfMicroserviceTestCoreCommon)
    runtimeOnly(projects.surfMicroserviceTestCore.surfMicroserviceTestCoreRuntime)
//    compileOnlyApi("core-api")
//    runtimeOnly("core-runtime")
}

surfStandaloneApi {
    withSurfDatabaseR2dbc("1.3.0", "dev.slne.surf.microservice.test.microservice.libs")
}

surfMicroserviceRuntime {
    withRuntimeMicroservice()
}
plugins {
    id("dev.slne.surf.surfapi.gradle.standalone")
    id("dev.slne.surf.microservice.gradle.plugin.runtime")
}

dependencies {
    api(projects.surfMicroserviceTestCore)
}

surfStandaloneApi {
    withSurfDatabaseR2dbc("1.3.0", "dev.slne.surf.microservice.test.microservice.libs")
}

surfMicroserviceRuntime {
    withRuntimeMicroservice()
}
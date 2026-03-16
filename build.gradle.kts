buildscript {
    repositories {
        gradlePluginPortal()
        maven("https://repo.slne.dev/repository/maven-public/") { name = "maven-public" }
    }
    dependencies {
        classpath("dev.slne.surf:surf-api-gradle-plugin:1.21.11+")
        classpath("dev.slne.surf.microservice:surf-microservice-gradle-plugin:1.21.11+")
    }
}

allprojects {
    group = "dev.slne.surf.microservice.test"
    version = findProperty("version") as String
}
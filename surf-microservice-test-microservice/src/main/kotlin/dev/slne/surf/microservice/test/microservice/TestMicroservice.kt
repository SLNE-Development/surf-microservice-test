package dev.slne.surf.microservice.test.microservice

import com.google.auto.service.AutoService
import dev.slne.surf.microservice.api.microservice.Microservice
import dev.slne.surf.microservice.test.microservice.core.common.TestInstance

@AutoService(Microservice::class)
class TestMicroservice : Microservice() {

    override suspend fun onBootstrap(args: List<String>) {
        TestInstance.onLoad()
        TestInstance.onEnable()
    }

    override suspend fun onDisable() {
        TestInstance.onDisable()
    }
}
package dev.slne.surf.microservice.test.microservice

import com.google.auto.service.AutoService
import dev.slne.surf.microservice.api.microservice.Microservice

@AutoService(Microservice::class)
class TestMicroservice : Microservice() {
    override suspend fun onBootstrap(args: List<String>) {

    }

    override suspend fun onDisable() {
        
    }
}
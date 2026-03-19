package dev.slne.surf.microservice.test.microservice.core.runtime

import com.google.auto.service.AutoService
import dev.slne.surf.microservice.test.microservice.core.common.TestInstance
import dev.slne.surf.rabbitmq.api.ClientRabbitMQApi

@AutoService(TestInstance::class)
class TestInstanceImpl : TestInstance {
    lateinit var rabbitApi: ClientRabbitMQApi
        private set

    override suspend fun onLoad() {
        rabbitApi = ClientRabbitMQApi.create(1, "surf-test")
        rabbitApi.freezeAndConnect()
    }

    override suspend fun onEnable() {

    }

    override suspend fun onDisable() {
        rabbitApi.disconnect()
    }
}

val testInstanceImpl get() = TestInstance.INSTANCE as TestInstanceImpl
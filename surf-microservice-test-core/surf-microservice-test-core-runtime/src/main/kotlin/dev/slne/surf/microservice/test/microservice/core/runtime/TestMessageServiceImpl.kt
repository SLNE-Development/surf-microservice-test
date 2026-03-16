package dev.slne.surf.microservice.test.microservice.core.runtime

import com.google.auto.service.AutoService
import dev.slne.surf.microservice.test.microservice.api.TestMessage
import dev.slne.surf.microservice.test.microservice.api.TestMessageService

@AutoService(TestMessageService::class)
class TestMessageServiceImpl : TestMessageService {
    override suspend fun saveMessage(message: TestMessage): Boolean {
        // Rabbit packet send

        return false
    }
}
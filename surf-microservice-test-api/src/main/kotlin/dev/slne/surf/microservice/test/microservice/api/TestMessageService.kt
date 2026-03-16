package dev.slne.surf.microservice.test.microservice.api

import dev.slne.surf.surfapi.core.api.util.requiredService

private val service = requiredService<TestMessageService>()

interface TestMessageService {
    suspend fun saveMessage(message: TestMessage): Boolean

    companion object : TestMessageService by service
}
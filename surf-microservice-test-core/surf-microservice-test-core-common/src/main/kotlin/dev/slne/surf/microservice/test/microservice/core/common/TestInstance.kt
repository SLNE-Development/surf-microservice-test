package dev.slne.surf.microservice.test.microservice.core.common

import dev.slne.surf.surfapi.core.api.util.requiredService

private val instance = requiredService<TestInstance>()

interface TestInstance {
    suspend fun onLoad()
    suspend fun onEnable()
    suspend fun onDisable()

    companion object : TestInstance by instance {
        val INSTANCE get() = instance
    }
}
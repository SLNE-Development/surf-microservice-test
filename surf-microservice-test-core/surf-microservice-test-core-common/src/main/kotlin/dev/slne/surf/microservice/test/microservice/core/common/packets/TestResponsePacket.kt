package dev.slne.surf.microservice.test.microservice.core.common.packets

import kotlinx.serialization.Serializable

@Serializable
data class TestResponsePacket(
    val message: String
)

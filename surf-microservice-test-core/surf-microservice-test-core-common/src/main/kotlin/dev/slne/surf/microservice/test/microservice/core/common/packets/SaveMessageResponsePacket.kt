package dev.slne.surf.microservice.test.microservice.core.common.packets

import dev.slne.surf.rabbitmq.api.packet.RabbitResponsePacket
import kotlinx.serialization.Serializable

@Serializable
data class SaveMessageResponsePacket(
    val result: Boolean
) : RabbitResponsePacket()

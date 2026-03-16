package dev.slne.surf.microservice.test.microservice.core.common.packets

import dev.slne.surf.microservice.test.microservice.api.TestMessage
import dev.slne.surf.rabbitmq.api.packet.RabbitRequestPacket
import kotlinx.serialization.Serializable

@Serializable
class SaveMessageRequestPacket(
    val message: TestMessage
) : RabbitRequestPacket<SaveMessageResponsePacket>()
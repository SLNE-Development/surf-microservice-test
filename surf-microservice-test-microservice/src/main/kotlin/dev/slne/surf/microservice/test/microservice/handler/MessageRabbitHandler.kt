package dev.slne.surf.microservice.test.microservice.handler

import dev.slne.surf.microservice.test.microservice.core.common.packets.SaveMessageRequestPacket
import dev.slne.surf.microservice.test.microservice.core.common.packets.SaveMessageResponsePacket
import dev.slne.surf.microservice.test.microservice.db.TestMessageRepository
import dev.slne.surf.rabbitmq.api.handler.RabbitHandler
import kotlinx.coroutines.launch

object MessageRabbitHandler {
    @RabbitHandler
    fun onSaveRequest(request: SaveMessageRequestPacket) {
        request.launch {
            TestMessageRepository.saveMessage(request.message)

            request.respond(SaveMessageResponsePacket(result = true))
        }
    }
}
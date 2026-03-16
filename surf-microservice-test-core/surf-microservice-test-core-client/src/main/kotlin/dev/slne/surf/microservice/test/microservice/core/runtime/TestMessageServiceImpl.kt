package dev.slne.surf.microservice.test.microservice.core.runtime

import com.google.auto.service.AutoService
import dev.slne.surf.microservice.test.microservice.api.TestMessage
import dev.slne.surf.microservice.test.microservice.api.TestMessageService
import dev.slne.surf.microservice.test.microservice.core.common.packets.SaveMessageRequestPacket

@AutoService(TestMessageService::class)
class TestMessageServiceImpl : TestMessageService {
    override suspend fun saveMessage(message: TestMessage): Boolean {
        return testInstanceImpl.rabbitApi.sendRequest(SaveMessageRequestPacket(message)).result
    }
}
package dev.slne.surf.microservice.test.paper

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import dev.slne.surf.microservice.test.microservice.api.TestMessage
import dev.slne.surf.microservice.test.microservice.api.TestMessageService

class PaperMain : SuspendingJavaPlugin() {
    override suspend fun onLoadAsync() {
        TestMessageService.saveMessage(TestMessage("test"))
    }
}
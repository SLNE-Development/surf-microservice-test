package dev.slne.surf.microservice.test.paper

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import com.github.shynixn.mccoroutine.folia.launch
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.getValue
import dev.jorel.commandapi.kotlindsl.greedyStringArgument
import dev.slne.surf.microservice.test.microservice.api.TestInstance
import dev.slne.surf.microservice.test.microservice.api.TestMessage
import dev.slne.surf.microservice.test.microservice.api.TestMessageService
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText

class PaperMain : SuspendingJavaPlugin() {
    override suspend fun onLoadAsync() {
        TestInstance.onLoad()
    }

    override suspend fun onEnableAsync() {
        TestInstance.onEnable()

        commandAPICommand("save-message") {
            greedyStringArgument("message")

            anyExecutor { sender, arguments ->
                val message: String by arguments

                launch {
                    val result = TestMessageService.saveMessage(TestMessage(message))

                    if (result) {
                        sender.sendText {
                            appendSuccessPrefix()

                            success("Die Nachricht mit dem Inhalt ")
                            variableValue(message)
                            success(" wurde erfolgreich gespeichert.")
                        }
                    } else {
                        sender.sendText {
                            appendErrorPrefix()

                            error("Die Nachricht mit dem Inhalt ")
                            variableValue(message)
                            error(" konnte nicht gespeichert werden.")
                        }
                    }
                }
            }
        }
    }

    override suspend fun onDisableAsync() {
        TestInstance.onDisable()
    }
}
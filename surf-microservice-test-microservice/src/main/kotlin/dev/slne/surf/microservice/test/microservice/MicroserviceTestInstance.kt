package dev.slne.surf.microservice.test.microservice

import com.google.auto.service.AutoService
import dev.slne.surf.database.DatabaseApi
import dev.slne.surf.database.libs.org.jetbrains.exposed.v1.r2dbc.SchemaUtils
import dev.slne.surf.database.libs.org.jetbrains.exposed.v1.r2dbc.transactions.suspendTransaction
import dev.slne.surf.microservice.api.microservice.Microservice
import dev.slne.surf.microservice.test.microservice.core.common.CommonTestInstance
import dev.slne.surf.microservice.test.microservice.core.common.TestInstance
import dev.slne.surf.microservice.test.microservice.db.tables.TestMessagesTable
import dev.slne.surf.microservice.test.microservice.handler.MessageRabbitHandler
import dev.slne.surf.rabbitmq.api.ServerRabbitMQApi
import kotlin.io.path.Path

@AutoService(TestInstance::class)
class MicroserviceTestInstance : Microservice() {
    private val databaseApi = DatabaseApi.create(Path("data/database"))
    private val rabbitApi = ServerRabbitMQApi.create(1, "surf-test")

    override suspend fun onLoad() {
        rabbitApi.registerRequestHandler(MessageRabbitHandler)

        suspendTransaction {
            SchemaUtils.create(TestMessagesTable)
        }
    }

    override suspend fun onEnable() {
        rabbitApi.freezeAndConnect()
    }

    override suspend fun onDisable() {
        rabbitApi.disconnect()
        databaseApi.shutdown()
    }
}
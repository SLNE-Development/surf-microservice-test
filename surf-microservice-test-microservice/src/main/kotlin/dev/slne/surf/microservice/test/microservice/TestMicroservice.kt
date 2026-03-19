package dev.slne.surf.microservice.test.microservice

import com.google.auto.service.AutoService
import dev.slne.surf.database.DatabaseApi
import dev.slne.surf.database.libs.org.jetbrains.exposed.v1.r2dbc.SchemaUtils
import dev.slne.surf.database.libs.org.jetbrains.exposed.v1.r2dbc.transactions.suspendTransaction
import dev.slne.surf.microservice.api.microservice.Microservice
import dev.slne.surf.microservice.test.microservice.db.tables.TestMessagesTable
import dev.slne.surf.microservice.test.microservice.handler.MessageRabbitHandler
import dev.slne.surf.rabbitmq.api.ServerRabbitMQApi
import kotlin.io.path.Path

@AutoService(Microservice::class)
class TestMicroservice : Microservice() {
    private val databaseApi = DatabaseApi.create(Path("data/database"))
    private val rabbitApi = ServerRabbitMQApi.create(1, "surf-test")

    override suspend fun onBootstrap(args: List<String>) {
        suspendTransaction {
            SchemaUtils.create(TestMessagesTable)
        }

        rabbitApi.registerRequestHandler(MessageRabbitHandler)
        rabbitApi.freezeAndConnect()
    }

    override suspend fun onDisable() {
        rabbitApi.disconnect()
        databaseApi.shutdown()
    }
}
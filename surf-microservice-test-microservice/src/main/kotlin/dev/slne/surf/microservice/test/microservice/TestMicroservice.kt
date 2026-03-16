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
    private lateinit var databaseApi: DatabaseApi
    private lateinit var rabbitApi: ServerRabbitMQApi

    override suspend fun onBootstrap(args: List<String>) {
        databaseApi = DatabaseApi.create(Path("data/database"))

        suspendTransaction {
            SchemaUtils.create(TestMessagesTable)
        }

        rabbitApi = ServerRabbitMQApi.create(1, "surf-test")
        rabbitApi.registerRequestHandler(MessageRabbitHandler)
        rabbitApi.freezeAndConnect()
    }

    override suspend fun onDisable() {
        rabbitApi.disconnect()
        databaseApi.shutdown()
    }
}
package dev.slne.surf.microservice.test.microservice.db

import dev.slne.surf.database.libs.org.jetbrains.exposed.v1.r2dbc.insert
import dev.slne.surf.database.libs.org.jetbrains.exposed.v1.r2dbc.transactions.suspendTransaction
import dev.slne.surf.microservice.test.microservice.api.TestMessage
import dev.slne.surf.microservice.test.microservice.db.tables.TestMessagesTable

object TestMessageRepository {
    suspend fun saveMessage(message: TestMessage) = suspendTransaction {
        TestMessagesTable.insert {
            it[this.content] = message.content
        }
    }
}
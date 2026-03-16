package dev.slne.surf.microservice.test.microservice.db.tables

import dev.slne.surf.database.libs.org.jetbrains.exposed.v1.core.dao.id.ULongIdTable

object TestMessagesTable : ULongIdTable("test_messages") {
    val content = largeText("message")
}
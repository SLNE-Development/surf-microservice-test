package dev.slne.surf.microservice.test.microservice.api

import kotlinx.serialization.Serializable

@Serializable
data class TestMessage(
    val content: String
)

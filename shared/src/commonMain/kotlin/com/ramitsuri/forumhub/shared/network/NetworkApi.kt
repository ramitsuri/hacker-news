package com.ramitsuri.forumhub.shared.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.util.*

abstract class NetworkApi {

    @KtorExperimentalAPI
    val httpClient = HttpClient(CIO) {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            }
            serializer = KotlinxSerializer(json)
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }
    }
}
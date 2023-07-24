package com.dasoops.dasqr.plugin.http.server

import com.dasoops.common.http.server.ktor.ApplicationExtension
import com.dasoops.common.json.jackson.Jackson
import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.server.plugins.contentnegotiation.*

object KtorJacksonExtension : ApplicationExtension {
    override val handler: ContentNegotiationConfig.() -> Unit = {
        register(ContentType.Application.Json, JacksonConverter(Jackson.INSTANCE.serializer))
    }
}
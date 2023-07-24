package com.dasoops.dasqr.plugin.alas

import com.dasoops.common.http.server.ktor.HttpHandler
import com.dasoops.dasqr.core.IBot
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory

object AlasHttpHandler : HttpHandler {
    private val logger = LoggerFactory.getLogger(javaClass)
    override val handler: Application.() -> Unit = {
        routing {
            data class AlasErrorParam(
                val noticeUserId: List<Long>,
                val title: String,
                val content: String,
            )
            post("/alas/error") {
                val (noticeUserId, title, content) = call.receive(AlasErrorParam::class)
                noticeUserId.forEach {
                    IBot.getFriend(it)?.sendMessage(
                        """
                        |AlasError: {
                        |  title: $title
                        |  context: $content
                        |}
                    """.trimMargin()
                    ) ?: run {
                        logger.error("未找到好友[$it]")
                    }
                }
                context.respond("ok")
            }
        }
    }
}
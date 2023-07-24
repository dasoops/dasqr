package com.dasoops.dasqr.plugin.http.server

import com.dasoops.common.http.server.ktor.KtorServer
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.runner.Runner
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 * okHttp客户端runner
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 */
open class HttpServerRunner : Runner {
    val logger: Logger = LoggerFactory.getLogger(HttpServerRunner::class.java)

    companion object {
        lateinit var INSTANCE: HttpServerRunner
    }

    override suspend fun init() {
        INSTANCE = this
        val httpConfig = Config.INSTANCE.httpServer
        if (httpConfig.enable) {
            KtorServer(
                port = httpConfig.port,
                scanBasePath = Config.INSTANCE.dasqr.plugin.scanPathList
            ).start()
        }
    }
}
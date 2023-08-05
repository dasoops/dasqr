package com.dasoops.dasqr.plugin.http.client

import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.runner.Runner
import okhttp3.OkHttpClient
import java.net.InetSocketAddress
import java.net.Proxy

/**
 * okHttp客户端runner
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 */
open class OkHttpRunner : Runner {
    lateinit var instance: OkHttpClient
    lateinit var noProxyInstance: OkHttpClient

    companion object {
        lateinit var INSTANCE: OkHttpRunner
    }

    override suspend fun init() {
        INSTANCE = this
        val httpConfig = Config.INSTANCE.httpClient
        if (httpConfig.enable) {
            instance = OkHttpClient.Builder().run {
                proxy(Proxy(Proxy.Type.HTTP, InetSocketAddress(httpConfig.proxyHostName!!, httpConfig.proxyPort!!)))
                build()
            }
            noProxyInstance = OkHttpClient.Builder().build()
        } else {
            instance = OkHttpClient.Builder().build()
            noProxyInstance = instance
        }
    }
}

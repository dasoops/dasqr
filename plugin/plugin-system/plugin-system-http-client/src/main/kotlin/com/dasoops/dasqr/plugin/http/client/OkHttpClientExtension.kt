package com.dasoops.dasqr.plugin.http.client

import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.json.toJsonStr
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.getOrNull
import com.dasoops.dasqr.core.runner.Runner
import okhttp3.OkHttpClient
import java.net.InetSocketAddress
import java.net.Proxy

val Config.http: HttpProxyConfig
    get() {
        getOrNull<HttpProxyConfig>("httpProxy")?.run {
            return this
        }
        //初始化
        addAndInit("httpProxy", "http代理配置项", HttpProxyConfig(false).toJsonStr())
        return getOrNull<HttpProxyConfig>("httpProxy")!!
    }

/**
 * http配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/09
 * @see [HttpProxyConfig]
 */
class HttpProxyConfig(
    enable: Boolean,
    proxyHostName: String? = null,
    proxyPort: Int? = null
) {

    /**
     * 是否启用
     */
    val enable: Boolean

    /**
     * 主机
     * example: 127.0.0.1
     */
    val proxyHostName: String?

    /**
     * 端口
     */
    val proxyPort: Int?

    init {
        this.enable = enable
        if (enable) {
            this.proxyHostName = proxyHostName ?: throw SimpleProjectExceptionEntity("配置项http.proxyHostName不可为空")
            this.proxyPort = proxyPort ?: throw SimpleProjectExceptionEntity("配置项http.proxyPort不可为空")
        } else {
            this.proxyHostName = null
            this.proxyPort = null
        }
    }
}

/**
 * okHttp客户端runner
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 */
object OkHttpRunner : Runner {
    lateinit var instance: OkHttpClient
    lateinit var noProxyInstance: OkHttpClient

    override suspend fun init() {
        val httpConfig = Config.INSTANCE.http
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

    /**
     * 实例
     */
    val OkHttpClient.Companion.INSTANCE: OkHttpClient
        get() = instance

    /**
     * 无代理实例
     */
    val OkHttpClient.Companion.NO_PROXY_INSTANCE: OkHttpClient
        get() = noProxyInstance
}

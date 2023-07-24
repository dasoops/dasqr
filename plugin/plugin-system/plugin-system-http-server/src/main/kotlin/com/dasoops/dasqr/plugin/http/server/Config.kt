package com.dasoops.dasqr.plugin.http.server

import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.json.core.toJsonStr
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.getOrNull

val Config.httpServer: HttpServerConfig
    get() {
        getOrNull<HttpServerConfig>("httpServer")?.run {
            return this
        }
        //初始化
        addAndInit("httpServer", "http服务端配置", HttpServerConfig(false).toJsonStr())
        return getOrNull<HttpServerConfig>("httpServer")!!
    }

/**
 * http配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/09
 * @see [HttpServerConfig]
 */
class HttpServerConfig(
    enable: Boolean,
    port: Int? = null,
) {

    /**
     * 是否启用
     */
    val enable: Boolean

    /**
     * 端口
     */
    val port: Int

    init {
        this.enable = enable
        if (enable) {
            this.port = port ?: throw SimpleProjectExceptionEntity("配置项http.proxyHostName不可为空")
        } else {
            this.port = 6543
        }
    }
}
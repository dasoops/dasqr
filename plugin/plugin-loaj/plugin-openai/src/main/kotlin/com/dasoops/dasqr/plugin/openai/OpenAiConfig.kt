package com.dasoops.dasqr.plugin.openai


/**
 * openAi配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/15
 * @see [OpenAiConfig]
 */
class OpenAiConfig(
    token: String,
    model: String? = null,
    proxy: ProxyConfig? = null
) {

    /**
     * token
     */
    val token: String

    /**
     * model
     * example: gpt-3.5-turbo
     */
    val model: String

    /**
     * 访问代理
     */
    val proxy: ProxyConfig?

    init {
        this.token = token
        this.model = model ?: "gpt-3.5-turbo"
        this.proxy = proxy
    }
}

/**
 * 代理配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/15
 * @see [ProxyConfig]
 */
class ProxyConfig(
    /**
     * 主机
     * example: 127.0.0.1
     */
    val hostName: String,

    /**
     * 端口
     */
    val port: Int
)
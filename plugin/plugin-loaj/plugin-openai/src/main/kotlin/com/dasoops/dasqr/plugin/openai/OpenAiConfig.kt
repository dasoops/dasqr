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

    init {
        this.token = token
        this.model = model ?: "gpt-3.5-turbo"
    }
}
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
    `miao~`: Boolean? = null
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
     * 是否默认添加 喵~ 的设定
     */
    val `miao~`: Boolean

    init {
        this.token = token
        this.model = model ?: "gpt-3.5-turbo"
        this.`miao~` = `miao~` ?: false
    }
}
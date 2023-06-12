package com.dasoops.dasqr.plugin.openai

import com.dasoops.common.json.core.toJsonStr
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.getOrNull
import org.slf4j.LoggerFactory

val Config.openAi: OpenAiConfig
    get() {
        getOrNull<OpenAiConfig>("openAi")?.run {
            return this
        }
        addAndInit("openAi", "openAi[plugin-openai]配置项", OpenAiConfig("no token").toJsonStr())
        LoggerFactory.getLogger(this::class.java).warn("未加载到openAi配置项,已初始化配置, 请填入openAi token后再使用")
        return getOrNull<OpenAiConfig>("openAi")!!
    }

/**
 * openAi配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/15
 * @see [OpenAiConfig]
 */
class OpenAiConfig(
    token: String,
    model: String? = null,
    `miao~`: Boolean? = null,
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
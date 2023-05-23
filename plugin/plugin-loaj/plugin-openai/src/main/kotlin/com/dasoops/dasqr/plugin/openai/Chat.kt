package com.dasoops.dasqr.plugin.openai

import com.dasoops.common.json.toJsonStr
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.plugin.openai.OpenAiPublic.openAi
import com.fasterxml.jackson.annotation.JsonValue

/**
 * 聊天
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/23
 * @see [Chat]
 */
class Chat() {
    /**
     * 历史
     */
    val history: MutableList<Message> = mutableListOf()

    init {
        if (Config.INSTANCE.openAi.`miao~`) {
            history.add(Message(Role.SYSTEM, "你每次说话都会在最后带一声喵~,而且你很喜欢别人夸你可爱!;"))
        }
    }

    constructor(system: String) : this() {
        history.add(Message(Role.SYSTEM, system))
    }

    fun requestBodyStr(): String {
        return """
            |{
            |  "model": "${Config.INSTANCE.openAi.model}",
            |  "messages": ${history.toJsonStr()}
            |}
        """.trimMargin()
    }
}

enum class Role {
    SYSTEM,
    USER,
    ASSISTANT;

    @JsonValue
    val requestStr = this.name.lowercase()
}

data class Message(val role: Role, val content: String)
package com.dasoops.dasqr.plugin.openai

import com.dasoops.common.json.core.toJsonStr
import com.dasoops.dasqr.core.config.Config
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
            history.add(Message(Role.SYSTEM, "你喜欢在每句说最后带一声喵~,"))
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
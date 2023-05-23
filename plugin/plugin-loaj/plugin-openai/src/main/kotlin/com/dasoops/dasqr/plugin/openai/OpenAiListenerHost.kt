package com.dasoops.dasqr.plugin.openai

import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.json.Json
import com.dasoops.common.json.toJsonStr
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.getOrNull
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.plugin.config.Cache
import com.dasoops.dasqr.plugin.http.client.OkHttpRunner.INSTANCE
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.SocketTimeoutException
import kotlin.jvm.Throws

object OpenAiPublic : cn.hutool.cache.Cache<Member, Chat> by Cache.newTimedCache(OpenAiPublic::class, 10 * 60 * 1000) {
    val log: Logger = LoggerFactory.getLogger(javaClass)
    val Config.openAi: OpenAiConfig
        get() {
            getOrNull<OpenAiConfig>("openAi")?.run {
                return this
            }
            addAndInit("openAi", "openAi[plugin-openai]配置项", OpenAiConfig("no token").toJsonStr())
            log.warn("未加载到openAi配置项,已初始化配置, 请填入openAi token后再使用")
            return getOrNull<OpenAiConfig>("openAi")!!
        }

    @Throws(SimpleProjectExceptionEntity::class)
    fun sendAndGet(sender: Member, message: String): String {
        val cacheChat = get(sender)
        val chat = cacheChat ?: Chat()
        val buildMessage = Message(Role.USER, message)
        chat.history.add(buildMessage)

        val config = Config.INSTANCE.openAi
        val requestBodyStr = chat.requestBodyStr()

        log.debug("send openAi request: $requestBodyStr")
        val request = Request.Builder()
            .url("https://api.openai.com/v1/chat/completions")
            .addHeader("Authorization", "Bearer ${config.token}")
            .addHeader("Content-Type", "application/json")
            .post(requestBodyStr.toRequestBody())
            .build()
        try {
            val bodyString = OkHttpClient.INSTANCE.newCall(request).execute().body.string()
            val jsonNode = Json.parseNode(bodyString)
            if (jsonNode.get("error") != null) {
                log.warn(bodyString)
                chat.history.remove(buildMessage)
                throw SimpleProjectExceptionEntity("openAi Api响应为server_error, 要不要给他来一jio?")
            }
            log.trace(bodyString)
            val responseMsg = jsonNode.get("choices")[0].get("message").get("content").asText()
            cacheChat?.also {
                chat.history.add(Message(Role.ASSISTANT, responseMsg))
                put(sender, chat)
            }
            return responseMsg
        } catch (e: SocketTimeoutException) {
            throw SimpleProjectExceptionEntity("api响应超时了捏, 要不给他一拳?")
        }
    }
}

/**
 * 消息回复listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/10
 * @see [OpenAiListenerHost]
 */
open class OpenAiListenerHost : DslListenerHost({

    group("openAi") {
        startsWith("openAi") {
            try {
                subject.sendMessage(this.message.quote() + OpenAiPublic.sendAndGet(sender, it))
            } catch (e: SimpleProjectExceptionEntity) {
                subject.sendMessage(this.message.quote() + e.message)
            }
        }

        startsWith("chat go") {
            val chat = if (it.isBlank()) {
                Chat()
            } else {
                Chat(it)
            }
            OpenAiPublic.put(sender, chat)
            subject.sendMessage("ok")
        }

        case("end chat") {
            OpenAiPublic.remove(sender)
        }
    }
})
package com.dasoops.dasqr.plugin.openai

import com.dasoops.common.json.Json
import com.dasoops.common.json.toJsonStr
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.getOrNull
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.plugin.http.client.OkHttpRunner.INSTANCE
import com.dasoops.dasqr.plugin.openai.OpenAiPublic.openAi
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object OpenAiPublic {
    val log: Logger = LoggerFactory.getLogger(javaClass)
    val Config.openAi: OpenAiConfig
        get() {
            getOrNull<OpenAiConfig>("openAi")?.run {
                return this
            }
            addAndInit("openAi", "openAi[plugin-openai]配置项", OpenAiConfig("no token").toJsonStr())
            log.warn("未加载到openAi配置项,已初始化配置,请填入openAi token后再使用")
            return getOrNull<OpenAiConfig>("openAi")!!
        }
}


/**
 * 消息回复listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/10
 * @see [OpenAiListenerHost]
 */
open class OpenAiListenerHost : DslListenerHost({
    val log = LoggerFactory.getLogger(javaClass)
    val config = Config.INSTANCE.openAi

    group("openAi") {
        startsWith("openAi") {
            val request = Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .addHeader("Authorization", "Bearer ${config.token}")
                .addHeader("Content-Type", "application/json")
                .post(
                    """
                    |{
                    |  "model": "${config.model}",
                    |  "messages": [{"role": "user", "content": "$it"}]
                    |}""".trimMargin().toRequestBody()
                )
                .build()
            val response = OkHttpClient.INSTANCE.newCall(request).execute()
            val jsonResult = response.body.string()
            log.debug(jsonResult)
            val message = Json.parseNode(jsonResult)
                .get("choices")[0].get("message").get("content").asText()

            subject.sendMessage(this.message.quote() + message)
        }
    }
})
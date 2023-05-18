package com.dasoops.dasqr.plugin.sao

import com.dasoops.common.json.Json
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.plugin.OkHttpRunner.NO_PROXY_INSTANCE
import net.mamoe.mirai.message.data.at
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory

object SaoPublic {
    //10分钟缓存
    private val log = LoggerFactory.getLogger(javaClass)

    fun getSao(): String {
        log.debug("请求骚话api")

        return Json.parseNode(
            OkHttpClient.NO_PROXY_INSTANCE.newCall(
                Request.Builder()
                    .url("https://api.uomg.com/api/rand.qinghua")
                    .get().build()
            ).execute().body.string()
        ).get("content").asText()
    }
}

/**
 * 消息回复listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/10
 * @see [SaoListenerHost]
 */
open class SaoListenerHost : DslListenerHost({
    group("zhihu news") {
        case("来句骚话") quoteReply {
            intercept()
            SaoPublic.getSao()
        }
        case("随机骚话") reply {
            intercept()
            subject.members.random().at() + SaoPublic.getSao()
        }
    }
})
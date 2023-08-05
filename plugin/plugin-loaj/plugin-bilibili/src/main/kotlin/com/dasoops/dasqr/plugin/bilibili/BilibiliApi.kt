package com.dasoops.dasqr.plugin.bilibili

import cn.hutool.core.date.DateUtil
import cn.hutool.core.exceptions.ExceptionUtil
import cn.hutool.core.math.BitStatusUtil.has
import cn.hutool.core.util.EscapeUtil
import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.json.core.Json
import com.dasoops.common.json.core.toJsonStr
import com.dasoops.common.json.jackson.Jackson
import com.dasoops.common.json.jackson.parseNode
import com.dasoops.dasqr.plugin.http.client.NO_PROXY_INSTANCE
import com.fasterxml.jackson.databind.JsonNode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory

object BilibiliApi {
    private val logger = LoggerFactory.getLogger(javaClass)

    //string
    private fun JsonNode?.s(fieldName: String): String {
        this ?: return ""
        return get(fieldName)?.asText() ?: return ""
    }

    //stringToNode
    private fun JsonNode.sn(fieldName: String): JsonNode {
        return Json.parseNode(get(fieldName)?.asText() ?: "")
    }

    //node
    private fun JsonNode.n(fieldName: String): JsonNode {
        return get(fieldName)
    }

    /**
     * 获取动态
     * @return [JsonNode]
     */
    suspend fun getDynamic(userId: Long): List<Dynamic> = withContext(Dispatchers.IO) {
        val resultJsonStr = OkHttpClient.NO_PROXY_INSTANCE
            .newCall(Request("https://api.vc.bilibili.com/dynamic_svr/v1/dynamic_svr/space_history?host_uid=$userId".toHttpUrl()))
            .run { async(Dispatchers.IO) { execute() }.await() }.body.string()
        logger.trace("request dynamic for user[$userId], result: $resultJsonStr")

        Json.parseNode(resultJsonStr)["data"]["cards"].mapNotNull {
            return@mapNotNull runCatching {
                val (authorName, time, id, type) = it["desc"].run {
                    data class Temp(val authorName: String, val time: Long, val id: Long, val type: Int)
                    Temp(
                        n("user_profile").n("info").s("uname"),
                        n("timestamp").asLong() * 1000,
                        n("dynamic_id").asLong(),
                        s("type").toInt()
                    )
                }

                when (type) {
                    //转发
                    1 -> {
                        it.sn("card").sn("origin").run {
                            if (has("item")) {
                                sn("item").run {
                                    Share(
                                        title = if (has("title")) {
                                            s("title")
                                        } else if (has("content")) {
                                            s("content")
                                        } else {
                                            ""
                                        },
                                        link = "",
                                        imageLink = if (has("pictures")) {
                                            sn("pictures").firstOrNull()?.asText("") ?: ""
                                        } else if (has("pic")) {
                                            s("pic")
                                        } else {
                                            ""
                                        },
                                        id = id,
                                        authorName = authorName,
                                        time = DateUtil.date(time)
                                    )
                                }
                            } else {
                                Share(
                                    title = s("title"),
                                    link = s("short_link_v2"),
                                    imageLink = s("first_frame"),
                                    id = id,
                                    authorName = authorName,
                                    time = DateUtil.date(time)
                                )
                            }
                        }
                    }

                    //消息
                    2 -> {
                        it.sn("card").n("item").run {
                            Message(
                                description = EscapeUtil.unescape(s("description")),
                                imageLinkList = n("pictures").map { imgNode -> imgNode.s("img_src") },
                                id = id,
                                authorName = authorName,
                                time = DateUtil.date(time)
                            )
                        }
                    }

                    //消息
                    4 -> {
                        it.sn("card").sn("item").run {
                            Message(
                                description = EscapeUtil.unescape(s("content")),
                                imageLinkList = emptyList(),
                                id = id,
                                authorName = authorName,
                                time = DateUtil.date(time)
                            )
                        }
                    }

                    //投稿视频
                    8 -> {
                        it.sn("card").run {
                            Video(
                                title = s("title"),
                                description = s("dynamic"),
                                link = s("short_link_v2"),
                                id = id,
                                authorName = authorName,
                                time = DateUtil.date(time)
                            )
                        }
                    }

                    //专栏
                    64 -> {
                        it.sn("card").run {
                            Column(
                                title = s("title"),
                                description = s("summary"),
                                imageLinkList = sn("image_urls").map { url -> url.asText() },
                                id = id,
                                authorName = authorName,
                                time = DateUtil.date(time)
                            )
                        }
                    }

                    else -> {
                        throw SimpleProjectExceptionEntity("undefined api type: $type")
                    }
                }
            }.onFailure { t ->
                logger.error("reslove ${it.toJsonStr()} throw error: ${ExceptionUtil.stacktraceToString(t)}")
                return@onFailure
            }.getOrNull()
        }
    }
}
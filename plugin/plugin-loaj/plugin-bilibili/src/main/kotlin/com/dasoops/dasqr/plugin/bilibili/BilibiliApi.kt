package com.dasoops.dasqr.plugin.bilibili

import cn.hutool.core.date.DateUtil
import cn.hutool.core.util.EscapeUtil
import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.json.core.Json
import com.dasoops.common.json.jackson.parseNode
import com.dasoops.dasqr.core.IBot
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
    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * 获取动态
     * @return [JsonNode]
     */
    suspend fun getDynamic(userId: Long): List<Dynamic> = withContext(Dispatchers.IO) {
        val resultJsonStr = OkHttpClient.NO_PROXY_INSTANCE
            .newCall(Request("https://api.vc.bilibili.com/dynamic_svr/v1/dynamic_svr/space_history?host_uid=$userId".toHttpUrl()))
            .run { async(Dispatchers.IO) { execute() }.await() }.body.string()
        OkHttpClient.NO_PROXY_INSTANCE

        Json.parseNode(resultJsonStr)["data"]["cards"].mapNotNull {
            return@mapNotNull runCatching {
                val desc = it["desc"]
                val authorName = desc["user_profile"]["info"]["uname"].asText()
                val time = desc["timestamp"].asLong() * 1000
                val id = desc["dynamic_id"].asLong()
                when (val type = desc["type"].asInt()) {
                    //转发
                    1 -> {
                        val node = Json.parseNode(Json.parseNode(it["card"].asText())["origin"].asText())
                        if (node.has("item")) {
                            val item = node["item"]
                            return@mapNotNull Share(
                                title = if (item.has("title")) {
                                    item["title"].asText("")
                                } else if (item.has("content")) {
                                    item["content"].asText("")
                                } else {
                                    ""
                                },
                                link = "",
                                imageLink = if (item.has("pictures")) {
                                    item["pictures"].firstOrNull()?.asText("") ?: ""
                                } else if (item.has("pic")) {
                                    item["pic"].asText("")
                                } else {
                                    ""
                                },
                                id = id,
                                authorName = authorName,
                                time = DateUtil.date(time)
                            )
                        }
                        Share(
                            title = node["title"].asText(""),
                            link = node["short_link_v2"].asText(),
                            imageLink = node["first_frame"].asText(""),
                            id = id,
                            authorName = authorName,
                            time = DateUtil.date(time)
                        )
                    }

                    //消息
                    2 -> {
                        val node = Json.parseNode(it["card"].asText())["item"]
                        Message(
                            description = EscapeUtil.unescape(node["description"].asText()),
                            imageLinkList = node["pictures"].map { imgNode -> imgNode["img_src"].asText() },
                            id = id,
                            authorName = authorName,
                            time = DateUtil.date(time)
                        )
                    }

                    //投稿视频
                    4 -> {
                        val node = Json.parseNode(it["card"].asText())["item"]
                        Message(
                            description = EscapeUtil.unescape(node["content"].asText()),
                            imageLinkList = emptyList(),
                            id = id,
                            authorName = authorName,
                            time = DateUtil.date(time)
                        )
                    }

                    //投稿视频
                    8 -> {
                        val node = Json.parseNode(it["card"].asText())
                        Video(
                            title = node["title"].asText(),
                            description = node["dynamic"].asText(),
                            link = node["short_link_v2"].asText(),
                            id = id,
                            authorName = authorName,
                            time = DateUtil.date(time)
                        )
                    }

                    //专栏
                    64 -> {
                        val node = Json.parseNode(it["card"].asText())
                        Column(
                            title = node["title"].asText(),
                            description = node["summary"].asText(),
                            imageLinkList = node["image_urls"].map { url -> url.asText() },
                            id = id,
                            authorName = authorName,
                            time = DateUtil.date(time)
                        )
                    }

                    else -> {
                        throw SimpleProjectExceptionEntity("undefined api type: $type")
                    }
                }
            }.onFailure {
                log.error("", it)
                return@onFailure
            }.getOrNull()
        }
    }
}
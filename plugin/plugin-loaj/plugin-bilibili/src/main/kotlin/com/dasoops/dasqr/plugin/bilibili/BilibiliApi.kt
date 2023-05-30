package com.dasoops.dasqr.plugin.bilibili

import cn.hutool.core.date.DateTime
import cn.hutool.core.date.DateUtil
import cn.hutool.core.util.EscapeUtil
import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.json.Json
import com.dasoops.dasqr.plugin.http.client.NO_PROXY_INSTANCE
import com.fasterxml.jackson.databind.JsonNode
import net.mamoe.mirai.data.UserProfile
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

object BilibiliApi {
    sealed interface Dynamic {
        val authorName: String
        val time: DateTime
    }

    data class Share(
        val title: String,
        val link: String,
        val imageLink: String,
        override val authorName: String,
        override val time: DateTime,
    ) : Dynamic

    data class Message(
        val description: String,
        val imageLinkList: List<String>,
        override val authorName: String,
        override val time: DateTime,
    ) : Dynamic

    data class Video(
        val title: String,
        val description: String,
        val link: String,
        override val authorName: String,
        override val time: DateTime,
    ) : Dynamic

    /**
     * 获取动态
     * @return [JsonNode]
     */
    fun getDynamic(userId: Long): List<Dynamic> {
        val resultJsonStr = OkHttpClient.NO_PROXY_INSTANCE
            .newCall(Request("https://api.vc.bilibili.com/dynamic_svr/v1/dynamic_svr/space_history?host_uid=$userId".toHttpUrl()))
            .execute().body.string()
        return Json.parseNode(resultJsonStr)["data"]["cards"].mapNotNull {
            val desc = it["desc"]
            val authorName = desc["user_profile"]["info"]["uname"].asText()
            val time = desc["timestamp"].asLong() * 1000
            when (val type = desc["type"].asInt()) {
                1 -> {
                    val node = Json.parseNode(Json.parseNode(it["card"].asText())["origin"].asText())
                    Share(
                        title = node["title"].asText(),
                        link = node["short_link_v2"].asText(),
                        imageLink = node["first_frame"].asText(),
                        authorName = authorName,
                        time = DateUtil.date(time)
                    )
                }

                2 -> {
                    val node = Json.parseNode(it["card"].asText())["item"]
                    Message(
                        description = EscapeUtil.unescape(node["description"].asText()),
                        imageLinkList = node["pictures"].map { imgNode -> imgNode["img_src"].asText() },
                        authorName = authorName,
                        time = DateUtil.date(time)
                    )
                }

                8 -> {
                    val node = Json.parseNode(it["card"].asText())
                    Video(
                        title = node["title"].asText(),
                        description = node["dynamic"].asText(),
                        link = node["short_link_v2"].asText(),
                        authorName = authorName,
                        time = DateUtil.date(time)
                    )
                }

                else -> {
                    throw SimpleProjectExceptionEntity("undefined api type: $type")
                }
            }
        }
    }
}
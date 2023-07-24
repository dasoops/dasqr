package com.dasoops.dasqr.plugin.reply

import cn.hutool.core.date.LocalDateTimeUtil
import cn.hutool.core.util.StrUtil
import com.dasoops.common.db.ktorm.KtormGlobal.default
import com.dasoops.common.db.ktorm.baseSave
import com.dasoops.common.json.core.Json
import com.dasoops.common.json.core.parse
import com.dasoops.common.json.jackson.parseNode
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder
import com.dasoops.dasqr.plugin.http.client.NO_PROXY_INSTANCE
import com.qcloud.cos.COSClient
import com.qcloud.cos.ClientConfig
import com.qcloud.cos.auth.BasicCOSCredentials
import com.qcloud.cos.model.ObjectMetadata
import com.qcloud.cos.region.Region
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.Image.Key.queryUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.apache.commons.lang3.StringUtils.endsWith
import org.apache.commons.lang3.StringUtils.startsWith
import org.ktorm.database.Database
import org.ktorm.dsl.batchInsert
import org.ktorm.dsl.eq
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * 存图 listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/11
 * @see [SaveImageListenerHost]
 */
open class SaveImageListenerHost : DslListenerHost() {

    val cosClient = COSClient(
        BasicCOSCredentials(
            "AKIDSjjSu61e05tRiiSv71jAKCn7AwRgeLkt",
            "tVpse9NJ4cttd6IDrFMCl34oHUQ5TZIl"
        ), ClientConfig(Region("ap-nanjing"))
    )

    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        /**
         * 添加reply
         */
        group("save image") {
            startsWith("存图", trim = true) reply {
                val image = message.filterIsInstance<net.mamoe.mirai.message.data.Image>().firstOrNull()
                    ?: return@reply "图呢"

                val fileName = image.imageId.replace("{", "").replace("}", "")

                OkHttpClient.NO_PROXY_INSTANCE.newCall(
                    Request.Builder()
                        .url(image.queryUrl())
                        .build()
                ).execute().body.byteStream().use {
                    cosClient.putObject("dasqr-1312343885", fileName, it, ObjectMetadata())
                }

                ImageDao.add(Image {
                    keyword = it.substringBefore(",").substringAfter(" ")
                    this.fileName = fileName
                })

                "ok"
            }
        }

        group("get image") {
            val onEvent: suspend GroupMessageEvent.(String) -> Unit = tag@{
                val image = ImageDao.findOne { image ->
                    image.keyword eq it
                }
                image ?: run {
                    subject.sendMessage("没有这张图捏")
                    return@tag
                }
                OkHttpClient.NO_PROXY_INSTANCE.newCall(
                    Request.Builder()
                        .url("https://dasqr-1312343885.cos.ap-nanjing.myqcloud.com/${image.fileName}")
                        .build()
                ).execute().body.byteStream().use {
                    subject.sendImage(it)
                }

            }
            startsWith(prefix = "取图", removePrefix = true) {
                onEvent(this@startsWith, it.removePrefix("存图").trim())
            }
            endsWith(suffix = ".jpg", removeSuffix = true) {
                onEvent(this@endsWith, it.removePrefix(".jpg"))
            }
        }
    }
}

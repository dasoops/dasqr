package com.dasoops.dasqr.plugin.image

import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder
import com.dasoops.dasqr.core.util.QuickServiceLoader
import com.dasoops.dasqr.plugin.http.client.request
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.Image.Key.queryUrl
import org.ktorm.dsl.eq
import java.net.URL

/**
 * 存图 listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/11
 * @see [ImageListenerHost]
 */
open class ImageListenerHost : DslListenerHost() {

    val imageApi = QuickServiceLoader.getOne<ImageApi>()

    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        /**
         * 添加reply
         */
        group("存图") {
            startsWith("存图", trim = true) reply {
                val image = message.filterIsInstance<net.mamoe.mirai.message.data.Image>().firstOrNull()
                    ?: return@reply "图呢"

                val fileName = image.imageId.replace("{", "").replace("}", "")

                URL(image.queryUrl()).request().body.byteStream().use {
                    imageApi.save(fileName, it)
                }

                ImageDao.add(Image {
                    keyword = it.substringBefore(",").substringAfter(" ")
                    this.fileName = fileName
                })

                "ok"
            }
        }

        group("取图") {
            val onEvent: suspend GroupMessageEvent.(String) -> Unit = tag@{
                val image = ImageDao.findOne { image ->
                    Images.keyword eq it
                }
                image ?: run {
                    subject.sendMessage("没有这张图捏")
                    return@tag
                }
                imageApi.get(image.fileName).use {
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

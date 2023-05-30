package com.dasoops.dasqr.plugin.bilibili

import cn.hutool.core.date.DateField
import cn.hutool.core.date.DateUtil
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder
import com.dasoops.dasqr.core.runner.Runner
import com.dasoops.dasqr.plugin.http.client.NO_PROXY_INSTANCE
import com.dasoops.dasqr.plugin.schedule.ScheduleDao
import com.dasoops.dasqr.plugin.schedule.ScheduleDo
import com.dasoops.dasqr.plugin.schedule.ScheduleRunner
import com.dasoops.dasqr.plugin.schedule.ScheduleTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.Message
import net.mamoe.mirai.message.data.toMessageChain
import net.mamoe.mirai.message.data.toPlainText
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.ktorm.dsl.eq
import org.slf4j.LoggerFactory

/**
 * bilibili订阅listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/30
 * @see [BilibiliListenerHost]
 */
open class BilibiliListenerHost : DslListenerHost(), Runner, ScheduleTask {
    private val log = LoggerFactory.getLogger(javaClass)
    override val level = Runner.Level.LAST

    override suspend fun run(paramJson: String?) = withContext(Dispatchers.IO) {
        val now = DateUtil.date()
        val begin = now.offsetNew(DateField.MINUTE, -10)
        val messageChain = BilibiliApi.getDynamic(31485472).filter {
            it.time.isIn(begin, now)
        }.ifEmpty { return@withContext }.map {
            async {
                buildMessage(it, IBot.getFriend(776465218)!!).apply {
                    add("\n".toPlainText())
                    add("\n".toPlainText())
                }
            }
        }.awaitAll().flatten().toMessageChain()
        IBot.getFriend(776465218)!!.sendMessage(messageChain)
        IBot.getFriend(943952775)!!.sendMessage(messageChain)
    }

    override suspend fun init() {
        val isInit = ScheduleDao.anyMatched {
            it.`class` eq BilibiliListenerHost::class.java.name
        }
        if (isInit) {
            return
        }

        ScheduleDao.add(ScheduleDo {
            //10分钟一次
            this.cron = "0 0/10 * * * ?"
            this.`class` = BilibiliListenerHost::class.java.name
            this.description = "请求bilibili数据"
            this.enable = true
        })
        ScheduleRunner.INSTANCE.init()
    }

    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        group("动态") {
            case("动态测试") quoteReply {
                intercept()
                withContext(Dispatchers.IO) {
                    val messageChain = BilibiliApi.getDynamic(31485472).map {
                        async {
                            buildMessage(it, group).apply {
                                add("\n".toPlainText())
                                add("\n".toPlainText())
                            }
                        }
                    }.awaitAll().flatten().toMessageChain()
                    IBot.getFriend(776465218)!!.sendMessage(messageChain)
                    messageChain
                }
            }
        }
    }

    private suspend fun uploadAndGetImage(url: String, contact: Contact): Image {
        val byteStream = OkHttpClient.NO_PROXY_INSTANCE.newCall(Request(url.toHttpUrl())).execute().body.byteStream()
        return byteStream.toExternalResource().uploadAsImage(contact)
    }

    private suspend fun buildMessage(
        it: Dynamic,
        contact: Contact,
    ): ArrayList<Message> {
        val messageList = arrayListOf<Message>()
        when (it) {
            is com.dasoops.dasqr.plugin.bilibili.Message -> {
                messageList.add(
                    "${it.authorName}发布了动态\n${it.time.toString("yyyy-MM-dd HH:mm:ss")}\n${it.description}".toPlainText()
                )
                messageList.addAll(it.imageLinkList.map { url ->
                    uploadAndGetImage(url, contact)
                })
            }

            is Share -> {
                messageList.add(
                    "${it.authorName}转发了动态\n${it.time.toString("yyyy-MM-dd HH:mm:ss")}\n${it.title}${it.link}".toPlainText()
                )
                messageList.add(uploadAndGetImage(it.imageLink, contact))
            }

            is Video -> {
                messageList.add(
                    "${it.authorName}发布了视频\n${it.time.toString("yyyy-MM-dd HH:mm:ss")}\n${it.title}${"\n"}${it.description}\n${it.link}".toPlainText()
                )
            }
        }
        return messageList
    }
}
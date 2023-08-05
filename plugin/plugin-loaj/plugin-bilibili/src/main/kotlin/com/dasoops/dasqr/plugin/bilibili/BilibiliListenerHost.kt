package com.dasoops.dasqr.plugin.bilibili

import cn.hutool.core.date.DateField
import cn.hutool.core.date.DateTime
import cn.hutool.core.date.DateUtil
import com.dasoops.common.core.exception.UnExpectedException
import com.dasoops.common.core.util.debug
import com.dasoops.common.core.util.getOrNullAndSet
import com.dasoops.common.core.util.info
import com.dasoops.common.core.util.trace
import com.dasoops.common.json.core.toJsonStr
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder
import com.dasoops.dasqr.core.runner.Runner
import com.dasoops.dasqr.plugin.bilibili.Subscribes.registerId
import com.dasoops.dasqr.plugin.bilibili.Subscribes.registerType
import com.dasoops.dasqr.plugin.config.Cache
import com.dasoops.dasqr.plugin.http.client.NO_PROXY_INSTANCE
import com.dasoops.dasqr.plugin.schedule.ScheduleDao
import com.dasoops.dasqr.plugin.schedule.ScheduleDo
import com.dasoops.dasqr.plugin.schedule.ScheduleRunner
import com.dasoops.dasqr.plugin.schedule.ScheduleTask
import kotlinx.coroutines.*
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.event.Listener
import net.mamoe.mirai.event.MessageSubscribersBuilder
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MessageEvent
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.message.data.Message
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.annotations.Contract
import org.ktorm.dsl.eq
import org.slf4j.LoggerFactory

/**
 * bilibili订阅listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/30
 * @see [BilibiliListenerHost]
 */
open class BilibiliListenerHost : DslListenerHost(), Runner, ScheduleTask {
    private val logger = LoggerFactory.getLogger(javaClass)
    override val level = Runner.Level.LAST
    val cache = Cache.newTimedCache<Unit, Collection<Subscribe>>(BilibiliListenerHost::class, 1000 * 60 * 60 * 12)

    override suspend fun run(paramJson: String?) = withContext(Dispatchers.IO) {
        cache.getOrNullAndSet(Unit) {
            SubscribeDao.findAll().apply {
                logger.debug { "load bilibili subscribe: ${this.toJsonStr()}" }
            }
        }.forEach { subscribe ->
            logger.trace { "handle subscribe: ${subscribe.toJsonStr()}" }
            val now = DateUtil.date()
            val begin = now.offsetNew(DateField.MINUTE, -1)
            val contact: Contact = when (subscribe.registerType) {
                RegisterType.GROUP -> IBot.getGroup(subscribe.registerId)
                RegisterType.USER -> IBot.getFriend(subscribe.registerId)
            } ?: return@forEach

            BilibiliApi.getDynamic(subscribe.subscribeId).filter {
                it.time.isIn(begin, now)
            }.ifEmpty { return@forEach }.map {
                buildMessage(it, contact).apply { add("\n------\n".toPlainText()) }
            }.flatten().dropLast(1).toMessageChain().apply {
                logger.info { "send subscribe dynamic: \n${contentToString()}" }
            }.sendTo(contact)
        }
    }

    override suspend fun init() {
        val isInit = ScheduleDao.anyMatched {
            it.`class` eq BilibiliListenerHost::class.java.name
        }
        if (isInit) {
            return
        }

        ScheduleDao.add(ScheduleDo {
            //默认1min
            this.cron = "0 0/1 * * * ?"
            this.`class` = BilibiliListenerHost::class.java.name
            this.description = "请求bilibili数据"
            this.enable = true
        })
    }

    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        val builder: MessageSubscribersBuilder<MessageEvent, Listener<MessageEvent>, Unit, Unit>.() -> Unit =
            {
                startsWith("添加订阅") quoteReply {
                    intercept()
                    val subscribeId = it.removePrefix("添加订阅").trim()
                        .toLongOrNull() ?: return@quoteReply "订阅id错误"
                    val event = this
                    val (registerType, registerId) = when (event) {
                        is GroupMessageEvent -> RegisterType.GROUP to event.sender.group.id
                        is FriendMessageEvent -> RegisterType.USER to event.sender.id
                        else -> throw UnExpectedException
                    }
                    SubscribeDao.add(Subscribe {
                        this.subscribeId = subscribeId
                        this.registerType = registerType
                        this.registerId = registerId
                        this.messageType = MessageType.ALL
                    })
                    cache.clear()
                    "ok"
                }
            }
        group("添加群订阅") {
            @Suppress("UNCHECKED_CAST")
            builder.invoke(this as MessageSubscribersBuilder<MessageEvent, Listener<MessageEvent>, Unit, Unit>)
        }
        friend("添加好友订阅") {
            @Suppress("UNCHECKED_CAST")
            builder.invoke(this as MessageSubscribersBuilder<MessageEvent, Listener<MessageEvent>, Unit, Unit>)
        }
        friend("订阅测试") {
            case("订阅测试") {
                SubscribeDao.findList {
                    it.registerId eq sender.id
                }.forEach { subscribe ->
                    BilibiliApi.getDynamic(subscribe.subscribeId).ifEmpty { return@forEach }.map {
                        buildMessage(it, sender).apply { add("\n------\n".toPlainText()) }
                    }.flatten().dropLast(1).toMessageChain().apply {
                        logger.info { "[test] send subscribe dynamic: ${contentToString()}" }
                    }.sendTo(sender)
                }
            }
        }
    }

    private suspend fun uploadAndGetImage(url: String, contact: Contact): Image {
        val byteStream = OkHttpClient.NO_PROXY_INSTANCE.newCall(Request(url.toHttpUrl())).execute().body.byteStream()
        return byteStream.toExternalResource().use {
            it.uploadAsImage(contact)
        }
    }

    private fun DateTime.groupTimeString() = toString("yyyy-MM-dd HH:mm:ss")

    private suspend fun buildMessage(
        it: Dynamic,
        contact: Contact,
    ): ArrayList<Message> = withContext(Dispatchers.IO) {
        val messageList = arrayListOf<Message>()
        messageList.add("https://t.bilibili.com/${it.id}\n".toPlainText())
        when (it) {
            is com.dasoops.dasqr.plugin.bilibili.Message -> {
                messageList.add(
                    "${it.authorName}发布了动态\n${it.time.groupTimeString()}\n${it.description}".toPlainText()
                )
                messageList.addAll(it.imageLinkList.map { url ->
                    async { uploadAndGetImage(url, contact) }
                }.awaitAll())
            }

            is Share -> {
                messageList.add(
                    "${it.authorName}转发了动态\n${it.time.groupTimeString()}\n${it.title}${it.link}".toPlainText()
                )
                if (it.imageLink.isNotEmpty()) messageList.add(uploadAndGetImage(it.imageLink, contact))
            }

            is Video -> {
                messageList.add(
                    "${it.authorName}发布了视频\n${it.time.groupTimeString()}\n${it.title}${"\n"}${it.description}\n${it.link}".toPlainText()
                )
            }

            is Column -> {
                messageList.add(
                    "${it.authorName}发布了专栏\n${it.time.groupTimeString()}\n${it.title}${"\n"}${it.description}".toPlainText()
                )
                messageList.addAll(
                    it.imageLinkList.map { url ->
                        async { uploadAndGetImage(url, contact) }
                    }.awaitAll()
                )
            }
        }
        messageList
    }
}
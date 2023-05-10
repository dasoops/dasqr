package com.dasoops.dasqr.plugin.reply

import cn.hutool.cache.CacheUtil
import cn.hutool.cache.impl.TimedCache
import com.dasoops.dasqr.core.DasqrListenerHost
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.IBot.bot
import net.mamoe.mirai.event.*
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.at
import net.mamoe.mirai.message.data.firstIsInstanceOrNull
import net.mamoe.mirai.message.nextMessage
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

/**
 * 消息回复listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/10
 * @see [ReplyListenerHost]
 */
open class ReplyListenerHost : DasqrListenerHost() {
    private val log = LoggerFactory.getLogger(javaClass)
    private val replyDao = ReplyDao.INSTANCE
    val replyCache: TimedCache<KClass<out ReplyListenerHost>, Collection<Reply>> =
        CacheUtil.newTimedCache(1000 * 60 * 10)

    @EventHandler
    open suspend fun handle(event: GroupMessageEvent) {
        if ((event.message.firstIsInstanceOrNull<At>()?.target == bot.id)) {
            event.subject.sendMessage("at我干啥子嘞")
            event.intercept()
        }
    }

    fun getData(): Collection<Reply> {
        return replyCache.get(this::class)
    }

    fun isMatch() {

    }
}
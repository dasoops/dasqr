package com.dasoops.dasqr.plugin.reply

import cn.hutool.cache.CacheUtil
import cn.hutool.cache.impl.TimedCache
import com.dasoops.dasqr.core.DasqrListenerHost
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.events.GroupMessageEvent
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
        event.intercept()
    }

    fun getData(): Collection<Reply> {
        return replyCache.get(this::class)
    }

    fun isMatch() {

    }
}
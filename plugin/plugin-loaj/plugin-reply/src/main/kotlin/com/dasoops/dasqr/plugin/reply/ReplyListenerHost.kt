package com.dasoops.dasqr.plugin.reply

import cn.hutool.cache.CacheUtil
import cn.hutool.cache.impl.TimedCache
import com.dasoops.common.core.util.getOrNullAndSet
import com.dasoops.dasqr.core.listener.DasqrSimpleListenerHost
import com.dasoops.dasqr.core.listener.DslListenerHost
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.events.GroupMessageEvent
import java.lang.Compiler.command
import kotlin.reflect.KClass

object ReplyPublic {
    //10分钟过期
    val replyCache: TimedCache<KClass<out ReplyPublic>, Collection<Reply>> =
        CacheUtil.newTimedCache(1000 * 60 * 10)

    private val replyDao = ReplyDao.INSTANCE

    fun getReply() =
        replyCache.getOrNullAndSet(this::class) {
            replyDao.findAll().sortedBy { it.order }
        }!!
}


/**
 * 消息回复listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/10
 * @see [ReplyListenerHost]
 */
open class ReplyListenerHost : DasqrSimpleListenerHost() {

    /**
     * 消息处理核心程序
     */
    @EventHandler
    open suspend fun reply(event: GroupMessageEvent) {
        ReplyPublic.getReply().firstOrNull {
            it.matchType.match(it.keyword, event.message)
        }?.also {
            event.subject.sendMessage(it.replyMessage)
            event.intercept()
        }
    }
}

/**
 * 添加回复listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/11
 * @see [DslReplyListenerHost]
 */
open class DslReplyListenerHost : DslListenerHost({
    /**
     * 添加reply
     */
    group("addReply") {
        startsWith("addReply") quoteReply {
            println(it)


            "ok"
        }
    }
})
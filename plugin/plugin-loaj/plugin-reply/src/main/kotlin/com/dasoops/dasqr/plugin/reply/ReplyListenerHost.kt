package com.dasoops.dasqr.plugin.reply

import cn.hutool.cache.CacheUtil
import cn.hutool.cache.impl.TimedCache
import com.dasoops.common.core.util.getOrNullAndSet
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.listener.DasqrSimpleListenerHost
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.group
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.toMessageChain
import kotlin.reflect.KClass

object ReplyPublic {
    //10分钟过期
    val replyCache: TimedCache<KClass<out ReplyPublic>, Collection<Reply>> =
        CacheUtil.newTimedCache(1000 * 60 * 10)

    private val replyDao = ReplyDao.INSTANCE

    fun getReply() =
        replyCache.getOrNullAndSet(this::class) {
            replyDao.findAll().filter { it.enable }.sortedBy { it.order }
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
        var removeAtMessage: MessageChain? = null
        val at = event.message.filterIsInstance<At>().firstOrNull { it.target == IBot.id }
        if (at != null) {
            //排除掉atBot的信息
            removeAtMessage = event.message.filter { it != at }.toMessageChain()
        }

        ReplyPublic.getReply().firstOrNull {
            if (it.mustAt && at != null) {
                it.matchType.match(it.keyword, removeAtMessage!!)
            } else {
                it.matchType.match(it.keyword, event.message)
            }
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
    group("addReply", {
        "keyword" {
            order = 1
            desc = "关键词"
        }
        "reply" {
            order = 2
            desc = "回复内容"
        }
        "type" {
            order = 3
            desc = "匹配类型"
        }
        "mustAt" {
            order = 4
            desc = "是否必须at"
        }
    }) tag@{
        val matchTypeStr = MatchType.getOrNull(stringOrNull("matchType")!!)
            ?: return@tag "matchType无法识别,可选值:[equals,contain,prefix,suffix]"
        ReplyDao.INSTANCE.add(Reply {
            keyword = string("keyword")
            replyMessage = string("reply")
            matchType = matchTypeStr
            enable = true
            mustAt = booleanOrDefault("mustAt", true)
            order = Int.MAX_VALUE
        })
        return@tag "ok"
    }
})
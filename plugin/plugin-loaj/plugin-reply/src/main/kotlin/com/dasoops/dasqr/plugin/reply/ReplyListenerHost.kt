package com.dasoops.dasqr.plugin.reply

import cn.hutool.cache.impl.TimedCache
import com.dasoops.common.core.util.getOrNullAndSet
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.listener.CommandResult
import com.dasoops.dasqr.core.listener.DasqrSimpleListenerHost
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.group
import com.dasoops.dasqr.plugin.config.Cache
import com.dasoops.dasqr.plugin.reply.Replys.keyword
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.EventPriority
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.toMessageChain
import org.apache.commons.lang3.StringUtils.startsWith
import org.ktorm.dsl.eq
import kotlin.reflect.KClass

object ReplyPublic {
    //10分钟过期
    val replyCache: TimedCache<KClass<out ReplyPublic>, Collection<Reply>> =
        Cache.newTimedCache(this::class, 1000 * 60 * 10)

    fun getReply() =
        replyCache.getOrNullAndSet(this::class) {
            ReplyDao.findAll().filter { it.enable }.sortedBy { it.order }
        }!!

    fun clear() = replyCache.clear()
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
            if (it.mustAt) {
                if (at == null) return@firstOrNull false
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
    group("addReply",
        keywordList = arrayListOf("addReply"),
        option = {
            "keyword" {
                order = 0
                desc = "关键词"
                require = true
            }
            "reply" {
                order = 1
                desc = "回复内容"
            }
            "type" {
                order = 2
                desc = "匹配类型"
            }
            "mustAt" {
                order = 3
                desc = "是否必须at"
            }
        }) tag@{
        val matchType = MatchType.getOrNull(stringOrDefault("matchType", "equals"))
            ?: return@tag "matchType无法识别,可选值:[equals,contain,prefix,suffix]"

        if (ReplyDao.anyMatched { reply ->
                reply.keyword eq string("keyword")
                reply.matchType eq matchType
            }) {
            return@tag it.message.quote() + "已经有这个回复了呢"
        }

        ReplyDao.add(Reply {
            keyword = string("keyword")
            replyMessage = string("reply")
            this.matchType = matchType
            enable = true
            mustAt = booleanOrDefault("mustAt", false)
            order = Int.MAX_VALUE
        })

        return@tag it.message.quote() + "ok"
    }

    group("enable reply", keywordList = listOf("enable reply", "disable reply"), option = {
        "keyword" {
            desc = "关键词"
            require = true
        }
        "matchType" {
            desc = "匹配条件"
        }
    }) tag@{
        val matchType = MatchType.getOrNull(stringOrDefault("matchType", "equals"))
            ?: return@tag "matchType无法识别,可选值:[equals,contain,prefix,suffix]"
        val reply = ReplyDao.findOne {
            it.keyword eq string("keyword")
            it.matchType eq matchType
        } ?: return@tag "没有这个回复捏"

        val isEnable = this.command.keyword == "enable reply"
        if (isEnable) {
            if (reply.enable) return@tag "这不本来就开的嘛"
        } else {
            if (!reply.enable) return@tag "这不本来就关的嘛"
        }

        ReplyDao.update(Reply {
            rowId = reply.rowId
            enable = isEnable
        })
        ReplyPublic.clear()

        "ok"
    }
})

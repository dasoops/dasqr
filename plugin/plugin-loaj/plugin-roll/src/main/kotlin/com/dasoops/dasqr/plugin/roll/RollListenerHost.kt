package com.dasoops.dasqr.plugin.roll

import cn.hutool.core.util.RandomUtil
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.plugin.config.Cache
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.at

object RollPublic {
    //第一次使用5分钟后清除
    val cache =
        Cache.newTimedCache<Group, MutableMap<Member, Int>>(this::class to "roll", 1000 * 60 * 5)

    //历史记录保存60分钟
    val historyCache =
        Cache.newTimedCache<Group, List<MutableMap.MutableEntry<Member, Int>>>(
            this::class to "rollHistory",
            1000 * 60 * 60
        )
}

/**
 * 消息回复listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/10
 * @see [RollListenerHost]
 */
open class RollListenerHost : DslListenerHost({
    group("roll点") {
        case("roll") quoteReply {
            intercept()
            val cache = RollPublic.cache[group] ?: run {
                subject.sendMessage("开启了新的一轮roll点")
                val cacheMap = mutableMapOf<Member, Int>()
                RollPublic.cache.put(group, cacheMap)
                cacheMap
            }
            val senderPoint = RandomUtil.randomInt(100)
            cache[sender] = senderPoint
            "你roll到了$senderPoint"
        }
        case("endRoll") tag@{
            intercept()
            val cache: MutableMap<Member, Int> = RollPublic.cache[group] ?: run {
                subject.sendMessage("还没有人roll点哦")
                return@tag
            }
            val sortedList = cache.entries.sortedBy { it.value }
            val maxUserEntry = sortedList.first()
            subject.sendMessage(maxUserEntry.key.at() + "恭喜这个B摇到了最高点数: ${maxUserEntry.value}")
            if (cache.size == 1) {
                subject.sendMessage("一个人玩roll点,乐")
            }
            RollPublic.cache.remove(group)
            RollPublic.historyCache.put(group, sortedList)
        }
        case("rollHistory") or case("historyRoll") quoteReply {
            intercept()
            RollPublic.historyCache[group]?.joinToString(separator = System.lineSeparator()) {
                """
                    ${it.key.nick}: ${it.value}
                """.trimIndent()
            } ?: "没有查到历史roll点记录捏"
        }
    }
})
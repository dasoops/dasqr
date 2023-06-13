package com.dasoops.dasqr.plugin.roll

import cn.hutool.core.util.RandomUtil
import com.dasoops.dasqr.core.IBot
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder
import com.dasoops.dasqr.plugin.config.Cache
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.MessageChainBuilder
import net.mamoe.mirai.message.data.at
import net.mamoe.mirai.message.data.buildMessageChain
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * 消息回复listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/10
 * @see [RollListenerHost]
 */
open class RollListenerHost : DslListenerHost() {

    //第一次使用5分钟后清除
    val cache =
        Cache.newTimedCache<Group, RollInfo>(this::class to "roll", 1000 * 60 * 5).apply {
            setListener { group, cachedObject ->
                if (cachedObject.expire){
                    IBot.launch {
                        group.sendMessage("5分钟了,roll点结束了捏")
                        endRoll(group, cachedObject)
                    }
                }
            }
        }

    //历史记录保存60分钟
    val historyCache =
        Cache.newTimedCache<Group, List<MutableMap.MutableEntry<Member, Int>>>(
            this::class to "rollHistory",
            1000 * 60 * 60
        )

    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        group("roll") {
            //roll
            case("roll") quoteReply {
                intercept()
                val rollInfo = cache[group] ?: run {
                    subject.sendMessage("开启了新的一轮roll点")
                    RollInfo().apply {
                        cache.put(group, this)
                    }
                }
                if (rollInfo[sender] != null) {
                    return@quoteReply "你已经roll过了呢,重复roll对别人可不公平"
                }
                val senderPoint = RandomUtil.randomInt(100)
                rollInfo[sender] = senderPoint
                "你roll到了$senderPoint"
            }
            //end roll
            (case("end roll", ignoreCase = true) or case("endRoll", ignoreCase = true)) tag@{
                intercept()
                val senderCache = cache[group] ?: run {
                    subject.sendMessage("还没有人roll点哦")
                    return@tag
                }
                cache.remove(group)
                senderCache.expire = false
                endRoll(group, senderCache)
            }
            //roll history
            case("roll history") or case("historyRoll") quoteReply {
                intercept()
                historyCache[group]?.joinToString(separator = System.lineSeparator()) {
                    """
                    ${it.key.nick}: ${it.value}
                """.trimIndent()
                } ?: "没有查到历史roll点记录捏"
            }

            case("加注") {
                intercept()
                if (cache[group] == null) {
                    subject.sendMessage("还没有进行中的roll点哦")
                    return@case
                }
                subject.sendMessage("现在场上有${++cache[group].weight}块砝码")
            }
        }
    }

    private suspend fun endRoll(group: Group, rollInfo: RollInfo) {
        val sortByPointList = rollInfo.entries.sortedByDescending { it.value }
        historyCache.put(group, sortByPointList)
        val winUserEntry = sortByPointList.first()
        group.sendMessage(winUserEntry.key.at() + "恭喜这个B摇到了最高点数: ${winUserEntry.value}")
        if (rollInfo.size == 1) {
            if (rollInfo.weight != 0) {
                group.sendMessage("单人加注无效哦,找个人来一起吧")
                return
            }
            group.sendMessage("一个人玩roll点,乐")
            return
        }
        if (rollInfo.weight == 0) return
        //确定系数(砝码*每块砝码对应40-60秒)
        val coefficient = Random.nextInt(40 * rollInfo.weight..40 * rollInfo.weight + 20)
        //规则
        val rule = WeightRule.byCoefficient(coefficient)
        //排名信息
        val ruleResult = rule.getResult(coefficient, sortByPointList)
        group.sendMessage(buildMessageChain {
            add(
                """
                |开始加注结算
                |参与人数: ${rollInfo.size}
                |砝码: ${rollInfo.weight}
                |系数: $coefficient
                |本局规则: ${rule.chinese}
                |win: 
                """.trimMargin()
            )
            add(winUserEntry.key.at())
            add("- ${winUserEntry.value}")
            addAll(ruleResult.info)
        })
        delay(2000)
        group.sendMessage("开始审判吧!")
        delay(1000)
        ruleResult.mute()
    }
}
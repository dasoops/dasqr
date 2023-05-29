package com.dasoops.dasqr.plugin.roll

import com.dasoops.dasqr.core.listener.DslListenerHost
import kotlinx.coroutines.delay
import net.mamoe.mirai.contact.isOperator
import org.slf4j.LoggerFactory
import kotlin.random.Random
import kotlin.random.nextInt

object MuteRollPublic {
    private val log = LoggerFactory.getLogger(javaClass)
}

/**
 * 消息回复listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/10
 * @see [RollListenerHost]
 */
open class MuteRollListenerHost : DslListenerHost({
    group("mute roll") {
        case("mute roll") {
            subject.sendMessage("一位勇士开启了一场血腥无比的.....Roll点!")
            delay(1000)
            subject.sendMessage("来吧,让我们抽取3位幸运儿")
            delay(1000)
            subject.sendMessage("第一位!")
            delay(2000)
            subject.sendMessage("砰")
            delay(1000)
            val mutableMemberList = group.members.filter { !it.isOperator() }.toMutableList()
            mutableMemberList.random().apply {
                mutableMemberList.remove(this)
                mute(Random.nextInt(10..200))
            }

            delay(2000)
            subject.sendMessage("第二位 和 第三位!")
            delay(3000)
            subject.sendMessage("砰,砰")
            mutableMemberList.random().apply {
                mutableMemberList.remove(this)
                mute(Random.nextInt(10..200))
            }
            mutableMemberList.random().apply {
                mutableMemberList.remove(this)
                mute(Random.nextInt(10..200))
            }

            delay(3000)
            subject.sendMessage("真是精彩")
        }
    }
})
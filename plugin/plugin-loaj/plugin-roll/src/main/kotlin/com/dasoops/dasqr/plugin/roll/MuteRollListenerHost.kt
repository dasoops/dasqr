package com.dasoops.dasqr.plugin.roll

import com.dasoops.dasqr.core.listener.DslListenerHost
import kotlinx.coroutines.delay
import net.mamoe.mirai.contact.isOperator
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.at
import net.mamoe.mirai.message.data.firstIsInstance
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
    group("solo") {
        startsWith("solo") {
            //子弹数
            val num = (0..8).random()
            //被决斗的人
            val beSoloed = message.firstIsInstance<At>()
            //决斗发起人
            val soloer = sender.at()
            val firstIsInstance = message.firstIsInstance<At>()
            //判断是不是要自己决斗自己
            if (firstIsInstance.target.equals(this.sender.id)) {
                subject.sendMessage(message.quote() + soloer + "开启了决斗,Ta决斗的目标竟然是他自己！")
                if (num == 0) {
                    subject.sendMessage("只见他拿起一把枪,枪里却没有子弹,于是他吞枪自尽了,他可真是个傻狗")
                } else {
                    subject.sendMessage("于是他自杀了,他可真是个傻狗")
                }
                sender.mute(Random.nextInt(10..200))
            }
            //不是决斗自己
            else {
                if (num == 0) {
                    subject.sendMessage(soloer + "要和" + beSoloed + "决斗")
                    delay(300)
                    subject.sendMessage(beSoloed + "不和" + soloer + "决斗,于是" + soloer + "上一边哭去了")
                    sender.mute(Random.nextInt(10..200))
                } else {
                    subject.sendMessage(soloer + "要和" + beSoloed + "决斗")
                    val senderRoll = Random.nextInt(-100..200)
                    delay(300)
                    subject.sendMessage("他们开始roll点,发起者先来,他roll了: " + senderRoll)
                    val seconderRoll = Random.nextInt(-100..200)
                    delay(300)
                    subject.sendMessage("对方roll了: " + seconderRoll)
                    if (senderRoll < seconderRoll) {
                        delay(300)
                        subject.sendMessage(soloer + "噶了")
//                        sender.mute(Random.nextInt(10..200))
                    } else {
                        delay(300)
                        subject.sendMessage(beSoloed + "噶了")
                        group.get(firstIsInstance.target)?.mute(Random.nextInt(10..200))
                    }
                }
            }
        }
    }

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

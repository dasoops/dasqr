package com.dasoops.dasqr.plugin.roll

import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.message.data.Message
import net.mamoe.mirai.message.data.at
import net.mamoe.mirai.message.data.toPlainText

/**
 * roll点加注规则
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/29
 * @see [WeightRule]
 */
enum class WeightRule(
    val chinese: String,
    val hints: IntRange,
) {
    WIN_ALL("赢者通吃(系数 * 参与人数)", 1..5) {
        override suspend fun getResult(
            coefficient: Int,
            sortByPointList: List<MutableMap.MutableEntry<Member, Int>>,
        ): Result {
            val size = sortByPointList.size
            val loseList = sortByPointList.toMutableList().apply {
                removeAt(0)
            }
            //member,point,muteSeconds
            val muteList = loseList.map {
                Triple(it.key, it.value, coefficient * size)
            }

            val info = muteList.flatMap {
                listOf(
                    it.first.at(),
                    """ : $coefficient * $size = ${it.third}s""".toPlainText(),
                )
            }

            return Result(info) {
                muteList.forEach {
                    it.first.mute(it.third)
                }
            }
        }
    },
    RANK("排名(系数 * 排名)", 2..9) {
        override suspend fun getResult(
            coefficient: Int,
            sortByPointList: List<MutableMap.MutableEntry<Member, Int>>,
        ): Result {
            val loseList = sortByPointList.toMutableList().apply {
                removeAt(0)
            }

            //member,point,muteSeconds
            val muteList = loseList.mapIndexed { index, it ->
                Triple(it.key, it.value, coefficient * (index + 1))
            }

            val info = muteList.flatMapIndexed { index, it ->
                listOf(
                    it.first.at(),
                    """ : $coefficient * ${index + 1} = ${it.third}s""".toPlainText()
                )
            }

            return Result(info) {
                muteList.forEach {
                    it.first.mute(it.third)
                }
            }
        }
    },
    PERVERSION("你赢赢赢最后是输输输(系数*参与人数,但是...)", 0..0) {
        override suspend fun getResult(
            coefficient: Int,
            sortByPointList: List<MutableMap.MutableEntry<Member, Int>>,
        ): Result {
            val first = sortByPointList.first()
            val second = first.value * sortByPointList.size
            val info =
                listOf("""${first.key.nick} : ${first.value} * ${sortByPointList.size} = $second""".toPlainText())

            return Result(info) {
                first.key.mute(second)
            }
        }
    },
    ;

    data class Result(val info: List<Message>, val mute: suspend () -> Unit)

    abstract suspend fun getResult(
        coefficient: Int,
        sortByPointList: List<MutableMap.MutableEntry<Member, Int>>,
    ): Result

    companion object {
        fun byCoefficient(coefficient: Int): WeightRule {
            val int = coefficient % 10
            return values().first {
                it.hints.contains(int)
            }
        }
    }
}
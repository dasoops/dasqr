package com.dasoops.dasqr.core.listener

import com.dasoops.common.core.entity.dataenum.DataEnum
import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.core.util.DataEnumUtil
import net.mamoe.mirai.event.ConcurrencyKind
import net.mamoe.mirai.event.EventPriority
import net.mamoe.mirai.event.Listener
import net.mamoe.mirai.event.MessageSubscribersBuilder
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MessageEvent
import net.mamoe.mirai.event.events.UserMessageEvent
import kotlin.jvm.Throws

/**
 * 关键词
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [Keyword]
 */
class Keyword(
    keyword: String,
    simple: Char?,
    order: Int?,
    desc: String?,
    require: Boolean?,
) {
    val keyword: String
    val simple: Char
    val order: Int
    val desc: String?
    val require: Boolean

    init {
        this.keyword = keyword
        this.simple = simple ?: keyword.elementAt(0)
        this.order = order ?: Int.MAX_VALUE
        this.desc = desc
        this.require = true
    }
}

class CommandResloveException(message: String) : SimpleProjectExceptionEntity(message)

/**
 * 指令
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [Command]
 */
class Command(
    val keyword: String,
    optionFunc: CommandKeywordBuilder.() -> Unit
) {
    val keywordList = CommandKeywordBuilder().apply(optionFunc).keywordList

    @Throws(CommandResloveException::class)
    fun handle(command: String): CommandResult {
        return CommandResult(this).apply {
            //addReply --keyword "help" --reply "help个屁,妹写" --metch "prefix"
            //addReply -k "help" -r "help个屁,妹写" -m "prefix"
            //addReply "help" "help个屁,妹写" "prefix"

            var i = 0
            val length = command.length

            fun end(): Boolean {
                return i == length
            }

            fun string(end: Char): String {
                var value = ""
                while (true) {
                    if (end()) return value
                    when (val it = command[i++]) {
                        end -> return value
                        else -> value += it
                    }
                }
            }

            fun char(): Char {
                return command[i++]
            }

            fun `throw`(message: String) {
                throw CommandResloveException(message)
            }

            fun skip(string: String) {
                string.forEach {
                    val c = command[i++]
                    if (c != it) `throw`("[${--i}]期待一个'$it',实际一个'${command[i]}'")
                }
            }

            fun skip(char: Char) {
                if (end()) `throw`("[${--i}]期待一个'$char',实际结束")
                if (command[i++] != char) `throw`("[${--i}]期待一个'$char',实际一个'${command[i]}'")
            }

            fun space(): Boolean {
                if (end()) return true
                if (command[i] != ' ') return false
                while (
                    run {
                        if (end()) return true
                        command[i++] == ' '
                    }) {
                    //
                }
                i--
                return false
            }

            when (command[i]) {
                '-' -> {
                    when (command[++i]) {
                        '-' -> {
                            i++
                            while (!space()) {
                                if (i != 2) skip("--")
                                val key = string(' ')
                                space()
                                skip('"')
                                val value = string('"')
                                put(key, value)
                            }
                        }

                        else -> {
                            val keywordMap = keywordList.associateBy { it.simple }
                            while (!space()) {
                                if (i != 1) skip('-')
                                val key = char()
                                space()
                                skip('"')
                                val value = string('"')
                                put(
                                    keywordMap[key]?.keyword ?: throw CommandResloveException("未定义的参数名 $key"),
                                    value
                                )
                            }
                        }
                    }
                }

                '"' -> {
                    val keywordMap = keywordList.associateBy { it.order }
                    var order = 0
                    while (!space()) {
                        skip('"')
                        val value = string('"')
                        put(
                            keywordMap[order++]?.keyword ?: throw CommandResloveException("参数数量超出限制"),
                            value
                        )
                    }
                }

                else -> {
                    val keywordMap = keywordList.associateBy { it.order }
                    var order = 0
                    while (!space()) {
                        val value = string(' ')
                        put(
                            keywordMap[order++]?.keyword ?: throw CommandResloveException("参数数量超出限制"),
                            value
                        )
                    }
                }
            }
        }
    }
}

/**
 * 指令处理结果
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [CommandResult]
 */
class CommandResult(
    val command: Command
) : MutableMap<String, Any?> by mutableMapOf() {
    fun string(key: String): String {
        return stringOrNull(key)!!
    }

    fun stringOrNull(key: String): String? {
        return this[key]?.toString()
    }

    fun stringOrDefault(key: String, default: String): String {
        return stringOrNull(key) ?: default
    }

    fun int(key: String): Int {
        return intOrNull(key)!!
    }

    fun intOrNull(key: String): Int? {
        return stringOrNull(key)?.toInt()
    }

    fun intOrDefault(key: String, default: Int): Int {
        return intOrNull(key) ?: default
    }

    fun boolean(key: String): Boolean {
        return booleanOrNull(key)!!
    }

    fun booleanOrNull(key: String): Boolean? {
        return when (stringOrNull(key)) {
            "true" -> true
            "false" -> false
            else -> null
        }
    }

    fun booleanOrDefault(key: String, default: Boolean): Boolean {
        return booleanOrNull(key) ?: default
    }

    inline fun <reified T : DataEnum> dataEnumOrNull(key: String): T? {
        return intOrNull(key)?.run {
            DataEnumUtil.getBy(T::class.java, this)
        }
    }

    inline fun <reified T : DataEnum> dataEnumOrDefault(key: String, default: T): T? {
        return dataEnumOrNull(key) ?: default
    }
}

class CommandKeywordBuilder {
    val keywordList = mutableListOf<Keyword>()

    operator fun String.invoke(func: KeywordBuilder.() -> Unit) {
        val builder = KeywordBuilder().apply(func)
        if (builder.order == null) {
            builder.order = keywordList.size
        }
        keywordList.add(builder.build(this))
    }

    fun new(keyword: String, func: KeywordBuilder.() -> Unit) {
        val builder = KeywordBuilder().apply(func)
        if (builder.order == null) {
            builder.order = keywordList.size
        }
        keywordList.add(builder.build(keyword))
    }
}

class KeywordBuilder {
    var order: Int? = null
    var desc: String? = null
    var simple: Char? = null
    var require: Boolean? = null

    internal fun build(keyword: String): Keyword {
        return Keyword(
            keyword = keyword,
            order = order,
            desc = desc,
            simple = simple,
            require = require,
        )
    }
}

fun ListenerHostDslBuilder.group(
    name: String,
    option: CommandKeywordBuilder.() -> Unit,
    keywordList: List<String> = mutableListOf(name),
    quote: Boolean = true,
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = true,
    concurrency: ConcurrencyKind = ConcurrencyKind.CONCURRENT,
    func: CommandResult.(event: GroupMessageEvent) -> Any?
) {
    metaDataList.add(
        GroupDslEventHandlerMetaData(
            name = name,
            priority = priority,
            ignoreCancelled = ignoreCancelled,
            concurrency = concurrency
        ) {
            checkAndRun(keywordList, quote, option, func)
        })
}

fun ListenerHostDslBuilder.friend(
    name: String,
    keywordList: Collection<String> = mutableSetOf(name),
    quote: Boolean = true,
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = true,
    concurrency: ConcurrencyKind = ConcurrencyKind.CONCURRENT,
    option: CommandKeywordBuilder.() -> Unit,
    func: CommandResult.(event: UserMessageEvent) -> Any?
) {
    metaDataList.add(
        FriendDslEventHandlerMetaData(
            name = name,
            priority = priority,
            ignoreCancelled = ignoreCancelled,
            concurrency = concurrency,
        ) {
            checkAndRun(keywordList, quote, option, func)
        })
}

private fun <T : MessageEvent> MessageSubscribersBuilder<T, Listener<T>, Unit, Unit>.checkAndRun(
    keywordList: Collection<String>,
    quote: Boolean,
    option: CommandKeywordBuilder.() -> Unit,
    func: CommandResult.(event: T) -> Any?
) {
    keywordList.forEach { keyword ->
        val ireply: MessageSubscribersBuilder<T, Listener<T>, Unit, Unit>.ListeningFilter.(it: T.(String) -> Any?) -> Any? =
            { if (quote) quoteReply(it) else reply(it) }

        //TODO(支持图片)
        startsWith(keyword).ireply {
            val commandResult = Command(
                keyword = keyword,
                optionFunc = option,
            ).handle(it.substringAfter(keyword).trim())
            func(commandResult, this)
        }
    }
}
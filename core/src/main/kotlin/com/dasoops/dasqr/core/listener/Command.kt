package com.dasoops.dasqr.core.listener

import com.dasoops.common.core.entity.dataenum.DataEnum
import com.dasoops.common.core.util.DataEnumUtil
import net.mamoe.mirai.event.ConcurrencyKind
import net.mamoe.mirai.event.EventPriority
import net.mamoe.mirai.event.Listener
import net.mamoe.mirai.event.MessageSubscribersBuilder
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MessageEvent
import net.mamoe.mirai.event.events.UserMessageEvent
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import net.mamoe.mirai.message.data.plus

/**
 * 匹配模式
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [Match]
 */
enum class Match {
    PREFIX, SUFFIX, EQUALS, CONTAIN;
}

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

/**
 * 指令
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [Command]
 */
class Command(
    val match: Match,
    val keyword: String,
    optionFunc: CommandKeywordBuilder.() -> Unit
) {
    private val keywordList = CommandKeywordBuilder().apply(optionFunc).keywordList

    fun handle(string: String): CommandResult {
        return CommandResult(this).apply {
            println(string)
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
) : Map<String, Any?> by mutableMapOf() {
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
        keywordList.add(KeywordBuilder().apply(func).build(this))
    }

    fun new(keyword: String, func: KeywordBuilder.() -> Unit) {
        keywordList.add(KeywordBuilder().apply(func).build(keyword))
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
    match: Match = Match.PREFIX,
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
            concurrency = concurrency,
            func = {
                suspend {
                    checkAndRun(match, keywordList, quote, option, func)
                }
            },
        )
    )
}

fun ListenerHostDslBuilder.user(
    name: String,
    match: Match = Match.PREFIX,
    keywordList: Collection<String> = mutableSetOf(name),
    quote: Boolean = true,
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = true,
    concurrency: ConcurrencyKind = ConcurrencyKind.CONCURRENT,
    option: CommandKeywordBuilder.() -> Unit,
    func: CommandResult.(event: UserMessageEvent) -> Any?
) {
    metaDataList.add(
        UserDslEventHandlerMetaData(
            name = name,
            priority = priority,
            ignoreCancelled = ignoreCancelled,
            concurrency = concurrency,
        ) {
            suspend {
                checkAndRun(match, keywordList, quote, option, func)
            }
        }
    )
}

private suspend fun <T : MessageEvent> MessageSubscribersBuilder<T, Listener<T>, Unit, Unit>.checkAndRun(
    match: Match,
    keywordList: Collection<String>,
    quote: Boolean,
    option: CommandKeywordBuilder.() -> Unit,
    func: CommandResult.(event: T) -> Any?
) {

    when (match) {
        Match.PREFIX -> run(keywordList, match, quote, option, func) { keyword ->
            startsWith(keyword)
        }

        Match.SUFFIX -> run(keywordList, match, quote, option, func) { keyword ->
            endsWith(keyword)
        }

        Match.EQUALS -> run(keywordList, match, quote, option, func) { keyword ->
            case(keyword)
        }

        Match.CONTAIN -> run(keywordList, match, quote, option, func) { keyword ->
            contains(keyword)
        }
    }
}

private suspend fun <T : MessageEvent> MessageSubscribersBuilder<T, Listener<T>, Unit, Unit>.run(
    keywordList: Collection<String>,
    match: Match,
    quote: Boolean,
    option: CommandKeywordBuilder.() -> Unit,
    func: suspend CommandResult.(event: T) -> Any?,
    runFunc: suspend MessageSubscribersBuilder<T, Listener<T>, Unit, Unit>.(keyword: String) -> MessageSubscribersBuilder<T, Listener<T>, Unit, Unit>.ListeningFilter
) {
    keywordList.forEach { keyword ->
        val filter = runFunc(this, keyword)

        if (quote) {
            filter quoteReply {
                val commandResult = Command(
                    match = match,
                    keyword = keyword,
                    optionFunc = option,
                ).handle(it)
                func(commandResult, this)
            }
        } else {
            filter reply {
                val commandResult = Command(
                    match = match,
                    keyword = keyword,
                    optionFunc = option,
                ).handle(it)
                func(commandResult, this)
            }
        }
    }
}
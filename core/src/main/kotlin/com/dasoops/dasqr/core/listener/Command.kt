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
import net.mamoe.mirai.message.data.MessageChain

enum class Match {
    PREFIX, SUFFIX, EQUALS, CONTAIN
}

/**
 * 关键词
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

class Command(
    internal val match: Match,
    val keyword: String,
    val message: MessageChain,
    func: CommandKeywordBuilder.() -> Unit
) : Map<String, Any?> by mutableMapOf() {
    private val keywordList = CommandKeywordBuilder().apply(func).keywordList

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

@JvmOverloads
fun ListenerHostDslBuilder.group(
    name: String,
    option: CommandKeywordBuilder.() -> Unit,
    match: Match = Match.PREFIX,
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = true,
    concurrency: ConcurrencyKind = ConcurrencyKind.CONCURRENT,
    func: suspend Command.(event: GroupMessageEvent) -> Any?
) {
    metaDataList.add(
        GroupDslEventHandlerMetaData(
            name = name,
            priority = priority,
            ignoreCancelled = ignoreCancelled,
            concurrency = concurrency,
            func = {
                checkAndRun(match, name, option, func)
            },
        )
    )
}

@JvmOverloads
fun ListenerHostDslBuilder.user(
    name: String,
    match: Match = Match.PREFIX,
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = true,
    concurrency: ConcurrencyKind = ConcurrencyKind.CONCURRENT,
    option: CommandKeywordBuilder.() -> Unit,
    func: suspend Command.(event: UserMessageEvent) -> Any?
) {
    metaDataList.add(
        UserDslEventHandlerMetaData(
            name = name,
            priority = priority,
            ignoreCancelled = ignoreCancelled,
            concurrency = concurrency,
            func = {
                checkAndRun(match, name, option, func)
            },
        )
    )
}

private fun <T : MessageEvent> MessageSubscribersBuilder<T, Listener<T>, Unit, Unit>.checkAndRun(
    match: Match,
    name: String,
    option: CommandKeywordBuilder.() -> Unit,
    func: suspend Command.(event: T) -> Any?
) {

    //TODO(待优化)
    when (match) {
        Match.PREFIX -> startsWith(name) {
            val command = Command(
                match = match,
                keyword = name,
                func = option,
                message = this.message
            )
            func(command, this)
        }

        Match.SUFFIX -> endsWith(name) {
            val command = Command(
                match = match,
                keyword = name,
                func = option,
                message = this.message
            )
            func(command, this)
        }

        Match.EQUALS -> name {
            val command = Command(
                match = match,
                keyword = name,
                func = option,
                message = this.message
            )
            func(command, this)
        }

        Match.CONTAIN -> contains(name) {
            val command = Command(
                match = match,
                keyword = name,
                func = option,
                message = this.message
            )
            func(command, this)
        }
    }
}
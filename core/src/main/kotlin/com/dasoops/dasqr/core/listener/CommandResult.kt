package com.dasoops.dasqr.core.listener

import com.dasoops.common.core.entity.dataenum.DataEnum
import com.dasoops.common.core.util.DataEnumUtil

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

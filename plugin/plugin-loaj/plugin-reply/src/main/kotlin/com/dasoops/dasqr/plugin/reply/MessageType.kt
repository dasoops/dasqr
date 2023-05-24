package com.dasoops.dasqr.plugin.reply

import com.dasoops.common.core.entity.dataenum.DataEnum
import com.dasoops.dasqr.plugin.reply.Replys.keyword
import net.mamoe.mirai.message.data.MessageChain

/**
 * 消息类型
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-06
 */
enum class MatchType(val match: (String, MessageChain) -> Boolean) : DataEnum {
    /**
     * 全文匹配
     */
    EQUALS(match = { keyword, message ->
        message.contentToString().trim() == keyword
    }),

    /**
     * 包含匹配
     */
    CONTAIN(match = { keyword, message ->
        message.contentToString().contains(keyword)
    }),

    /**
     * 前缀匹配
     */
    PREFIX(match = { keyword, message ->
        message.contentToString().trim().startsWith(keyword)
    }),

    /**
     * 后缀匹配
     */
    SUFFIX(match = { keyword, message ->
        message.contentToString().trim().endsWith(keyword)
    }),
    ;

    override val data = ordinal

    companion object {
        fun getOrNull(string: String): MatchType? {
            return when (string) {
                "prefix" -> PREFIX
                "suffix" -> SUFFIX
                "equals" -> EQUALS
                "contain" -> CONTAIN
                else -> null
            }
        }
    }
}
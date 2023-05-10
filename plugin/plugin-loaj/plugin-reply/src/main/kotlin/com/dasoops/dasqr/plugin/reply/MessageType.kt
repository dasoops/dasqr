package com.dasoops.dasqr.plugin.reply

import com.dasoops.common.core.entity.dataenum.DataEnum

/**
 * 消息类型
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-06
 */
enum class MatchType : DataEnum {
    /**
     * 全文匹配
     */
    EQUALS,

    /**
     * 包含匹配
     */
    CONTAIN,

    /**
     * 前缀匹配
     */
    PREFIX,

    /**
     * 后缀匹配
     */
    SUFFIX,
    ;

    override val data = ordinal
}
package com.dasoops.dasserver.plugin.loaj.entity.enums

import com.dasoops.common.entity.enums.base.IExceptionEnum

/**
 * @title LoajExceptionEnum
 * @classPath com.dasoops.dasserver.plugin.loaj.entity.enums.LoajExceptionEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/30
 * @version 1.0.0
 * @description loaj异常枚举
 * @see [LoajExceptionEnum]
 */
enum class LoajExceptionEnum(private val msg: String) : IExceptionEnum {

    UNDEFINEND_MATCH_TYPE("未定义的matchType"),
    ;

    override fun getCode(): Int {
        return 10000 + ordinal;
    }

    override fun getMsg(): String {
        return msg;
    }
}
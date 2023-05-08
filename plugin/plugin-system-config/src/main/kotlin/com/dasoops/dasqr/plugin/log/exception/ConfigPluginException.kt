package com.dasoops.dasqr.plugin.log.exception

import com.dasoops.common.core.IExceptionEnum
import com.dasoops.common.core.exception.ProjectExceptionEntity

/**
 * 配置插件异常(151xx)
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-06
 */
enum class ConfigPluginException(override val message: String) : IExceptionEnum {
    NO_RECORD("没有查询到配置记录"),
    ;

    override val code: Int = 15100 + ordinal
    override fun get() = ConfigPluginExceptionEntity(this)
}

open class ConfigPluginExceptionEntity(exceptionEnum: ConfigPluginException, message: String = exceptionEnum.message) : ProjectExceptionEntity(exceptionEnum, message)
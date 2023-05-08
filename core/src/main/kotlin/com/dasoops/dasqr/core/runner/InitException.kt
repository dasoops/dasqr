package com.dasoops.dasqr.core.runner

import com.dasoops.common.core.IExceptionEnum
import com.dasoops.common.core.exception.ProjectExceptionEntity

/**
 * 初始化异常(100xx)
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-06
 */
enum class InitException(override val message: String) : IExceptionEnum {
    NO_EXCEPTION_HANDLER_SCAN_PATH("没有找到异常处理扫描路径配置(dasqr.exception.scan-path)"),
    NO_PLUGIN_SCAN_PATH("没有找到插件类扫描路径配置(dasqr.plugin.scan-path)"),
    MUST_OBJECT_INSTANCE("类必须为kotlin object对象"),
    FIND_MULTI_CLASS("扫描到多个加载类"),
    NO_FIND_CLASS("未找到加载类"),
    UNDEFINED_LOGIN_TYPE("未定义的登录类型"),
    UNDEFINED_PROTOCOL("未定义的mirai协议"),

    ;

    override val code: Int = 10000 + ordinal
    override fun get() = InitExceptionEntity(this)
}

open class InitExceptionEntity(exceptionEnum: InitException, message: String = exceptionEnum.message) : ProjectExceptionEntity(exceptionEnum, message)
package com.dasoops.dasqr.plugin.log.message

import com.dasoops.common.core.IExceptionEnum
import com.dasoops.common.core.exception.ProjectExceptionEntity

/**
 * 消息日志异常(150xx)
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-06
 */
enum class MessageLogException(override val message: String) : IExceptionEnum {
    UNDEFINED_MESSAGE_TYPE("未定义的消息类型");

    override val code: Int = 15000 + ordinal
    override fun get() = MessageLogExceptionEntity()
    inner class MessageLogExceptionEntity : ProjectExceptionEntity(this)
}
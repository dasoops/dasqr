package com.dasoops.dasqr.core.mapping.log.exception

import com.baomidou.mybatisplus.annotation.TableName
import com.dasoops.common.db.entity.dbo.BaseDo

/**
 * 异常记录表
 * @TableName core_exception_log
 */
@TableName(value = "core_exception_log")
class ExceptionLogDo : BaseDo() {
    /**
     * 堆栈信息
     */
    var stackInfo: String? = null
    /**
     * 顶层信息
     */
    var topMessage: String? = null
    /**
     * 异常类型
     */
    var exceptionType: String? = null
}
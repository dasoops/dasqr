package com.dasoops.dasqr.core.exception

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.dasqr.core.config.ExceptionProperties

/**
 * 异常处理器池接口
 * @author DasoopsNicole@Gmail.com
 * @date 2023-05-08
 */
@IgnoreResourcesScan
interface ExceptionHandlerPool {
    /**
     * 处理
     * @param [exception] 异常
     */
    fun handle(exception: Throwable)

    /**
     * 初始化
     * @param [config] 配置
     */
    fun init(config: ExceptionProperties)
}
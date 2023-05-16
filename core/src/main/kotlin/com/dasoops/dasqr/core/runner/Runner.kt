package com.dasoops.dasqr.core.runner

import com.dasoops.common.core.util.resources.IgnoreResourcesScan

/**
 * 启动加载器
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/16
 * @see [Runner]
 */
@IgnoreResourcesScan
interface Runner {

    fun init()

}
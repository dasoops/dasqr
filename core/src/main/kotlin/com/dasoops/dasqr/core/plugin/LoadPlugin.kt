package com.dasoops.dasqr.core.plugin

import com.dasoops.dasqr.core.listener.DasqrListenerHost
import com.dasoops.dasqr.core.loader.DasqrPlugin

/**
 * 已加载插件
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/26
 * @see [LoadPlugin]
 */
data class LoadPlugin(
    /**
     * 所属包
     */
    val from: DasqrPlugin,

    /**
     * 加载的监听器
     */
    val listenerHost: DasqrListenerHost,

    /**
     * 名称
     */
    val methodName: String
)
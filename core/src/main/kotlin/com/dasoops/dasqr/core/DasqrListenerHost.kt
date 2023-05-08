package com.dasoops.dasqr.core

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import net.mamoe.mirai.event.SimpleListenerHost
import org.slf4j.LoggerFactory

/**
 * ListenerHost抽象类
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@IgnoreResourcesScan
abstract class DasqrListenerHost : SimpleListenerHost() {
    private val log = LoggerFactory.getLogger(javaClass)
}
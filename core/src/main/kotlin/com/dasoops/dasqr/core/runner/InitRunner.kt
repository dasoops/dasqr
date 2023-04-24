package com.dasoops.dasqr.core.runner

import com.dasoops.common.json.Json
import com.dasoops.dasqr.core.IBot
import net.mamoe.mirai.utils.LoggerAdapters
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

/**
 * 初始化
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@Component
class InitRunner : ApplicationRunner {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun run(args: ApplicationArguments) {

        log.info("load mirai-log configuration: ${Json.toJsonStr(MiraiProperties.log)}")
        if (MiraiProperties.log.useLog4j2) {
            LoggerAdapters.useLog4j2()
            log.info("useLog4j2")
        }

        log.info("load mirai-bot  configuration: ${Json.toJsonStr(MiraiProperties.bot)}")
        log.info("load mirai-file configuration: ${Json.toJsonStr(MiraiProperties.file)}")

        //调用一下来初始化bot
        IBot
        log.info("init IBot")


        log.info("load dasqr-exception  configuration: ${Json.toJsonStr(DasqrProperties.exception)}")
    }
}
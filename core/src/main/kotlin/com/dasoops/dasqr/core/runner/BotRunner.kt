package com.dasoops.dasqr.core.runner

import com.dasoops.dasqr.core.IBot
import net.mamoe.mirai.utils.LoggerAdapters
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class BotRunner : ApplicationRunner {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun run(args: ApplicationArguments) {
        LoggerAdapters.useLog4j2()
        log.info("useLog4j2")

        IBot
        log.info("init IBot")
    }
}
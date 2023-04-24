package com.dasoops.dasqr.core

import com.dasoops.dasqr.core.runner.BotProperties
import com.dasoops.dasqr.core.runner.FileProperties
import com.dasoops.dasqr.core.runner.MiraiProperties
import kotlinx.coroutines.runBlocking
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Import

@SpringBootApplication
@ConfigurationPropertiesScan("com.dasoops.dasqr.core.runner")
class CoreApplication

fun main(args: Array<String>): Unit = runBlocking {
    SpringApplication.run(CoreApplication::class.java, *args)
}
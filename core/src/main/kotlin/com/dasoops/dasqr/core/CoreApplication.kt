package com.dasoops.dasqr.core

import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.utils.BotConfiguration
import net.mamoe.mirai.utils.StandardCharImageLoginSolver
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.io.File

@SpringBootApplication
class CoreApplication

fun main(args: Array<String>) = runBlocking {
    val bot = BotFactory.newBot(3488521150, "xu1627026076") {
        loginSolver = StandardCharImageLoginSolver()
        protocol = BotConfiguration.MiraiProtocol.ANDROID_PHONE
        fileBasedDeviceInfo("/temp/mirai/device.json")
        cacheDir = File("/temp/mirai/cache")
    }
    bot.login()
}
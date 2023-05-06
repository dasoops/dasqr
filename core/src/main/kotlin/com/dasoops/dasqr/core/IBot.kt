package com.dasoops.dasqr.core

import com.dasoops.dasqr.core.runner.properties.MiraiLoginType
import com.dasoops.dasqr.core.runner.properties.MiraiProperties
import kotlinx.coroutines.launch
import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.auth.BotAuthorization
import net.mamoe.mirai.utils.BotConfiguration
import net.mamoe.mirai.utils.StandardCharImageLoginSolver
import java.io.File

/**
 * 单例bot,方便使用
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
object IBot : Bot by run({
    val botProperties = MiraiProperties.bot
    //bot配置项
    val botConfiguration = BotConfiguration {
        val fileProperties = MiraiProperties.file
        protocol = botProperties.protocol
        cacheDir = File(fileProperties.cachePath)
        workingDir = File(fileProperties.workingDir)
        fileBasedDeviceInfo(fileProperties.deviceInfoPath)
    }

    //bot登录配置
    if (botProperties.type == MiraiLoginType.PASSWORD) {
        BotFactory.newBot(botProperties.qq, botProperties.password, botConfiguration)
    } else {
        BotFactory.newBot(botProperties.qq, BotAuthorization.byQRCode(), botConfiguration.apply {
            loginSolver = StandardCharImageLoginSolver()
        })
    }.apply {
        launch {
            IBot.login()
        }
        PluginLoader.loadList.forEach {
            this.eventChannel.registerListenerHost(it)
            logger.info("register dasqrListenerHost: ${it::class.java.name}")
        }
    }
})
package com.dasoops.dasqr.core

import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.MiraiLoginType
import com.dasoops.dasqr.core.exception.ExceptionHandlerPool
import kotlinx.coroutines.launch
import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.auth.BotAuthorization
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.GlobalEventChannel.exceptionHandler
import net.mamoe.mirai.event.events.BotEvent
import net.mamoe.mirai.utils.BotConfiguration
import net.mamoe.mirai.utils.LoginSolver
import net.mamoe.mirai.utils.StandardCharImageLoginSolver
import java.io.File

/**
 * 单例bot,方便使用
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
object IBot : Bot by run({
    val botProperties = Config.INSTANCE.mirai.bot
    //bot配置项
    val botConfiguration = BotConfiguration {
        val fileConfig = Config.INSTANCE.mirai.file
        protocol = botProperties.protocol
        fileConfig.cachePath?.run {
            cacheDir = File(this)
        }
        fileConfig.workingDir?.run {
            cacheDir = File(this)
        }
        fileConfig.deviceInfoPath?.run {
            fileBasedDeviceInfo(this)
        }
    }

    //bot登录配置
    if (botProperties.type == MiraiLoginType.PASSWORD) {
        BotFactory.newBot(botProperties.qq, botProperties.password, botConfiguration.apply {
            loginSolver = LoginSolver.Default
        })
    } else {
        BotFactory.newBot(botProperties.qq, BotAuthorization.byQRCode(), botConfiguration.apply {
            loginSolver = StandardCharImageLoginSolver()
        })
    }.apply {
        launch {
            IBot.login()
        }
    }
}) {
    override val eventChannel: EventChannel<BotEvent>
        //重写一下加个异常处理
        get() = GlobalEventChannel.filterIsInstance<BotEvent>()
            .filter { it.bot === this.bot }
            .exceptionHandler { ExceptionHandlerPool.INSTANCE.handle(it) }
}
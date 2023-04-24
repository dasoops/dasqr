package com.dasoops.dasqr.core

import kotlinx.coroutines.launch
import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.utils.BotConfiguration
import net.mamoe.mirai.utils.StandardCharImageLoginSolver
import java.io.File

/**
 * 单例bot,方便使用
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
object IBot :
    Bot by
    BotFactory.newBot(3488521150, "xu1627026076", {
        loginSolver = StandardCharImageLoginSolver()
        protocol = BotConfiguration.MiraiProtocol.ANDROID_PHONE
        fileBasedDeviceInfo("/temp/mirai/device.json")
        cacheDir = File("/temp/mirai/cache")
    }).apply({ launch { IBot.login() } }) {
}
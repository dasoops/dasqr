package com.dasoops.dasqr.core.config

import com.dasoops.dasqr.core.runner.InitException
import com.dasoops.dasqr.core.runner.InitExceptionEntity
import net.mamoe.mirai.utils.BotConfiguration

/**
 * miraiBot配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */

class MiraiConfig(
    bot: BotConfig? = null,
    file: FileConfig? = null,
    log: LogConfig? = null,
) {
    val bot: BotConfig
    val file: FileConfig
    val log: LogConfig

    init {
        this.bot = bot ?: BotConfig()
        this.file = file ?: FileConfig()
        this.log = log ?: LogConfig()
    }
}

/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class LogConfig(
    useLog4j2: Boolean? = null
) {

    /**
     * 是否使用log4j2接管mirai日志系统
     */
    val useLog4j2: Boolean

    init {
        this.useLog4j2 = useLog4j2 ?: true
    }
}

/**
 * miraiBot配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class BotConfig(
    qq: Long? = null,
    password: String? = null,
    type: String? = null,
    protocol: String? = null,
) {

    /**
     * qq号
     */
    val qq: Long

    /**
     * 密码
     */
    val password: String

    /**
     * 类型
     */
    val type: MiraiLoginType

    /**
     * 协议
     */
    val protocol: BotConfiguration.MiraiProtocol

    init {
        this.qq = qq ?: 0
        this.password = password ?: "none"
        this.type = when (type) {
            null, "password","PASSWORD" -> MiraiLoginType.PASSWORD
            "byQrCode","BY_QR_CODE" -> MiraiLoginType.BY_QR_CODE
            else -> throw InitExceptionEntity(
                InitException.UNDEFINED_LOGIN_TYPE,
                "${InitException.UNDEFINED_LOGIN_TYPE.message} -> $protocol"
            )
        }
        this.protocol = when (protocol) {
            null, "android_phone", "ANDROID_PHONE" -> BotConfiguration.MiraiProtocol.ANDROID_PHONE
            "android_pad", "ANDROID_PAD" -> BotConfiguration.MiraiProtocol.ANDROID_PAD
            "android_watch", "ANDROID_WATCH" -> BotConfiguration.MiraiProtocol.ANDROID_WATCH
            "ipad", "IPAD" -> BotConfiguration.MiraiProtocol.IPAD
            "macos", "MACOS" -> BotConfiguration.MiraiProtocol.MACOS
            else -> throw InitExceptionEntity(
                InitException.UNDEFINED_PROTOCOL,
                "${InitException.UNDEFINED_PROTOCOL.message} -> $protocol"
            )
        }
    }
}

/**
 * mirai登录类型
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
enum class MiraiLoginType {
    //扫码
    BY_QR_CODE,

    //密码
    PASSWORD,
    ;
}

/**
 * mirai存储文件配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class FileConfig(
    deviceInfoPath: String? = null,
    cachePath: String? = null,
    workingDir: String? = null
) {

    /**
     * 设备信息文件
     */
    val deviceInfoPath: String?

    /**
     * 缓存路径
     */
    val cachePath: String?

    /**
     * 工作目录
     */
    val workingDir: String?

    init {
        this.deviceInfoPath = deviceInfoPath
        this.cachePath = cachePath
        this.workingDir = workingDir
    }
}
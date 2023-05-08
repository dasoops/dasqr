package com.dasoops.dasqr.core.config

import com.dasoops.dasqr.core.runner.InitException
import com.dasoops.dasqr.core.runner.InitExceptionEntity
import net.mamoe.mirai.utils.BotConfiguration

/**
 * miraiBot配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */

class MiraiProperties(
    val bot: BotProperties,
    val file: FileProperties,
    val log: LogProperties,
)

/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class LogProperties(
    /**
     * 是否使用log4j2接管mirai日志系统
     */
    val useLog4j2: Boolean
)

/**
 * miraiBot配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class BotProperties(
    qq: Long,
    password: String,
    type: String,
    protocol: String,
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
        this.qq = qq
        this.password = password
        this.type = when (type) {
            "password" -> MiraiLoginType.PASSWORD
            "byQrCode" -> MiraiLoginType.BY_QR_CODE
            else -> throw InitExceptionEntity(
                InitException.UNDEFINED_LOGIN_TYPE,
                "${InitException.UNDEFINED_LOGIN_TYPE.message} -> $protocol"
            )
        }
        this.protocol = when (protocol) {
            "android_phone" -> BotConfiguration.MiraiProtocol.ANDROID_PHONE
            "android_pad" -> BotConfiguration.MiraiProtocol.ANDROID_PAD
            "android_watch" -> BotConfiguration.MiraiProtocol.ANDROID_WATCH
            "ipad" -> BotConfiguration.MiraiProtocol.IPAD
            "macos" -> BotConfiguration.MiraiProtocol.MACOS
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
class FileProperties(
    /**
     * 设备信息文件
     */
    val deviceInfoPath: String,

    /**
     * 缓存路径
     */
    val cachePath: String,

    /**
     * 工作目录
     */
    val workingDir: String
)
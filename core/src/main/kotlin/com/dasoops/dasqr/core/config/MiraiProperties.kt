package com.dasoops.dasqr.core.config

import cn.hutool.extra.spring.SpringUtil
import net.mamoe.mirai.utils.BotConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

/**
 * miraiBot配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */

class MiraiProperties {
    val bot: BotProperties = SpringUtil.getBean(BotProperties::class.java)
    val file: FileProperties = SpringUtil.getBean(FileProperties::class.java)
    val log: LogProperties = SpringUtil.getBean(LogProperties::class.java)
}

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
) {
    companion object {
        const val PREFIX = "log"
    }
}

/**
 * miraiBot配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
class BotProperties(
    /**
     * qq号
     */
    val qq: Long,

    /**
     * 密码
     */
    val password: String,

    /**
     * 类型
     */
    val type: MiraiLoginType,

    /**
     * 协议
     */
    val protocol: BotConfiguration.MiraiProtocol,
)

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
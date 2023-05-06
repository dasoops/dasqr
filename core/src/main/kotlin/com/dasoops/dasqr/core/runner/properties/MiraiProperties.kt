package com.dasoops.dasqr.core.runner.properties

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

object MiraiProperties {
    const val PREFIX = "mirai"
    val bot: BotProperties = SpringUtil.getBean(BotProperties::class.java)
    val file: FileProperties = SpringUtil.getBean(FileProperties::class.java)
    val log: LogProperties = SpringUtil.getBean(LogProperties::class.java)
}


/**
 * miraiLog配置项
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@ConfigurationProperties(prefix = "${MiraiProperties.PREFIX}.${LogProperties.PREFIX}")
class LogProperties @ConstructorBinding constructor(
    /**
     * 是否使用log4j2接管mirai日志系统
     */
    @Value("\${useLog4j2:false}")
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
@ConfigurationProperties(prefix = "${MiraiProperties.PREFIX}.${BotProperties.PREFIX}")
class BotProperties @ConstructorBinding constructor(
    /**
     * qq号
     */
    @Value("\${qq:3488521150}")
    val qq: Long,

    /**
     * 密码
     */
    @Value("\${password:password}")
    val password: String,

    /**
     * 类型
     */
    @Value("\${type:password}")
    val type: MiraiLoginType,

    /**
     * 协议
     */
    @Value("\${protocol:android_phone}")
    val protocol: BotConfiguration.MiraiProtocol,
) {
    companion object {
        const val PREFIX = "bot"
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
@ConfigurationProperties(prefix = "${MiraiProperties.PREFIX}.${FileProperties.PREFIX}")
class FileProperties @ConstructorBinding constructor(
    /**
     * 设备信息文件
     */
    @Value("\${deviceInfoPath:device.json}")
    val deviceInfoPath: String,

    /**
     * 缓存路径
     */
    @Value("\${cachePath:cache}")
    val cachePath: String,

    /**
     * 工作目录
     */
    @Value("\${workingDir:.}")
    val workingDir: String
) {

    companion object {
        const val PREFIX = "file"
    }
}
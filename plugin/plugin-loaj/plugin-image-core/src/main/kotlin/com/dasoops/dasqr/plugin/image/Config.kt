package com.dasoops.dasqr.plugin.image

import com.dasoops.common.core.exception.SimpleProjectExceptionEntity
import com.dasoops.common.core.util.resources.Resources
import com.dasoops.common.json.core.parse
import com.dasoops.common.json.core.toJsonStr
import com.dasoops.common.json.jackson.Jackson
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.getOrNull
import com.dasoops.dasqr.core.util.DefaultImpl
import com.dasoops.dasqr.core.util.QuickServiceLoader
import com.dasoops.dasqr.core.util.resourcesDir

val Config.baseImage: ImageConfig
    get() = getOrNull("image")?.run {
        //检查加载配置项与当前启用的是否一致
        val className = Jackson.INSTANCE.parseNode(this).get("className").asText()
        if (QuickServiceLoader.getOne<ImageConfig>().className != className) {
            throw SimpleProjectExceptionEntity("加载配置项[image]异常,请确认配置项与加载插件是否对应")
        }
        parse(Thread.currentThread().contextClassLoader.loadClass(className)) as ImageConfig
    } ?: run {
        val default = QuickServiceLoader.getOne<ImageConfig>()
        addAndInit(
            key = "image",
            description = "image配置项",
            configStr = default.toJsonStr()
        )
        default
    }


/**
 * 图片插件配置
 * @author DasoopsNicole@Gmail.com
 * @date 2023/07/22
 * @see [ImageConfig]
 */
interface ImageConfig {
    val className: String
}

inline fun <reified T : ImageConfig> Config.checkGet() = runCatching {
    Config.INSTANCE.baseImage as T
}.getOrElse {
    if (it is ClassCastException) {
        log.error("imageApi配置项与当前加载插件不同,请修改配置后再次启动")
    }
    throw it
}

val Config.defaultImage: DefaultImageConfig
    get() = checkGet<DefaultImageConfig>()

@DefaultImpl
open class DefaultImageConfig(
    path: String? = null,
) : ImageConfig {
    val path: String
    override val className: String = javaClass.name

    init {
        this.path = path ?: Resources.resourcesDir.path
    }
}
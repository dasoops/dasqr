package com.dasoops.dasqr.core.loader

import com.dasoops.common.core.util.resources.Resources
import java.io.File
import java.net.URI
import java.util.jar.Attributes
import java.util.jar.JarFile

/**
 * dasqr插件
 *
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/06
 */
open class DasqrPlugin {
    /**
     * 原始路径
     */
    val rawPath: URI

    /**
     * 路径
     */
    val path: String

    /**
     * 名称
     */
    val name: String

    /**
     * 版本
     */
    val version: String

    /**
     * 描述
     */
    val description: String

    /**
     * 作者
     */
    val author: String

    constructor(rawPath: URI, path: String, name: String, version: String, description: String, author: String) {
        this.rawPath = rawPath
        this.path = path
        this.name = name
        this.version = version
        this.description = description
        this.author = author
    }

    constructor(file: File) {
        JarFile(file).use { jarFile ->
            val attributes: Attributes = jarFile.manifest.mainAttributes
            if (!attributes.containsKey(Attributes.Name("Plugin-Name"))) {
                throw LaunchException("no 'Plugin-Name', please check plugin? file: " + jarFile.name)
            }
            rawPath = file.toURI()
            path = file.path
            name = attributes.getValue("Plugin-Name")
            author = attributes.getValue("Plugin-Author")
            version = attributes.getValue("Plugin-Version")
            description = attributes.getValue("Plugin-Description")
        }
    }

    override fun toString(): String {
        return """
            $name
                path: $path
                author : $author
                version : $version
                description : $description
            """.trimIndent()

    }
}

/**
 * 核心包
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/26
 */
object CorePackage : DasqrPlugin(
    rawPath = DasqrPlugin::class.java.protectionDomain.codeSource.location.toURI(),
    path = "base",
    name = "dasqr.core",
    version = "1.0.0",
    description = "dasqr核心模块",
    author = "DasoopsNicole@gmail.com",
)

/**
 * 开发
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/26
 */
object Development : DasqrPlugin(
    rawPath = File(System.getProperty("user.dir")).toURI(),
    path = "dev",
    name = "dasqr.dev",
    version = "开发环境,无法读取插件信息",
    description = "开发环境,无法读取插件信息",
    author = "开发环境,无法读取插件信息",
)
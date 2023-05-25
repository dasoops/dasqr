package com.dasoops.dasqr.core.loader

import java.io.File
import java.util.*
import java.util.jar.Attributes
import java.util.jar.JarFile

/**
 * dasqr插件
 *
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/06
 */
class DasqrPlugin(file: File) {
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

    init {
        JarFile(file).use { jarFile ->
            val attributes: Attributes = jarFile.manifest.mainAttributes
            if (!attributes.containsKey(Attributes.Name("Plugin-Name"))) {
                throw LaunchException("no 'Plugin-Name', please check plugin? file: " + jarFile.name)
            }
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

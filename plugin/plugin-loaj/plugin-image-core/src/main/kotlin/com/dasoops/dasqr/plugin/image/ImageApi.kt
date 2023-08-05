package com.dasoops.dasqr.plugin.image

import cn.hutool.core.io.IoUtil
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.util.DefaultImpl
import java.io.File
import java.io.InputStream
import java.io.OutputStream

interface ImageApi {
    fun get(fileName: String): InputStream
    fun save(fileName: String, stream: InputStream)
}

@DefaultImpl
open class LocalImageApi : ImageApi {
    val saveDir = File(Config.INSTANCE.defaultImage.path)
    fun String.toFile(): File = File(saveDir.path + this)

    init {
        if (!saveDir.exists()) {
            saveDir.mkdirs()
        }
    }

    override fun get(fileName: String): InputStream = fileName.toFile().inputStream()

    override fun save(fileName: String, stream: InputStream) {
        fileName.toFile().apply {
            createNewFile()
            IoUtil.copy(stream, outputStream())
        }
    }

}
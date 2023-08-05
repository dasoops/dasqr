package com.dasoops.dasqr.plugin.image

import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.plugin.http.client.NO_PROXY_INSTANCE
import com.qcloud.cos.COSClient
import com.qcloud.cos.ClientConfig
import com.qcloud.cos.auth.BasicCOSCredentials
import com.qcloud.cos.model.ObjectMetadata
import com.qcloud.cos.region.Region
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory
import java.io.InputStream

val Config.image: TencentCosImageConfig
    get() = checkGet<TencentCosImageConfig>()

open class TencentCosImageConfig(
    secretId: String? = null,
    secretKey: String? = null,
    region: String? = null,
    bucket: String? = null,
) : ImageConfig {
    override val className: String = javaClass.name
    val secretId: String
    val secretKey: String
    val region: String
    val bucket: String

    init {
        this.secretId = secretId ?: "empty"
        this.secretKey = secretKey ?: "empty"
        this.region = region ?: "empty"
        this.bucket = bucket ?: "empty"
    }
}

class TencentCosImageApi : ImageApi {
    private val logger = LoggerFactory.getLogger(javaClass)

    init {
        logger.info("load TencentCos ImageApi")
    }

    val config = Config.INSTANCE.image
    val cosClient = COSClient(
        BasicCOSCredentials(
            config.secretId,
            config.secretKey
        ), ClientConfig(Region(config.region))
    )

    override fun get(fileName: String): InputStream =
        OkHttpClient.NO_PROXY_INSTANCE.newCall(
            Request.Builder()
                .url(cosClient.getObjectUrl(config.bucket, fileName))
                .build()
        ).execute().body.byteStream()

    override fun save(fileName: String, stream: InputStream) {
        cosClient.putObject(config.bucket, fileName, stream, ObjectMetadata())
    }
}
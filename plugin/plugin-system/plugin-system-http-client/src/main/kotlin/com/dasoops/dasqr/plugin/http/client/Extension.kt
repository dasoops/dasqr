package com.dasoops.dasqr.plugin.http.client

import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL


/**
 * 实例
 */
val OkHttpClient.Companion.INSTANCE: OkHttpClient
    get() = OkHttpRunner.INSTANCE.instance

/**
 * 无代理实例
 */
val OkHttpClient.Companion.NO_PROXY_INSTANCE: OkHttpClient
    get() = OkHttpRunner.INSTANCE.noProxyInstance

fun URL.request(client: OkHttpClient = OkHttpClient.INSTANCE) =
    OkHttpClient.NO_PROXY_INSTANCE.newCall(
        Request.Builder()
            .url(this)
            .build()
    ).execute()

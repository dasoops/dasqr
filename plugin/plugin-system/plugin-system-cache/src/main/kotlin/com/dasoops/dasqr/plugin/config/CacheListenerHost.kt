package com.dasoops.dasqr.plugin.config

import cn.hutool.cache.impl.CacheObj
import com.dasoops.common.json.core.toJsonStr
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.listener.ListenerHostDslBuilder
import kotlinx.serialization.json.Json
import net.mamoe.mirai.message.data.sendTo
import net.mamoe.mirai.message.data.toPlainText

/**
 * 缓存listener host
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/15
 * @see [CacheListenerHost]
 */
open class CacheListenerHost : DslListenerHost() {
    override fun create(): suspend ListenerHostDslBuilder.() -> Unit = {
        group("更新缓存") {
            case("refresh cache") quoteReply {
                Cache.clear()
                "ok"
            }
        }
        friend("输出缓存") {
            startsWith("echo cache", removePrefix = true, trim = true) { keyword ->
                Cache.cacheMap.filterKeys { it.toString().contains(keyword, ignoreCase = true) }
                    .forEach { (k, v) ->
                        try {
                            """
                            |key: $k
                            |value: ${
                                v.cacheObjIterator().asSequence().joinToString(",", "{", "}") {
                                    """"${it.key.toJsonStr()}":${it.value.toJsonStr()}"""
                                }
                            }
                        """.trimMargin().toPlainText().sendTo(subject)
                        } catch (e: Exception) {
                            """
                            |down echo
                            |key: $k
                            |value: ${v.cacheObjIterator().asSequence().toList()}
                        """.trimMargin().toPlainText().sendTo(subject)
                        }
                    }
            }
            (case("cache list")) reply {
                Cache.cacheMap
                    .map { it.key.toString() }
                    .joinToString("\n")
            }
        }
    }
}
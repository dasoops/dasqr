package com.dasoops.dasqr.plugin.ylynews

import cn.hutool.cache.impl.LRUCache
import com.dasoops.common.core.util.getOrNullAndSet
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.core.runner.Runner
import com.dasoops.dasqr.plugin.OkHttpRunner.NO_PROXY_INSTANCE
import com.dasoops.dasqr.plugin.config.Cache
import com.dasoops.dasqr.plugin.schedule.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import org.ktorm.dsl.eq
import org.slf4j.LoggerFactory

enum class News {
    ZHI_HU;
}

object NewsPublic : Runner, ScheduleTask {
    //10分钟缓存
    val cache: LRUCache<News, String> = Cache.newLRUCache(this::class, 10)
    private val log = LoggerFactory.getLogger(javaClass)

    fun getZhihuNews(): String {
        log.debug("请求知乎日报")
        //前缀,网页中的路径不带前缀}
        val urlPrefix = "https://daily.zhihu.com";
        //发请求获取网页内容
        val info = OkHttpClient.NO_PROXY_INSTANCE.newCall(
            Request.Builder()
                .url("https://daily.zhihu.com/#section_head")
                .get().build()
        ).execute().body!!.string()
        // 解析并获取标签为wrap的
        val parse = Jsoup.parse(info).getElementsByClass("wrap")
        // 创建返回消息
        var i = 1
        return parse.joinToString(
            prefix = "来咯,这是今天的知乎日报，一共${parse.size}条消息${System.lineSeparator()}",
            separator = System.lineSeparator()
        ) {
            """
                |第${i++}条消息
                |${it.text()}链接是$urlPrefix${it.selectFirst("a")?.attr("href") ?: String}
            """.trimMargin()
        }
    }

    override fun run(paramJson: String?) {
        cache.clear()
    }

    override suspend fun init() {
        val isInit = ScheduleDao.INSTANCE.anyMatched {
            it.`class` eq NewsPublic::class.java.name
        }
        if (isInit) {
            return
        }


        ScheduleDao.INSTANCE.add(ScheduleDo {
            //每天
            this.cron = "0 0 * * *"
            this.`class` = NewsPublic::class.java.name
            this.description = "清除日报缓存"
            this.enable = true
        })
        ScheduleRunner.init()
    }
}

/**
 * 消息回复listenerHost
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/10
 * @see [YlyNewsListenerHost]
 */
open class YlyNewsListenerHost : DslListenerHost({
    group("zhihu news") {
        case("日报") quoteReply {
            intercept()
            NewsPublic.cache.getOrNullAndSet(News.ZHI_HU) {
                NewsPublic.getZhihuNews()
            }
        }
    }
})
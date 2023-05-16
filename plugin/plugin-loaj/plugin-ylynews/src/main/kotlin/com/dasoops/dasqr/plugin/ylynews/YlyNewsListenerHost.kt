package com.dasoops.dasqr.plugin.ylynews

import cn.hutool.cache.impl.TimedCache
import cn.hutool.http.HttpUtil
import com.dasoops.common.core.util.getOrNullAndSet
import com.dasoops.dasqr.core.listener.DslListenerHost
import com.dasoops.dasqr.plugin.config.Cache
import org.jsoup.Jsoup
import org.slf4j.LoggerFactory

enum class News {
    ZHI_HU;
}

object NewsPublic {
    //10分钟缓存
    val cache: TimedCache<News, String> = Cache.newTimedCache(this::class, 1000 * 60 * 10)
    private val log = LoggerFactory.getLogger(javaClass)

    fun getZhihuNews(): String {
        log.debug("请求知乎日报")
        //前缀,网页中的路径不带前缀}
        val urlPrefix = "https://daily.zhihu.com";
        //发请求获取网页内容
        val info = HttpUtil.get("https://daily.zhihu.com/#section_head")
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
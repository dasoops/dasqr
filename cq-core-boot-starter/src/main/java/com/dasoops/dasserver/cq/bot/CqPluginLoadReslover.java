package com.dasoops.dasserver.cq.bot;

import com.dasoops.dasserver.cq.CqPlugin;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * @Title: CqPluginLoadReslover
 * @ClassPath com.dasoops.dasserver.cq.bot.CqPluginLoadReslover
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 插件加载解析器
 */
public interface CqPluginLoadReslover {
    /**
     * 刷新
     *
     * @param applicationContext applicationContext
     * @return {@link Map}<{@link String}, {@link CqPlugin}>
     */
    Map<String, CqPlugin> refresh(ApplicationContext applicationContext);
}
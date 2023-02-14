package com.dasoops.dasserver.cq.bot;

import com.dasoops.dasserver.cq.CqPlugin;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * @title: CqPluginLoadReslover
 * @classPath com.dasoops.dasserver.cq.bot.CqPluginLoadReslover
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/10
 * @version 1.0.0
 * @description 插件加载解析器
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
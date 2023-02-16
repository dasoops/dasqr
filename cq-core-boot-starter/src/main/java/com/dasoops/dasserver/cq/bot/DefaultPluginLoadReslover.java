package com.dasoops.dasserver.cq.bot;

import com.dasoops.dasserver.cq.CqPlugin;
import org.springframework.context.ApplicationContext;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @title DefaultPluginLoadReslover
 * @classPath com.dasoops.dasserver.cq.bot.DefaultPluginLoadReslover
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/10
 * @version 1.0.0
 * @description 默认插件加载解析器
 * @see CqPluginLoadReslover
 */
public class DefaultPluginLoadReslover implements CqPluginLoadReslover {
    @Override
    public Map<String, CqPlugin> refresh(ApplicationContext applicationContext) {
        return applicationContext
                .getBeansOfType(CqPlugin.class).values().stream()
                .collect(Collectors.toMap(cqPlugin -> cqPlugin.getRawPlugin().getClass().getName(), cqPlugin -> cqPlugin));
    }
}

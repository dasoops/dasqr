package com.dasoops.dasserver.cq.bot;

import com.dasoops.dasserver.cq.CqPlugin;
import org.springframework.context.ApplicationContext;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Title: DefaultPluginLoadReslover
 * @ClassPath com.dasoops.dasserver.cq.bot.DefaultPluginLoadReslover
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 默认插件加载解析器
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

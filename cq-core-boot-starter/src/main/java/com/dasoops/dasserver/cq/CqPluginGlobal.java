package com.dasoops.dasserver.cq;

import cn.hutool.core.collection.CollectionUtil;
import com.dasoops.dasserver.cq.bot.CqPluginLoadReslover;
import com.dasoops.dasserver.cq.bot.DefaultPluginLoadReslover;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title CqPluginGlobal
 * @classPath com.dasoops.dasserver.cq.CqPluginGlobal
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/06
 * @version 1.0.0
 * @description cqPluginGlobal
 */
@Slf4j
public class CqPluginGlobal {

    private static ApplicationContext applicationContext;

    /**
     * 插件集合
     * Map<className,CqPlugin>
     */
    private static Map<String, CqPlugin> pluginMap = new HashMap<>();


    /**
     * 默认解析器
     */
    private static CqPluginLoadReslover reslover = new DefaultPluginLoadReslover();

    public static Integer resloverOrder = 2147483647;

    public static void put(String className, CqPlugin cqPlugin) {
        pluginMap.put(className, cqPlugin);
    }

    public static void remove(String className) {
        pluginMap.remove(className);
    }

    public static void remove(CqPlugin cqPlugin) {
        pluginMap.remove(cqPlugin.getRawPlugin().getClass().getName());
    }

    public static void replace(Map<String, CqPlugin> pluginMap) {
        CqPluginGlobal.pluginMap = pluginMap;
    }

    public static void refresh() {
        log.info("重新加载插件");
        CqPluginGlobal.pluginMap = reslover.refresh(applicationContext);
        log.info("\n插件加载完成:\n\t-{}", CollectionUtil.join(pluginMap.keySet(), "\n\t-"));
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        CqPluginGlobal.applicationContext = applicationContext;
    }

    public static List<CqPlugin> getAll() {
        return pluginMap.values().stream().toList();
    }

    public static void setReslover(Integer orber, CqPluginLoadReslover reslover) {
        if (orber < resloverOrder) {
            CqPluginGlobal.reslover = reslover;
        }
    }

    public static CqPluginLoadReslover getReslover() {
        return reslover;
    }
}

package com.dasoops.dasserver.cq;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Title: CqPluginGlobal
 * @ClassPath com.dasoops.dasserver.cq.CqPluginGlobal
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/06
 * @Version 1.0.0
 * @Description: cqPluginGlobal
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
    public static CqPluginLoadReslover reslover = applicationContext ->
            applicationContext.getBeansOfType(CqPlugin.class).values().stream().collect(Collectors.toMap(cqPlugin -> cqPlugin.getClass().getName(), cqPlugin -> cqPlugin));

    public static Integer resloverOrder = 2147483647;

    /**
     * 插件加载解析器
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

    public static void put(String className, CqPlugin cqPlugin) {
        pluginMap.put(className, cqPlugin);
    }

    public static void remove(String className) {
        pluginMap.remove(className);
    }

    public static void remove(CqPlugin cqPlugin) {
        pluginMap.remove(cqPlugin.getClass().getName());
    }

    public static void replace(Map<String, CqPlugin> pluginMap) {
        CqPluginGlobal.pluginMap = pluginMap;
    }

    public static void refresh() {
        log.info("重新加载插件");
        CqPluginGlobal.pluginMap = reslover.refresh(applicationContext);
        log.info("\n插件加载完成:\n\t{}", CollectionUtil.join(pluginMap.values(), "\n\t-"));
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
}
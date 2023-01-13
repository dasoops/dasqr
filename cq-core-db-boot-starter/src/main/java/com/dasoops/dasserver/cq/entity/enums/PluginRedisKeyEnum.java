package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.dasoops.common.entity.enums.BaseRedisKeyEnum.SYS_PLUGIN;

/**
 * @Title: PluginRedisKeyEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.PluginRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 插件redisKey枚举
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
@Getter
public enum PluginRedisKeyEnum implements IRedisKeyEnum {
    /**
     * 插件calsspath - id映射
     * hash<classPath,id>
     */
    PLUGIN_CALSSPATH_OTO_ID(getBasePath() + "classPath_oto_id"),

    ;

    final String key;

    private static String getBasePath(){
        return SYS_PLUGIN.getKey();
    }
}

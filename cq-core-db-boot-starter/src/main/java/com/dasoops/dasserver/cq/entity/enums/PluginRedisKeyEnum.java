package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.dasoops.common.entity.enums.base.BaseRedisKeyEnum.SYS_PLUGIN;

/**
 * @title: PluginRedisKeyEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.PluginRedisKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/27
 * @version 1.0.0
 * @description 插件redisKey枚举
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

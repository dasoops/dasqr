package com.dasoops.common.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.dasoops.common.entity.enums.BaseRedisKeyEnum.PLUGIN;

/**
 * @Title: RedisKeyEnum
 * @ClassPath com.dasoops.dasq.general.entity.RedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: 复述, 关键枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum RedisKeyEnum implements IRedisKeyEnum {

    /**
     * 未加载插件
     */
    UN_LOAD_PLUGIN(getBasePath() + "un_load_plugin"),
    /**
     * 已加载插件
     */
    LOAD_PLUGIN(getBasePath() + "load_plugin");

    private static String getBasePath() {
        return PLUGIN.getKey();
    }

    /**
     * 描述
     */
    final String key;
}

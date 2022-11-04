package com.dasoops.core.entity.enums;

/**
 * @Title: IRedisKeyEnum
 * @ClassPath com.dasoops.dasserver.core.entity.enums.IRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: redisKeyEnum
 */
public interface IRedisKeyEnum {

    String CORE = "core:";
    String CORE_CONFIG = CORE + "config:";
    String CORE_EXCEPTION = CORE + "core:exception:";

    String PLUGIN = "plugin:";

    /**
     * 获取key
     *
     * @return {@link String}
     */
    String getKey();

}

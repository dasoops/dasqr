package com.dasoops.dasserver.cq.cache.enums;

/**
 * @Title: IRedisKey
 * @ClassPath com.dasoops.dasserver.cq.cache.enums.IRedisKey
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: redisKeyEnum
 */
public interface IRedisKey {

    String CORE = "core:";
    String CORE_CONFIG = CORE + "config:";
    String CORE_EXCEPTION = CORE + "core:exception:";

    String PLUGIN = "plugin:";


}

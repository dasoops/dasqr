package com.dasoops.common.entity.enums.base;

/**
 * @Title: IRedisHashKeyEnum
 * @ClassPath com.dasoops.common.entity.enums.base.IRedisHashKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/22
 * @Version 1.0.0
 * @Description: iredis哈希关键枚举
 */
public interface IRedisHashKeyEnum {

    /**
     * 获取redisHashKey
     *
     * @return {@link String}
     */
    String getKey();

}

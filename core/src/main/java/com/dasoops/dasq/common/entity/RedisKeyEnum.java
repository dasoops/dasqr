package com.dasoops.dasq.common.entity;

/**
 * @Title: RedisKeyEnum
 * @ClassPath com.dasoops.dasq.general.entity.RedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: 复述, 关键枚举
 * @see Enum
 */
public enum RedisKeyEnum {
    /**
     * 分隔符
     */
    SEPARATOR("_");

    /**
     * 描述
     */
    final String desc;

    RedisKeyEnum(String desc){
        this.desc = desc;
    }
}

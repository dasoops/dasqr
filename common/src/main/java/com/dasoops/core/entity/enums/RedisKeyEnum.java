package com.dasoops.core.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
public enum RedisKeyEnum implements IRedisKeyEnum{


    ;

    /**
     * 描述
     */
    final String key;
}

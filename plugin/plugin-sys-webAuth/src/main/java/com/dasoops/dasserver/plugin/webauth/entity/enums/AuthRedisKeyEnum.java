package com.dasoops.dasserver.plugin.webauth.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title AuthRedisKeyEnum
 * @classPath com.dasoops.dasserver.plugin.webauth.entity.enums.AuthRedisKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/15
 * @version 1.0.0
 * @description authRedisKey枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
@Getter
public enum AuthRedisKeyEnum implements IRedisKeyEnum {

    ;

    final String key;
}

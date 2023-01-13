package com.dasoops.dasserver.plugin.webauth.entity.enums;

import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: AuthRedisKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.webauth.entity.enums.AuthRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/15
 * @Version 1.0.0
 * @Description: authRedisKey枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
@Getter
public enum AuthRedisKeyEnum implements IRedisKeyEnum {

    ;

    final String key;
}

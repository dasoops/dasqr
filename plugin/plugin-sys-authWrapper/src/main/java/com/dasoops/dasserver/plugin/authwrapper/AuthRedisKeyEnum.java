package com.dasoops.dasserver.plugin.authwrapper;

import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: AuthRedisKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.AuthRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/15
 * @Version 1.0.0
 * @Description: authRedisKey枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
public enum AuthRedisKeyEnum implements IRedisKeyEnum {
    /**
     * 权限
     */
    AUTH(CORE_SYS_PLUGIN + "auth"),
    ;

    @Getter
    final String key;

}

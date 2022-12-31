package com.dasoops.dasserver.entity.enums;

import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.Getter;

/**
 * @Title: AuthRedisKeyShamEnum
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.entity.enums.AuthRedisKeyShamEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: auth模块redisKey(sham)
 * @see IRedisKeyEnum
 */
@Getter
public class AuthRedisKeyAuthListShamEnum implements IRedisKeyEnum {

    private final String key;

    public AuthRedisKeyAuthListShamEnum(Long registerId) {
        this.key = AuthRedisKeyEnum.AUTH +  registerId;
    }
}

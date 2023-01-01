package com.dasoops.dasserver.entity.enums;

import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.Getter;

import static com.dasoops.common.entity.enums.BaseRedisKeyEnum.AUTH;
import static com.dasoops.common.entity.enums.BaseRedisKeyEnum.REGISTER;

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
        this.key = AUTH.getKey() + registerId;
    }

    private static String getBasePath() {
        return REGISTER.getKey();
    }
}

package com.dasoops.dasserver.plugin.authwrapper.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.Getter;

import static com.dasoops.common.entity.enums.base.BaseRedisKeyEnum.AUTH;

/**
 * @title AuthRedisKeyShamEnum
 * @classPath com.dasoops.dasserver.plugin.authwrapper.entity.enums.AuthRedisKeyShamEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/27
 * @version 1.0.0
 * @description auth模块redisKey(sham)
 * @see IRedisKeyEnum
 */
@Getter
public class AuthRedisKeyAuthListShamEnum implements IRedisKeyEnum {

    private final String key;

    public AuthRedisKeyAuthListShamEnum(Long registerId) {
        this.key = getBasePath() + registerId;
    }

    public static String getBasePath() {
        return AUTH.getKey();
    }
}

package com.dasoops.dasserver.plugin.echo.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.Getter;

/**
 * @title EchoConfigRedisKeyShamEnum
 * @classPath com.dasoops.dasserver.plugin.cacheecho.entity.enums.EchoConfigRedisKeyShamEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/11
 * @version 1.0.0
 * @description 打印缓存数据
 * @see IRedisKeyEnum
 */
@Getter
public class RedisKeyShamEnum implements IRedisKeyEnum {
    private final String key;

    public RedisKeyShamEnum(String keyword) {
        this.key = keyword;
    }
}

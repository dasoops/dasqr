package com.dasoops.dasserver.plugin.echo.entity.enums;

import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.Getter;

/**
 * @Title: EchoConfigRedisKeyShamEnum
 * @ClassPath com.dasoops.dasserver.plugin.cacheecho.entity.enums.EchoConfigRedisKeyShamEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/11
 * @Version 1.0.0
 * @Description: 打印缓存数据
 * @see IRedisKeyEnum
 */
@Getter
public class RedisKeyShamEnum implements IRedisKeyEnum {
    private final String key;

    public RedisKeyShamEnum(String keyword) {
        this.key = keyword;
    }
}

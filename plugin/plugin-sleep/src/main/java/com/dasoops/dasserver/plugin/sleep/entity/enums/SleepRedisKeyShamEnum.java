package com.dasoops.dasserver.plugin.sleep.entity.enums;

import com.dasoops.common.entity.enums.base.BaseRedisKeyEnum;
import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.Getter;

/**
 * @title: SleepRedisKeyEnum
 * @classPath com.dasoops.dasserver.plugin.sleep.SleepRedisKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/10
 * @version 1.0.0
 * @description 睡眠redisKey枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@Getter
public class SleepRedisKeyShamEnum implements IRedisKeyEnum {

    final String key;

    public SleepRedisKeyShamEnum(String key) {
        this.key = key;
    }

    public static String getBasePath() {
        return BaseRedisKeyEnum.PLUGIN.getKey() + "sleep:";
    }

    public static SleepRedisKeyShamEnum group(Long groupId) {
        return new SleepRedisKeyShamEnum(getBasePath() + "group:" + groupId);
    }

    public static SleepRedisKeyShamEnum user(Long userId) {
        return new SleepRedisKeyShamEnum(getBasePath() + "user:" + userId);
    }

    public static SleepRedisKeyShamEnum build(boolean isGroup, Long userId) {
        return new SleepRedisKeyShamEnum(getBasePath() + (isGroup ? "group:" : "user:") + userId);
    }

}

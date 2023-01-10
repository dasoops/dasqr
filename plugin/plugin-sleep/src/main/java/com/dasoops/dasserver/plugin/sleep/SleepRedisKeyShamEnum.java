package com.dasoops.dasserver.plugin.sleep;

import com.dasoops.common.entity.enums.BaseRedisKeyEnum;
import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.Getter;

/**
 * @Title: SleepRedisKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.sleep.SleepRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 睡眠redisKey枚举
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

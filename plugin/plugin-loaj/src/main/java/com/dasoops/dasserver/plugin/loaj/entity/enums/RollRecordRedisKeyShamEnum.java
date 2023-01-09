package com.dasoops.dasserver.plugin.loaj.entity.enums;

import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.enums.BaseRedisKeyEnum;
import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.Getter;

/**
 * @Title: RollRecordRedisKeyShamEnum
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.enums.RollRecordRedisKeyShamEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/08
 * @Version 1.0.0
 * @Description: roll点记录redisKey枚举
 * @see IRedisKeyEnum
 */
@Getter
public class RollRecordRedisKeyShamEnum implements IRedisKeyEnum {

    private final String key;

    private RollRecordRedisKeyShamEnum(Long groupId) {
        this.key = StrUtil.format("{}{}:", getBasePath(), groupId);
    }

    private RollRecordRedisKeyShamEnum(Long groupId, Long userId) {
        this.key = StrUtil.format("{}{}:{}", getBasePath(), groupId, userId);
    }


    private static String getBasePath() {
        return BaseRedisKeyEnum.PLUGIN.getKey() + "roll:";
    }

    public static RollRecordRedisKeyShamEnum addRecord(Long groupId, Long userId) {
        return new RollRecordRedisKeyShamEnum(groupId, userId);
    }


    public static RollRecordRedisKeyShamEnum expirePrefix(Long groupId) {
        return new RollRecordRedisKeyShamEnum(groupId);
    }

    public static RollRecordRedisKeyShamEnum hasRecord(Long groupId) {
        return new RollRecordRedisKeyShamEnum(groupId);
    }

    public static RollRecordRedisKeyShamEnum getAllRecord(Long groupId) {
        return new RollRecordRedisKeyShamEnum(groupId);
    }

    public static RollRecordRedisKeyShamEnum removeAllGroupRecord(Long groupId) {
        return new RollRecordRedisKeyShamEnum(groupId);
    }
}
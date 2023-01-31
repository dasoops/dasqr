package com.dasoops.dasserver.plugin.loaj.entity.enums;

import com.dasoops.common.entity.enums.base.BaseRedisKeyEnum;
import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.Data;

/**
 * @Title: RepeatReadRedisKeyShamEnum
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.enums.RepeatReadRedisKeyShamEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/19
 * @Version 1.0.0
 * @Description: 复读redisKeySham枚举
 */
@Data
public class RepeatReadRedisKeyShamEnum implements IRedisKeyEnum {

    private final String key;

    public RepeatReadRedisKeyShamEnum(Long groupId) {
        this.key = BASE_PATH + groupId;
    }


    private static final String BASE_PATH = BaseRedisKeyEnum.PLUGIN.getKey() + "repeatRead:";
}

package com.dasoops.dasserver.plugin.loaj.entity.enums;

import com.dasoops.common.entity.enums.base.BaseRedisKeyEnum;
import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.Data;

/**
 * @title RepeatReadRedisKeyShamEnum
 * @classPath com.dasoops.dasserver.plugin.loaj.entity.enums.RepeatReadRedisKeyShamEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/19
 * @version 1.0.0
 * @description 复读redisKeySham枚举
 */
@Data
public class RepeatReadRedisKeyShamEnum implements IRedisKeyEnum {

    private final String key;

    public RepeatReadRedisKeyShamEnum(Long groupId) {
        this.key = BASE_PATH + groupId;
    }


    private static final String BASE_PATH = BaseRedisKeyEnum.PLUGIN.getKey() + "repeatRead:";
}

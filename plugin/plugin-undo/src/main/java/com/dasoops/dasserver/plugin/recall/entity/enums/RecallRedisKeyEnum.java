package com.dasoops.dasserver.plugin.recall.entity.enums;

import com.dasoops.common.entity.enums.base.BaseRedisKeyEnum;
import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: RecallRedisKeyEnum
 * @classPath com.dasoops.dasserver.plugin.recall.entity.enums.RecallRedisKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/31
 * @version 1.0.0
 * @description 撤回枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
@Getter
public enum RecallRedisKeyEnum implements IRedisKeyEnum {

    /**
     * 撤回记录(MessageId)
     */
    RECORD(getBasePath() + "record"),
    ;

    final String key;

    private static String getBasePath() {
        return BaseRedisKeyEnum.PLUGIN.getKey() + "recall:";
    }

}

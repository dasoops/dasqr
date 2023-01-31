package com.dasoops.dasserver.plugin.recall.entity.enums;

import com.dasoops.common.entity.enums.base.BaseRedisKeyEnum;
import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: RecallRedisKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.recall.entity.enums.RecallRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/31
 * @Version 1.0.0
 * @Description: 撤回枚举
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

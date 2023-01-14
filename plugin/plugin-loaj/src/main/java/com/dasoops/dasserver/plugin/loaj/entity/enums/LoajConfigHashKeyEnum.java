package com.dasoops.dasserver.plugin.loaj.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ConfigEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.ConfigEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 配置枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum LoajConfigHashKeyEnum implements IRedisHashKeyEnum {

    /**
     * roll点记录redis有效时间(秒)
     */
    ROLL_RECORD_EFFECTIVE_SECONDS("rollRecordEffectiveSeconds"),
    ROLL_NIGGER_SCORE("rollNiggerScore");

    final String key;
}

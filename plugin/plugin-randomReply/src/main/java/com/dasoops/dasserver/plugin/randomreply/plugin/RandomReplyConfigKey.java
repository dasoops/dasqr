package com.dasoops.dasserver.plugin.randomreply.plugin;

import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title RandamReplyConfigHashKey
 * @classPath com.dasoops.dasserver.plugin.randomreply.plugin.RandamReplyConfigHashKey
 * @date 2023/03/01
 * @description 随机回复 配置key
 * @see Enum
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
public enum RandomReplyConfigKey implements IRedisHashKeyEnum {

    /**
     * git通知类型
     */
    RANDOM_FREQUENCY("randomRelpyFrequency"),
    ;

    @Getter
    final String key;
}

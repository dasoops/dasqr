package com.dasoops.dasserver.plugin.randomreply.plugin;

import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.dasoops.common.entity.enums.base.BaseRedisKeyEnum.PLUGIN;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title RandomReplyCacheKey
 * @classPath com.dasoops.dasserver.plugin.randomreply.plugin.RandomReplyCacheKey
 * @date 2023/03/01
 * @description 随机回复缓存key
 * @see Enum
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
public enum RandomReplyCacheKey implements IRedisKeyEnum {

    /**
     * 上次回复信息
     */
    LAST_INFO(getBasePath() + "lastInfo");

    private static String getBasePath() {
        return PLUGIN + "randomReply:";
    }

    @Getter
    final String key;
}

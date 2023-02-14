package com.dasoops.dasserver.plugin.image.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.dasoops.common.entity.enums.base.BaseRedisKeyEnum.PLUGIN;


/**
 * @title: ImageRedisKeyEnum
 * @classPath com.dasoops.dasserver.plugin.image.entity.enums.ImageRedisKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/09
 * @version 1.0.0
 * @description 图片RedisKey枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
public enum ImageRedisKeyEnum implements IRedisKeyEnum {

    /**
     * 关键字集合
     */
    KEYWORD_LIST(getBasePath() + "image");

    @Getter
    final String key;

    private static String getBasePath() {
        return PLUGIN + "image:";
    }


}

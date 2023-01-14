package com.dasoops.dasserver.plugin.image.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.dasoops.common.entity.enums.base.BaseRedisKeyEnum.PLUGIN;


/**
 * @Title: ImageRedisKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.enums.ImageRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/09
 * @Version 1.0.0
 * @Description: 图片RedisKey枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
public enum ImageRedisKeyEnum implements IRedisKeyEnum {

    /**
     * 分片存图标记
     */
    PART_SAVE_IMAGE(getBasePath() + "partFlag:"),

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

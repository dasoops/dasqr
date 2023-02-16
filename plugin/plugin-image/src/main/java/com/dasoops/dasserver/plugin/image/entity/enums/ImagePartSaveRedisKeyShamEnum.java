package com.dasoops.dasserver.plugin.image.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.Getter;

import static com.dasoops.common.entity.enums.base.BaseRedisKeyEnum.PLUGIN;


/**
 * @title ImageRedisKeyEnum
 * @classPath com.dasoops.dasserver.plugin.image.entity.enums.ImageRedisKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/09
 * @version 1.0.0
 * @description 图片RedisKey枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@Getter
public class ImagePartSaveRedisKeyShamEnum implements IRedisKeyEnum {

    private final String key;

    ImagePartSaveRedisKeyShamEnum(boolean isUser, Long id) {
        if (isUser) {
            this.key = getBasePath() + "user:" + id;
        } else {
            this.key = getBasePath() + "group:" + id;
        }
    }

    public static ImagePartSaveRedisKeyShamEnum user(Long userId) {
        return new ImagePartSaveRedisKeyShamEnum(true, userId);
    }

    public static ImagePartSaveRedisKeyShamEnum group(Long groupId) {
        return new ImagePartSaveRedisKeyShamEnum(false, groupId);
    }

    private static String getBasePath() {
        return PLUGIN + "image:partSave:";
    }

}

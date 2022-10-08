package com.dasoops.dasq.core.image.entity.enums;

/**
 * @Title: ImageRedisKeyEnum
 * @ClassPath com.dasoops.dasq.image.entity.enums.ImageRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: image-redisKey枚举
 * @see Enum
 */
public enum ImageRedisKeyEnum {
    /**
     * 根据图片类型软编码获取图片类型json
     * Map<String,String>
     * Hash<innerCode,ImageJson>
     */
    IMAGE_INNER_CODE_GET_IMAGE_JSON("key_image_inner_code_get_image_Json"),

    /**
     * 根据图片类型id获取图片类型json
     * Map<Long,String>
     * Hash<id,ImageJson>
     */
    IMAGE_ID_GET_IMAGE_JSON("key_image_id_get_image_Json");

    /**
     * redisKey
     */
    private String redisKey;

    ImageRedisKeyEnum(String redisKey) {
        this.redisKey = redisKey;
    }
}

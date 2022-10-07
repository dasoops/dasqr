package com.dasoops.dasq.image.entity;

/**
 * @Title: ImageRedisKeyEnum
 * @ClassPath com.dasoops.dasq.image.entity.ImageRedisKeyEnum
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
     * Hash<InnerCode,ImageJson>
     */
    IMAGE_INNER_CODE_GET_IMAGE_JSON("key_image_inner_code_get_image_Json");

    /**
     * redisKey
     */
    private String RedisKey;

    ImageRedisKeyEnum(String redisKey) {
        RedisKey = redisKey;
    }
}

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
    TYPE_INNER_CODE_GET_ENTITY_JSON_MAP("image:type_inner_code_get_entity_json_hash"),

    /**
     * 根据图片类型id获取图片类型json
     * Map<String,String>
     * Hash<id,ImageJson>
     */
    TYPE_ID_GET_ENTITY_JSON_MAP("image:type_id_get_entity_Json_hash"),

    /**
     * 下条消息是否为分片存图 part2
     * String
     * String
     */
    SAVE_IMAGE_PART("image:save_image_part");

    /**
     * redisKey
     */
    final String redisKey;

    public String getRedisKey() {
        return redisKey;
    }

    ImageRedisKeyEnum(String redisKey) {
        this.redisKey = redisKey;
    }
}

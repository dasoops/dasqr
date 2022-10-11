package com.dasoops.dasq.core.cq.entity.enums;

/**
 * @Title: CqRedisKeyEnum
 * @ClassPath com.dasoops.dasq.cq.entity.enums.CqRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: cq-redisKey枚举
 * @see Enum
 */
public enum CqRedisKeyEnum {

    /**
     * 通过methodTypeId获取实体json对象
     * Map<String,String>
     * hash<id,MethodType>
     */
    METHOD_TYPE_ID_GET_ENTITY_JSON_MAP("key_cq_method_type_json_hash"),

    /**
     * 通过methodInfoId获取实体json对象
     * Map<String,String>
     * hash<id,MethodInfo>
     */
    METHOD_INFO_ID_GET_ENTITY_JSON_MAP("key_cq_method_info_id_get_entity_json_hash"),

    /**
     * 通过passObjectType获取实体jsonSet集合
     * Map<String>
     * Set<PassObject>
     */
    PASS_LIST_TYPE_GET_ENTITY_JSON_SET_MAP("key_cq_pass_list_type_get_entity_json_set_hash"),

    /**
     * 通过白名单关键词获取方法info id映射集合
     * Map<String,String>
     * Map<PassKeyword,MethodInfoId>
     */
    PASS_LIST_KEYWORD_GET_METHOD_INFO_ID_MAP("key_cq_pass_list_keyword_get_method_info_id_hash"),

    /**
     * 帮助文档
     */
    HELP_DOC_STRING("key_cq_help_doc_string"),

    ;


    /**
     * redisKey
     */
    final String redisKey;

    public String getRedisKey() {
        return redisKey;
    }

    CqRedisKeyEnum(String redisKey) {
        this.redisKey = redisKey;
    }

}

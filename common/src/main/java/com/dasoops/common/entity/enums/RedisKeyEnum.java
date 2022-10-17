package com.dasoops.common.entity.enums;

/**
 * @Title: RedisKeyEnum
 * @ClassPath com.dasoops.dasq.general.entity.RedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: 复述, 关键枚举
 * @see Enum
 */
public enum RedisKeyEnum {
    /**
     * 分隔符
     */
    SEPARATOR("_"),
    /**
     * 根据异常id(timeStamp)获取异常信息
     * Map<Long,String>
     * Hash<id,ImageJson>
     */
    ID_GET_EXCEPTION_INFO_JSON_MAP("core:id_get_exception_info_hash"),
    /**
     * 根据字典id获取子记录
     * Map<Long,Map<String,String>>
     * Hash<id,Map<dictCode,dictValue>>
     */
    DICT_ID_GET_CHILD_DICT_INFO_MAP_JSON_MAP("core:dict_id_get_child_dict_info_map_json_hash"),

    /**
     * dict编号得到idMap
     * Map<String,String>
     * Hash<dictCode,fatherId>
     */
    DICT_DICT_CODE_GET_FATHER_ID_HASH("core:dict_dict_code_get_father_id_hash"),

    /**
     * 版本号
     * String
     * version
     */
    VERSION("core:version"),


    ;

    /**
     * 描述
     */
    final String redisKey;

    public String getRedisKey() {
        return redisKey;
    }

    RedisKeyEnum(String redisKey) {
        this.redisKey = redisKey;
    }
}

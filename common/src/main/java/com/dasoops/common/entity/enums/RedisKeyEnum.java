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
    CORE_ID_GET_EXCEPTION_INFO_JSON("CORE_EXCEPTION_MAP")
    ;

    /**
     * 描述
     */
    final String desc;

    RedisKeyEnum(String desc){
        this.desc = desc;
    }
}

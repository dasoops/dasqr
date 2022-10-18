package com.dasoops.dasq.core.dq.methodstrategy.entity.enums;

/**
 * @Title: DqRedisKeyEnum
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.entity.enums.DqRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: dq方法枚举
 * @see Enum
 */
public enum DqRedisKeyEnum {

    /**
     * ROLL点
     * Map<id,point>
     * hash<string,string>
     */
    ROLL_ID_GET_POINT_MAP("dq:roll_id_get_point_hash"),

    /**
     * 复读消息
     * message
     * String
     */
    REREAD("dq:reread"),

    /**
     * 复读消息计数
     * count
     * String
     */
    REREAD_MESSAGE("message"),

    /**
     * 复读消息计数
     * count
     * String
     */
    REREAD_MESSAGE_COUNT("message_count"),

    /**
     * 指令风格
     */
    STYLE("dq:style"),


    ;

    final String redisKey;

    public String getRedisKey() {
        return redisKey;
    }

    DqRedisKeyEnum(String redisKey) {
        this.redisKey = redisKey;
    }
}

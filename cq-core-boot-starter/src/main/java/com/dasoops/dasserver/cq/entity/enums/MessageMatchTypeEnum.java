package com.dasoops.dasserver.cq.entity.enums;

/**
 * @Title: MatchTypeEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.MatchTypeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: 匹配类型枚举
 * @see Enum
 */
public enum MessageMatchTypeEnum {

    /**
     * 无
     */
    NONE,
    /**
     * 前缀
     */
    PREFIX,
    /**
     * 后缀
     */
    SUFFIX,
    /**
     * 相等
     */
    EQUAL,
    /**
     * 包含
     */
    CONTAIN,
    /**
     * 匹配所有
     */
    MATCH_ALL;

}

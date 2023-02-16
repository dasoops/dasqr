package com.dasoops.dasserver.cq.entity.enums;

/**
 * @title MatchTypeEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.MatchTypeEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/20
 * @version 1.0.0
 * @description 匹配类型枚举
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

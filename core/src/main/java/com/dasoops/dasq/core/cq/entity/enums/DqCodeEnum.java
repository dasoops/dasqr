package com.dasoops.dasq.core.cq.entity.enums;

/**
 * @Title: DqKeywordEnum
 * @ClassPath com.dasoops.dasq.core.cq.entity.enums.DqKeywordEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: dq关键词枚举
 */
public enum DqCodeEnum {

    /**
     * 消息类型
     */
    AUTHOR_TYPE("$authorType"),

    /**
     * 消息id
     */
    AUTHOR_ID("$authorId"),

    /**
     * 参数0
     */
    PARAM0("$param0"),

    /**
     * 参数1
     */
    PARAM1("$param1"),

    /**
     * 参数2
     */
    PARAM2("$param2"),

    /**
     * 参数3
     */
    PARAM3("$param3"),

    /**
     * 参数4
     */
    PARAM4("$param4"),

    /**
     * 参数5
     */
    PARAM5("$param5"),

    /**
     * 参数6
     */
    PARAM6("$param6"),

    /**
     * 参数7
     */
    PARAM7("$param7"),

    /**
     * 参数8
     */
    PARAM8("$param8"),

    /**
     * 参数9
     */
    PARAM9("$param9"),

    /**
     * 参数10
     */
    PARAM10("$param10"),

    ;

    final String dqCode;

    public String getDqCode() {
        return dqCode;
    }

    DqCodeEnum(String dqCode) {
        this.dqCode = dqCode;
    }
}

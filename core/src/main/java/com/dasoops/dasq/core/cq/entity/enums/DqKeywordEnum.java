package com.dasoops.dasq.core.cq.entity.enums;

/**
 * @Title: DqKeywordEnum
 * @ClassPath com.dasoops.dasq.core.cq.entity.enums.DqKeywordEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: dq关键词枚举
 */
public enum DqKeywordEnum {

    /**
     * 消息类型
     */
    AUTHOR_TYPE("$authorType"),

    /**
     * 消息id
     */
    AUTHOR_ID("$authorId"),


    ;

    final String dqCode;

    public String getDqCode() {
        return dqCode;
    }

    DqKeywordEnum(String dqCode) {
        this.dqCode = dqCode;
    }
}

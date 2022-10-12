package com.dasoops.dasq.core.common.entity.enums;

/**
 * @Title: KeywordEnum
 * @ClassPath com.dasoops.dasq.core.common.entity.enums.KeywordEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: 关键字枚举
 * @see Enum
 */
public enum KeywordEnum {

    /**
     * 清爽风格
     */
    STYLE_COOL("cool"),

    /**
     * 正常风格
     */
    STYLE_NORMAL("normal"),

    ;

    final String keyword;

    public String getKeyword() {
        return keyword;
    }

    KeywordEnum(String keyword) {
        this.keyword = keyword;
    }
}

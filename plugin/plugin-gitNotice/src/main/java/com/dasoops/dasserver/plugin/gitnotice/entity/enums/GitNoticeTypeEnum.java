package com.dasoops.dasserver.plugin.gitnotice.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: gitNoticeTypeEnum
 * @ClassPath com.dasoops.dasserver.plugin.gitnotice.entity.enums.gitNoticeTypeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: git消息上报类型
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum GitNoticeTypeEnum {
    /**
     * 使用dev开发组配置 群内at用户
     */
    CORE_GROUP_AT_USER("coreGroupAtUser"),
    CORE_GROUP("coreGroup"),
    CORE_PRIVATE("corePrivate"),
    GROUP_AT_USER("groupAtUser"),
    GROUP("group"),
    PRIVATE("private"),
    NONE("none"),

    ;

    private final String keyword;
}

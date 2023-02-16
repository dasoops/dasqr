package com.dasoops.dasserver.plugin.gitnotice.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title gitNoticeTypeEnum
 * @classPath com.dasoops.dasserver.plugin.gitnotice.entity.enums.gitNoticeTypeEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/03
 * @version 1.0.0
 * @description git消息上报类型
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum GitNoticeTypeEnum implements IDbColumnEnum {

    /**
     * 不提醒
     */
    NONE(0),
    /**
     * 私聊
     */
    PRIVATE(1),
    /**
     * 群组
     */
    GROUP(2),
    /**
     * 群at用户
     */
    GROUP_AT_USER(3),
    ;

    private final Integer dbValue;
}

package com.dasoops.dasserver.plugin.gitnotice.entity.enums;

import com.dasoops.common.entity.enums.IDbColumnEnum;
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

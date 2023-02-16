package com.dasoops.dasserver.plugin.alasnotice.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title AlasNoticeTypeEnum
 * @classPath com.dasoops.dasserver.plugin.template.entity.enums.AlasNoticeTypeEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/11
 * @version 1.0.0
 * @description alas通知类型枚举类型
 */
@AllArgsConstructor
@Getter
public enum AlasNoticeTypeEnum implements IDbColumnEnum {

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

    final Integer dbValue;

}

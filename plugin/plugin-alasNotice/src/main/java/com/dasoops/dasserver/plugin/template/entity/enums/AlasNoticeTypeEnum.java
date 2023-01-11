package com.dasoops.dasserver.plugin.template.entity.enums;

import com.dasoops.common.entity.enums.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: AlasNoticeTypeEnum
 * @ClassPath com.dasoops.dasserver.plugin.template.entity.enums.AlasNoticeTypeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/11
 * @Version 1.0.0
 * @Description: alas通知类型枚举类型
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

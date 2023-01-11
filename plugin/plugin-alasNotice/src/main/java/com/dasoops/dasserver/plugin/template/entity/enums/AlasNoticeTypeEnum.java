package com.dasoops.dasserver.plugin.template.entity.enums;

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
public enum AlasNoticeTypeEnum {

    /**
     * 私聊
     */
    PRIVATE(0),
    /**
     * 群组
     */
    GROUP(1),
    /**
     * 群at用户
     */
    GROUP_AT_USER(2),
    ;

    final Integer dbValue;

}

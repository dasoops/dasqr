package com.dasoops.dasserver.plugin.template.entity.enums;

import com.dasoops.common.entity.enums.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: AlasConfigHashKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.template.entity.enums.AlasConfigHashKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/11
 * @Version 1.0.0
 * @Description: alas配置hashKey枚举
 * @see Enum
 * @see IRedisHashKeyEnum
 */
@AllArgsConstructor
@Getter
public enum AlasConfigHashKeyEnum implements IRedisHashKeyEnum {

    /**
     * alas通知类型
     */
    ALAS_NOTICE_TYPE("alasNoticeType"),
    /**
     * alas通知群组
     */
    ALAS_NOTICE_GROUP("alasNoticeGroup"),
    /**
     * alas通知用户
     */
    ALAS_NOTICE_USER("alasNoticeUser"),
    ;

    final String key;
}

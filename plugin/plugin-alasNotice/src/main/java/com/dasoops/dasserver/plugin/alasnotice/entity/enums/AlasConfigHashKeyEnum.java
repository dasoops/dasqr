package com.dasoops.dasserver.plugin.alasnotice.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title AlasConfigHashKeyEnum
 * @classPath com.dasoops.dasserver.plugin.template.entity.enums.AlasConfigHashKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/11
 * @version 1.0.0
 * @description alas配置hashKey枚举
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

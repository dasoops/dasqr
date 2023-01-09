package com.dasoops.dasserver.plugin.loaj.entity.enums;

import com.dasoops.common.entity.enums.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ReplyMatchTypeEnum
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyMatchTypeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: 回复匹配类型枚举
 * @see IDbColumnEnum
 */
@Getter
@AllArgsConstructor
public enum ReplyMatchTypeEnum implements IDbColumnEnum {

    /**
     * 全局匹配
     */
    ALL(0),
    /**
     * 前缀匹配
     */
    PREFIX(1),
    /**
     * 后缀匹配
     */
    SUFFIX(2),
    /**
     * 包含匹配
     */
    CONTAINS(3),
    ;


    final Integer dbValue;

}

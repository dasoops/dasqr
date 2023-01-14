package com.dasoops.dasserver.plugin.loaj.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ReplyMatchTypeEnum
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyMatchTypeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: 忽略大小写类型枚举
 * @see IDbColumnEnum
 */
@Getter
@AllArgsConstructor
public enum ReplyIgnoreCaseEnum implements IDbColumnEnum {

    /**
     * 不忽略
     */
    FALSE(0),
    /**
     * 忽略
     */
    TRUE(1),
    ;


    final Integer dbValue;

}

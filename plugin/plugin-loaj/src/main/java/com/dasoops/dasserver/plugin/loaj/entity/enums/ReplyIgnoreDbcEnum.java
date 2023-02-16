package com.dasoops.dasserver.plugin.loaj.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title ReplyMatchTypeEnum
 * @classPath com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyMatchTypeEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/09
 * @version 1.0.0
 * @description 忽略全半角类型枚举
 * @see IDbColumnEnum
 */
@Getter
@AllArgsConstructor
public enum ReplyIgnoreDbcEnum implements IDbColumnEnum {

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

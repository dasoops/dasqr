package com.dasoops.dasserver.plugin.image.entity.enums;


import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title ImageCanEditEnum
 * @classPath com.dasoops.dasserver.plugin.image.entity.enums.ImageCanEditEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/02
 * @version 1.0.0
 * @description 图片是否可以编辑枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum ImageCanEditEnum implements IDbColumnEnum {
    /**
     * 否
     */
    FALSE(0),
    /**
     * 是
     */
    TRUE(1),
    ;

    final Integer dbValue;
}

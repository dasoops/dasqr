package com.dasoops.dasserver.cq.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title RegisterMtmPluginIsPassEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.RegisterMtmPluginIsPassEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/27
 * @version 1.0.0
 * @description 注册mtm插件 是否通过属性 枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum RegisterMtmPluginIsPassEnum {

    /**
     * 否;拦截
     */
    FALSE(0),
    /**
     * 是;放行
     */
    TRUE(1),
    ;

    final Integer dbValue;

}

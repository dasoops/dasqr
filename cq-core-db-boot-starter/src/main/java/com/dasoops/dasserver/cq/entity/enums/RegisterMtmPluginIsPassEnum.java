package com.dasoops.dasserver.cq.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: RegisterMtmPluginIsPassEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.RegisterMtmPluginIsPassEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 注册mtm插件 是否通过属性 枚举
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

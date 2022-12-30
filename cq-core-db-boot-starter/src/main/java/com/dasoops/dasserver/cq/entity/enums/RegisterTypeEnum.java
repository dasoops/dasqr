package com.dasoops.dasserver.cq.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: RegisterTypeEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.RegisterTypeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 注册用户枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum RegisterTypeEnum {

    /**
     * 用户
     */
    USER(0),
    /**
     * 群聊
     */
    GROUP(1),

    ;

    final Integer dbValue;

}

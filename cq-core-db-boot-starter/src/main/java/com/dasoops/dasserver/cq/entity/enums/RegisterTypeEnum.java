package com.dasoops.dasserver.cq.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title RegisterTypeEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.RegisterTypeEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/27
 * @version 1.0.0
 * @description 注册用户枚举
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

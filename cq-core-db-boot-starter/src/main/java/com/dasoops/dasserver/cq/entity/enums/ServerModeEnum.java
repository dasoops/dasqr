package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ServerModeEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.ServerModeEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/17
 * @Version 1.0.0
 * @Description: 服务器模式枚举
 * @see Enum
 */
@AllArgsConstructor
@Getter
public enum ServerModeEnum implements IDbColumnEnum {
    /**
     * 生产
     */
    PROD(0),
    /**
     * 开发
     */
    DEV(1),
    ;

    final Integer dbValue;

}

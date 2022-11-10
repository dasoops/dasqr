package com.dasoops.dasserver.cq.entity.enums;

import lombok.Getter;

/**
 * @Title: ConfigEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.ConfigEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 配置枚举
 * @see Enum
 */
public enum ConfigEnum {

    //版本
    VERSION("version"),
    //本地运行版本
    LOCAL_VERSION("localVersion"),

    ;

    @Getter
    final String key;

    ConfigEnum(String key) {
        this.key = key;
    }
}

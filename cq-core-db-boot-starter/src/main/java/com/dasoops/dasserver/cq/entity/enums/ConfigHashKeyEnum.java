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
public enum ConfigHashKeyEnum {

    /**
     * 版本
     */
    VERSION("cloudVersion"),
    /**
     * 本地运行版本
     */
    LOCAL_VERSION("localVersion"),
    /**
     * 默认权限等级
     */
    DEFAULT_USER_LEVEL("defaultUserLevel"),
    /**
     * 默认群组权限等级
     */
    DEFAULT_GROUP_LEVEL("defaultGroupLevel"),

    /**
     * 登录webManager所需的最低level
     */
    LOGIN_NEED_MIN_LEVEL("loginNeedMinLevel");

    @Getter
    final String key;

    ConfigHashKeyEnum(String key) {
        this.key = key;
    }
}

package com.dasoops.dasserver.cq.cache.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ConfigKeyEnum
 * @ClassPath com.dasoops.dasserver.cq.cache.enums.ConfigKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: 缓存配置key枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum ConfigKeyEnum implements IRedisKey {

    /**
     * 本地版本号
     */
    LOCAL_VERSION(CORE_CONFIG + "localVersion"),

    ;

    final String key;

}

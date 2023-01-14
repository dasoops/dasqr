package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.base.BaseRedisKeyEnum;
import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ConfigKeyEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.ConfigKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: 缓存配置key枚举
 * @see Enum
 */
@Getter
@AllArgsConstructor
public enum ConfigKeyEnum implements IRedisKeyEnum {
    /**
     * config Hash<keyword,value>
     */
    CONFIG(BaseRedisKeyEnum.CONFIG.getKey() + "main"),
    /**
     * 本地版本号
     */
//    LOCAL_VERSION(IRedisKeyEnum.CONFIG + "localVersion"),

    ;

    final String key;

}

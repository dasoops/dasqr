package com.dasoops.dasserver.plugin.reboot.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: RebootConfigHashKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.reboot.entity.enums.RebootConfigHashKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/13
 * @Version 1.0.0
 * @Description: 重新启动配置hashKeyenum
 * @see Enum
 * @see IRedisHashKeyEnum
 */
@AllArgsConstructor
@Getter
public enum RebootConfigHashKeyEnum implements IRedisHashKeyEnum {

    /**
     * 静默启动
     */
    QUIET_BOOT("quietBoot"),
    /**
     * 静默重启
     */
    QUIET_REBOOT("quietReboot"),
    ;

    final String key;
}

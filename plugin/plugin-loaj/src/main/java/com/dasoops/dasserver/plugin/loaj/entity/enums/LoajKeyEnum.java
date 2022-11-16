package com.dasoops.dasserver.plugin.loaj.entity.enums;

import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: RedinKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.enums.RedinKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/04
 * @Version 1.0.0
 * @Description: redinKeyenum
 */
@AllArgsConstructor
@Getter
public enum LoajKeyEnum implements IRedisKeyEnum {

    /**
     * 本地版本号
     */
    ROLL(PLUGIN + "loaj:" + "roll"),


    REPLY(PLUGIN + "loaj:" + "reply");

    final String key;
}
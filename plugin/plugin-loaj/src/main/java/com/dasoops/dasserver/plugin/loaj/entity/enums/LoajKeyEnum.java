package com.dasoops.dasserver.plugin.loaj.entity.enums;

import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.dasoops.common.entity.enums.BaseRedisKeyEnum.PLUGIN;

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
    ROLL(getBasePath() + "roll"),


    REPLY(getBasePath() + "reply");

    final String key;

    private static String getBasePath() {
        return PLUGIN.getKey() + "loaj";
    }
}
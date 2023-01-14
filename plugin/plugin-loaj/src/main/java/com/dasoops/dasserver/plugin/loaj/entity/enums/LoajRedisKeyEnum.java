package com.dasoops.dasserver.plugin.loaj.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.dasoops.common.entity.enums.base.BaseRedisKeyEnum.PLUGIN;

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
public enum LoajRedisKeyEnum implements IRedisKeyEnum {
    /**
     * 触发关键词 单对单 回复语句
     */
    REPLY_KEYWORD_OTO_REPLY_SET(getBasePath() + "reply_keyword_oto_reply");

    final String key;

    private static String getBasePath() {
        return PLUGIN.getKey() + "loaj:";
    }
}
package com.dasoops.dasserver.plugin.loaj.utils;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ReplyRedisValueDto;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyMatchTypeEnum;

/**
 * @title: MatchUtil
 * @classPath com.dasoops.dasserver.plugin.loaj.utils.MatchUtil
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/09
 * @version 1.0.0
 * @description 匹配工具
 */
public class MatchUtil {

    public static boolean match(ReplyMatchTypeEnum typeEnum, String message, String keyword, boolean ignoreCase, boolean ignoreDbc) {
        if (ignoreDbc) {
            message = Convert.toDBC(message);
            keyword = Convert.toDBC(keyword);
        }
        switch (typeEnum) {
            case ALL -> {
                return StrUtil.equals(message, keyword, ignoreCase);
            }
            case PREFIX -> {
                return StrUtil.startWith(message, keyword, ignoreCase);
            }
            case SUFFIX -> {
                return StrUtil.endWith(message, keyword, ignoreCase);
            }
            case CONTAINS -> {
                if (ignoreCase) {
                    return StrUtil.contains(message, keyword);
                } else {
                    return StrUtil.containsIgnoreCase(message, keyword);
                }
            }
        }
        return true;
    }

    public static boolean match(String message, ReplyRedisValueDto dto) {
        return match(EnumUtil.getBy(ReplyMatchTypeEnum::getDbValue, dto.getMatchType()), message, dto.getKeyword(), dto.getIgnoreCase(), dto.getIgnoreDbc());
    }

}

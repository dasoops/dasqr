package com.dasoops.dasq.core.cq.util;

import cn.hutool.core.util.StrUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @Title: CqKeywordUtil
 * @ClassPath com.dasoops.dasq.core.cq.util.CqKeywordUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: cq关键词跑龙套
 */
public class CqKeywordUtil {

    /**
     * 得到最匹配关键字
     *
     * @param message     消息
     * @param keywordList 关键字列表
     * @return {@link Optional}<{@link String}>
     */
    public static Optional<String> getMatchKeyword(String message, List<String> keywordList) {
        String realMessage = StrUtil.removePrefix(message, CqKeywordEnum.COMMON_PREFIX.getSimpleName());
        //获取匹配项,取最长的
        return keywordList.stream()
                .filter(keyword -> StrUtil.startWithIgnoreCase(realMessage, keyword))
                .max(Comparator.comparingInt(String::length));
    }


}

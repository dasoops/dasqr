package com.dasoops.dasq.core.common.util;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;

import java.util.*;

/**
 * @Title: CqKeywordUtil
 * @ClassPath com.dasoops.dasq.core.common.util.CqKeywordUtil
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

    /**
     * 构建cqCode
     * [CQ:image,file=2ff80946e012cacaf0c7e7d0ff7bba28.image,subType=0,url=https://gchat.qpic.cn/gchatpic_new/776465218/673745932-2559226010-2FF80946E012CACAF0C7E7D0FF7BBA28/0?term=3]
     *
     * @param type     类型
     * @param paramMap 参数映射
     * @return {@link String}
     */
    public static String buildCqCode(String type, Map<String, String> paramMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("[CQ:");
        sb.append(type);
        paramMap.forEach((key, value) -> {
            sb.append(",");
            sb.append(key);
            sb.append("=");
            sb.append(value);
        });
        sb.append("]");
        return sb.toString();
    }

    /**
     * 构建imageCqCode
     *
     * @param url url
     * @return {@link String}
     */
    public static String buildImageCqCode(String url) {
        return buildCqCode("image", Map.of("url", url, "file", RandomUtil.randomNumbers(10) + ".image"));
    }


}

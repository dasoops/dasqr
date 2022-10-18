package com.dasoops.dasq.core.common.util;

import cn.hutool.core.util.RandomUtil;

import java.util.Map;

/**
 * @Title: CqCodeUtil
 * @ClassPath com.dasoops.dasq.core.common.util.CqCodeUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/18
 * @Version 1.0.0
 * @Description: cqCodeUtil
 */
public class CqCodeUtil {
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


    /**
     * 构建atCqCode
     *
     * @param id id
     * @return {@link String}
     */
    public static String buildAtCqCode(String id) {
        return buildCqCode("at", Map.of("qq", id));
    }

}

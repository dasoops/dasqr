package com.dasoops.dasq.core.cq.util;

import cn.hutool.core.util.StrUtil;

import java.util.List;

/**
 * @Title: CqMethodUtil
 * @ClassPath com.dasoops.dasq.core.cq.util.CqMethodUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: cq Method Util
 */
public class CqMethodUtil {

    public static List<String> getParameterMap(String parameterStr) {

        //去除前后缀
        parameterStr = StrUtil.removePrefix(parameterStr, "{");
        parameterStr = StrUtil.removeSuffix(parameterStr, "}");


        return StrUtil.split(parameterStr, ",");


    }

}

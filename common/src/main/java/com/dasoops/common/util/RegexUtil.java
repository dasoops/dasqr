package com.dasoops.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: regexUtil
 * @ClassPath com.dasoops.dasq.core.common.util.regexUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/11
 * @Version 1.0.0
 * @Description: 正则工具
 */
public class RegexUtil {

    public static String getMatchStr(String rex, String str) {
        String matchStr = null;
        Matcher matcher = Pattern.compile(rex).matcher(str);
        while (matcher.find()) {
            matchStr = matcher.group();
        }
        return matchStr;
    }

    public static boolean isMatch(String rex, String str) {
        Matcher matcher = Pattern.compile(rex).matcher(str);
        return matcher.find();
    }

}

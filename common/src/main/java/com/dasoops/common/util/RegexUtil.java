package com.dasoops.common.util;

import java.util.Optional;
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

    public static Optional<String> getMatchStr(String rex, String str) {
        String matchStr = null;
        Matcher m = Pattern.compile(rex).matcher(str);
        while (m.find()) {
            matchStr = m.group();
        }
        return Optional.ofNullable(matchStr);
    }

}

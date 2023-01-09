package com.dasoops.common.util;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Title: UrlUtil
 * @ClassPath com.dasoops.common.util.UrlUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/06
 * @Version 1.0.0
 * @Description: url工具
 */
public class UrlUtil {

    /**
     * URL 前缀表示文件: "file:"
     */
    public static final String FILE_URL_PREFIX = "file:";
    /**
     * URL 前缀表示jar: "jar:"
     */
    public static final String JAR_URL_PREFIX = "jar:";

    public static URL filePathToUrl(String filePath) throws MalformedURLException {
        return new URL(FILE_URL_PREFIX + filePath);
    }

}

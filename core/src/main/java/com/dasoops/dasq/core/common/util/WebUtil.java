package com.dasoops.dasq.core.common.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.stream.StreamUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @Title: WebUtil
 * @ClassPath com.dasoops.dasq.core.common.util.WebUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: web工具
 */
public final class WebUtil {

    /**
     * 获取requestJson参数对象
     *
     * @param request 请求
     * @return {@link JSONObject}
     * @throws IOException ioexception
     */
    public static JSONObject getParameters(HttpServletRequest request) throws IOException {
        return JSONObject.parseObject(getJsonStr(request));
    }

    /**
     * 获取requestJson参数对象
     *
     * @param request 请求
     * @return {@link JSONObject}
     * @throws IOException ioexception
     */
    public static <T> T getParameters(HttpServletRequest request, Class<T> clazz) throws IOException {
        return JSON.parseObject(getJsonStr(request), clazz);
    }

    /**
     * 得到jsonstr
     *
     * @param request 请求
     * @return {@link String}
     * @throws IOException ioexception
     */
    public static String getJsonStr(HttpServletRequest request) throws IOException {

        BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
        return responseStrBuilder.toString();
    }


}

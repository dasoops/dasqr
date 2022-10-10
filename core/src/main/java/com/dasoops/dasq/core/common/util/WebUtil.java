package com.dasoops.dasq.core.common.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.stream.StreamUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

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

    /**
     * 拼接参数地址
     * 麻烦死了你妈的
     *
     * @param baseUrl  基url
     * @param paramMap 参数映射
     * @return {@link String}
     */
    public static String getParametersUrl(String baseUrl, Map<String, String> paramMap) {
        StringBuilder sb = new StringBuilder(baseUrl + CqKeywordEnum.URL_PARAMETER_PREFIX.getSimpleName());
        for (Map.Entry<String, String> res : paramMap.entrySet()) {
            sb.append(res.getKey());
            sb.append(CqKeywordEnum.URL_PARAMETER_KEY_VALUE_SEPARATOR.getSimpleName());
            sb.append(CqKeywordEnum.URL_PARAMETER_VALUE_PREFIX.getSimpleName());
            sb.append(res.getKey());
            sb.append(CqKeywordEnum.URL_PARAMETER_VALUE_SUFFIX.getSimpleName());
            sb.append(CqKeywordEnum.URL_PARAMETER_SEPARATOR.getSimpleName());
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 得到认证后httpEntity
     *
     * @return {@link HttpEntity}<{@link Object}>
     */
    public static HttpEntity<Object> getAuthHttpEntity(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        return new HttpEntity<>(headers);
    }
}

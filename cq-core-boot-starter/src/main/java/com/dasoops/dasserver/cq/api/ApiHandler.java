package com.dasoops.dasserver.cq.api;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.common.exception.AbstractBaseCustomException;
import com.dasoops.dasserver.cq.conf.properties.WsProperties;
import com.dasoops.dasserver.cq.entity.enums.ApiEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @title ApiHeader
 * @classPath com.dasoops.dasserver.cq.bot.ApiHeader
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description api处理类
 */
@Slf4j
public class ApiHandler {

    /**
     * 用于消息返回结果获取
     */
    private final Map<String, ApiSender> callBackMap = new HashMap<>(16);

    private final WsProperties wsProperties;

    public ApiHandler(WsProperties wsProperties) {
        this.wsProperties = wsProperties;
    }

    /**
     * 接收到已发送api请求的反馈
     *
     * @param responseJson json响应
     * @return {@link JSONObject}
     */
    public void onReceiveApiMessage(JSONObject responseJson) {
        //获取回音
        String echo = getEcho(responseJson);
        //获取调用的apiSender对象
        ApiSender apiSender = callBackMap.get(echo);
        //移除对象
        callBackMap.remove(echo);
        //响应数据
        apiSender.onReceive(responseJson);
    }

    /**
     * @param botSession botSession
     * @param apiEnum    api枚举
     * @param params     参数
     * @return {@link JSONObject}
     * @throws IOException          IoException
     * @throws InterruptedException 中断异常
     */
    public JSONObject sendApiMessage(WebSocketSession botSession, ApiEnum apiEnum, JSONObject params) {
        ApiSender apiSender = new ApiSender(botSession, wsProperties.getApiTimeout());
        //构建请求参数
        JSONObject apiJson = buildRequestJson(apiEnum, params);
        //以回音为key存入callBackMap
        String echo = getEcho(apiJson);
        callBackMap.put(echo, apiSender);
        //发起请求
        JSONObject responseJson;
        try {
            responseJson = apiSender.sendApiJson(apiJson);
        } catch (Exception e) {
            responseJson = buildErrorResponseJson(e);
        }
        return responseJson;
    }

    /**
     * 发送cusmon api消息
     *
     * @param botSession botSession
     * @param apiRequest api请求
     * @return {@link JSONObject}
     * @throws IOException          IoException
     * @throws InterruptedException 中断异常
     */
    public JSONObject sendCusmonApiMessage(WebSocketSession botSession, IApiRequest apiRequest) throws IOException, InterruptedException {
        ApiSender apiSender = new ApiSender(botSession, wsProperties.getApiTimeout());
        //构建请求参数
        JSONObject apiJson = buildRequestJson(apiRequest);
        //以回音为key存入callBackMap
        String echo = getEcho(apiJson);
        callBackMap.put(echo, apiSender);
        //发起请求
        JSONObject responseJson;
        try {
            responseJson = apiSender.sendApiJson(apiJson);
        } catch (Exception e) {
            responseJson = buildErrorResponseJson(e);
        }
        return responseJson;
    }

    /**
     * 构建json请求参数
     *
     * @param apiRequest api请求
     * @return {@link JSONObject}
     */
    private JSONObject buildRequestJson(IApiRequest apiRequest) {
        JSONObject apiJson = new JSONObject();
        apiJson.put("action", apiRequest.getUrl());
        apiJson.put("echo", IdUtil.fastSimpleUUID());
        if (!apiRequest.getParams().isEmpty()) {
            apiJson.put("params", apiRequest.getParams());
        }
        return apiJson;
    }

    /**
     * 构建json请求参数
     *
     * @param apiEnum api枚举
     * @param params  参数
     * @return {@link JSONObject}
     */
    private JSONObject buildRequestJson(ApiEnum apiEnum, JSONObject params) {
        JSONObject apiJson = new JSONObject();
        apiJson.put("action", apiEnum.getUrl());
        apiJson.put("echo", IdUtil.fastSimpleUUID());
        if (params != null && !params.isEmpty()) {
            apiJson.put("params", params);
        }
        return apiJson;
    }

    /**
     * 构建错误响应json
     *
     * @param e e
     * @return {@link JSONObject}
     */
    private JSONObject buildErrorResponseJson(Exception e) {
        JSONObject responseJson = new JSONObject();
        responseJson.put("status", "failed");
        responseJson.put("retcode", "-1");
        if (e instanceof AbstractBaseCustomException) {
            responseJson.put("msg", ((AbstractBaseCustomException) e).getStackMessage());
        } else {
            responseJson.put("msg", e);
        }
        responseJson.put("wording", ExceptionUtil.stacktraceToString(e));
        return responseJson;
    }

    /**
     * 得到回音
     *
     * @param apiJson json参数
     * @return {@link String}
     */
    private String getEcho(JSONObject apiJson) {
        return apiJson.getString("echo");
    }


}

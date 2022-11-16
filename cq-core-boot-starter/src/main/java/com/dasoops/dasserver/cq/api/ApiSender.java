package com.dasoops.dasserver.cq.api;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.common.exception.BaseCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * @Title: ApiSender
 * @ClassPath com.dasoops.dasserver.cq.api.ApiSender
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: api发送对象 webSocket消息并不是同http协议一样一来一回,所以需要手动来根据标识符判断消息,获取消息返回值
 */
@Slf4j
public class ApiSender {

    private final WebSocketSession apiSession;
    private final Long apiTimeout;
    private JSONObject responseJson;

    public ApiSender(WebSocketSession apiSession, Long apiTimeout) {
        this.apiSession = apiSession;
        this.apiTimeout = apiTimeout;
    }

    /**
     * 向API发送json
     *
     * @param apiJson 调用json
     * @return {@link JSONObject}
     * @throws IOException          IOException
     * @throws InterruptedException 线程异常
     */
    JSONObject sendApiJson(JSONObject apiJson) throws IOException, InterruptedException {
        //保证一个session同时只被一个线程调用
        synchronized (apiSession) {
            log.debug("sendApiMessage: {}", apiJson.toString());
            apiSession.sendMessage(new TextMessage(apiJson.toJSONString()));
        }
        //阻塞对象,等待唤醒再返回数据
        synchronized (this) {
            this.wait(apiTimeout);
        }
        if (responseJson == null){
            JSONObject responseJson = new JSONObject();
            responseJson.put("status", "failed");
            responseJson.put("retcode", "-1");
            return responseJson;
        }
        return responseJson;
    }

    /**
     * 接收API返回消息
     *
     * @param responseJson json响应
     */
    void onReceive(JSONObject responseJson) {
        this.responseJson = responseJson;
        //唤醒线程
        synchronized (this) {
            this.notify();
        }
    }

}

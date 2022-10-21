package com.dasoops.cq.websocket;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @Title: websocketHandler
 * @ClassPath com.dasoops.cq.websocket.websocketHandler
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: websocket处理程序
 * @see WebSocketHandler
 */
@Slf4j
public class WebsocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        WsSessionManager.add("aoe",session);
        log.info(JSON.toJSONString(session));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info(JSON.toJSONString(session));
        log.info(JSON.toJSONString(closeStatus));
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info(JSON.toJSONString(session));
        log.info(JSON.toJSONString(message));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info(JSON.toJSONString(exception));
        log.info(JSON.toJSONString(session));
    }

    public WebsocketHandler() {
        log.info("aoe");
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        log.info("aoe");
    }
}

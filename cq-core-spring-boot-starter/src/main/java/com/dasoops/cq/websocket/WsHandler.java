package com.dasoops.cq.websocket;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.cq.CqGlobal;
import com.dasoops.cq.bot.ApiHandler;
import com.dasoops.cq.bot.CqFactory;
import com.dasoops.cq.bot.CqTemplate;
import com.dasoops.cq.bot.EventHandler;
import com.dasoops.cq.conf.properties.EventProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Objects;
import java.util.concurrent.*;

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
public class WsHandler extends TextWebSocketHandler {

    private final CqFactory cqFactory;
    private final ApiHandler apiHandler;
    private final EventHandler eventHandler;
    private final ExecutorService executor;

    public WsHandler(CqFactory cqFactory, ApiHandler apiHandler, EventHandler eventHandler, EventProperties eventProperties) {
        this.cqFactory = cqFactory;
        this.apiHandler = apiHandler;
        this.eventHandler = eventHandler;
        this.executor = new ThreadPoolExecutor(
                eventProperties.getCorePoolSize(),
                eventProperties.getMaxPoolSize(),
                eventProperties.getKeepAliveTime(),
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(eventProperties.getWorkQueueSize())
        );
    }

    /**
     * cqHttp连接创建
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        long qid = getQid(session);
        log.info("{} connection", qid);

        //创建CqTemplate,存入CqGlobal方便取用
        CqTemplate cqTemplate = cqFactory.create(qid, session);
        CqGlobal.robots.put(qid, cqTemplate);
    }

    /**
     * cqHttp连接关闭
     *
     * @param session     会话
     * @param closeStatus 关闭状态
     * @throws Exception 异常
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        long qid = getQid(session);
        log.info("{} close connection", qid);

        CqGlobal.robots.remove(qid);
    }

    /**
     * 处理消息
     *
     * @param session 会话
     * @param message 消息
     * @throws Exception 异常
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        long qid = getQid(session);
        CqTemplate cqTemplate = CqGlobal.robots.get(qid);

        if (cqTemplate == null) {
            cqTemplate = cqFactory.create(qid, session);
            CqGlobal.robots.put(qid, cqTemplate);
            log.info("触发快速重连(真的能触发吗,没懂)");
        }
        cqTemplate.setSession(session);

        JSONObject messageObj = JSON.parseObject(message.getPayload());
        if (isReturn(messageObj)) {
            //是返回消息 触发唤醒事件
            apiHandler.onReceiveApiMessage(messageObj);
        } else {
            //是cq消息上报
            CqTemplate finalCqTemplate = cqTemplate;
            executor.execute(() -> eventHandler.handle(finalCqTemplate, messageObj));
        }

        log.info("get message:{}", JSON.toJSONString(message));
    }

    /**
     * 提取qid
     *
     * @param session 会话
     * @return long
     */
    private long getQid(WebSocketSession session) {
        final String headerQid = "x-self-id";
        String qid = Objects.requireNonNull(session.getHandshakeHeaders().get(headerQid)).get(0);
        return Long.parseLong(qid);
    }

    private boolean isReturn(JSONObject messageObj) {
        return messageObj.containsKey("echo");
    }


}

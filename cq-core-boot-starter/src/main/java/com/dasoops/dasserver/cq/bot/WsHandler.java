package com.dasoops.dasserver.cq.bot;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.WrapperGlobal;
import com.dasoops.dasserver.cq.api.ApiHandler;
import com.dasoops.dasserver.cq.conf.NamedThreadFactory;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.conf.properties.EventProperties;
import com.dasoops.dasserver.cq.utils.CqAssert;
import com.dasoops.dasserver.cq.wrapper.ExceptionWrapper;
import com.dasoops.dasserver.cq.wrapper.WsWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Title: websocketHandler
 * @ClassPath com.dasoops.dasserver.cq.websocket.websocketHandler
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
    private final CqProperties cqProperties;
    private boolean initIsCompleted = false;

    public WsHandler(CqFactory cqFactory, ApiHandler apiHandler, EventHandler eventHandler, EventProperties eventProperties, CqProperties cqProperties) {
        this.cqFactory = cqFactory;
        this.apiHandler = apiHandler;
        this.eventHandler = eventHandler;
        this.executor = new ThreadPoolExecutor(
                eventProperties.getCorePoolSize(),
                eventProperties.getMaxPoolSize(),
                eventProperties.getKeepAliveTime(),
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(eventProperties.getWorkQueueSize()),
                new NamedThreadFactory("wsHandler"));
        this.cqProperties = cqProperties;
    }

    /**
     * cqHttp连接创建
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) {
        Long qid = getQid(session);
        log.info("{} connection", qid);

        //创建CqTemplate,存入CqGlobal方便取用
        CqTemplate cqTemplate = cqFactory.create(qid, session);
        CqGlobal.put(qid, cqTemplate);

        List<WsWrapper> wsWrapperList = WrapperGlobal.getWsWrapperList();

        CqAssert.ifNotNull(wsWrapperList, () -> wsWrapperList.parallelStream()
                .forEach(wsWrapper -> wsWrapper.afterConnectionEstablishedWrapper(cqTemplate))
        );

        initIsCompleted = true;


/*
        插件通知 预计迁移至增强插件
        List<String> unLoadPluginList = stringRedisTemplate.opsForList().range(RedisKeyEnum.UN_LOAD_PLUGIN.getKey(), 0, -1);
        List<String> loadPluginList = stringRedisTemplate.opsForList().range(RedisKeyEnum.LOAD_PLUGIN.getKey(), 0, -1);

        String configRedisKey = RedisKeyEnum.CORE_CONFIG + ":config";
        String version = "null";
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(configRedisKey))) {
            version = (String) stringRedisTemplate.opsForHash().get(RedisKeyEnum.CORE_CONFIG + ":config", "localVersion");
        }
        StringBuilder sb = new StringBuilder("Server Start V." + version);
        if (unLoadPluginList != null) {
            sb.append("\r\n已加载插件: ");
            unLoadPluginList.forEach(pluginName -> {
                sb.append("\r\n\t- ").append(pluginName);
            });
        }
        if (loadPluginList != null) {
            sb.append("未成功加载插件: ");
            loadPluginList.forEach(pluginName -> {
                sb.append("\r\n\t- ").append(pluginName);
            });
        }

        CqAssert.notNull(loadPluginList, () -> sb.append(StrUtil.format("成功加载插件 {} 个\r\n", loadPluginList.size())));
        CqAssert.notNull(unLoadPluginList, () -> sb.append(StrUtil.format("未成功加载插件 {} 个\r\n", unLoadPluginList.size())));

        cqTemplate.sendGroupMsg(cqProperties.getDevGroupId(), sb.toString(), false);
        */
    }

    /**
     * cqHttp连接关闭
     *
     * @param session     会话
     * @param closeStatus 关闭状态
     * @throws Exception 异常
     */
    @Override
    public void afterConnectionClosed(@NonNull WebSocketSession session, @NonNull CloseStatus closeStatus) {
        Long qid = getQid(session);
        log.info("{} close connection", qid);
        List<WsWrapper> wsWrapperList = WrapperGlobal.getWsWrapperList();
        CqAssert.ifNotNull(wsWrapperList, () -> wsWrapperList.parallelStream()
                .forEach(wsWrapper -> wsWrapper.afterConnectionClosedWrapper(CqGlobal.get(qid))));

        CqGlobal.remove(qid);
    }

    /**
     * 处理消息
     *
     * @param session 会话
     * @param message 消息
     * @throws Exception 异常
     */
    @Override
    public void handleTextMessage(@NonNull WebSocketSession session, @NonNull TextMessage message) {
        //等待缓存更新
        try {
            while (!initIsCompleted) {
                super.wait(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long qid = getQid(session);
        CqTemplate cqTemplate = CqGlobal.get(qid);

        if (cqTemplate == null) {
            cqTemplate = cqFactory.create(qid, session);
            CqGlobal.put(qid, cqTemplate);
            log.info("触发快速重连(你真的规范操作了嘛)");
        }
        cqTemplate.setBotSession(session);

        JSONObject messageObj = JSON.parseObject(message.getPayload());
        if (isReturn(messageObj)) {
            log.debug("onReceiveApiMessage: {}", message.getPayload().replace("\n", ""));
            //是返回消息 触发唤醒事件
            apiHandler.onReceiveApiMessage(messageObj);
        } else {
            //是cq消息上报
            CqTemplate finalCqTemplate = cqTemplate;
            executor.execute(() -> {
                try {
                    eventHandler.handle(finalCqTemplate, messageObj);
                } catch (Exception e) {
                    //异常处理
                    CqAssert.ifTrue(cqProperties.isConsolePrintStack(), () -> CqAssert.ifTrueOrElse(cqProperties.isNativePrintStack(),
                            e::printStackTrace,
                            () -> log.error("消息处理发生异常: {}", e instanceof LogicException ? ((LogicException) e).getStackMessage() : e)
                    ));
                    List<ExceptionWrapper> exceptionWrapperList = WrapperGlobal.getExceptionWrapperList();
                    Assert.ifNotNull(exceptionWrapperList, () -> exceptionWrapperList.forEach(exceptionWrapper -> exceptionWrapper.invoke(e)));
                }
            });
        }
    }

    /**
     * 提取qid
     *
     * @param session 会话
     * @return long
     */
    private Long getQid(WebSocketSession session) {
        final String headerQid = "x-self-id";
        String qid = Objects.requireNonNull(session.getHandshakeHeaders().get(headerQid)).get(0);
        return Long.valueOf(qid);
    }

    private boolean isReturn(JSONObject messageObj) {
        return messageObj.containsKey("echo");
    }


}

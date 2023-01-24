package com.dasoops.dasserver.plugin.shell.websocket;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.EventUtil;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.entity.enums.EventTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.PostTypeEnum;
import com.dasoops.dasserver.cq.exception.ExceptionTemplate;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.plugin.shammessage.ShamMessageTemplate;
import com.dasoops.dasserver.plugin.shell.ShellConfig;
import com.dasoops.dasserver.plugin.shell.ShellCqTemplate;
import com.dasoops.dasserver.plugin.shell.ShellTemplate;
import com.dasoops.dasserver.plugin.shell.entity.enums.ShellExceptionEnum;
import com.dasoops.dasserver.plugin.shell.entity.enums.ShellRedisHashKeyEnum;
import com.dasoops.dasserver.plugin.shell.entity.enums.ShellRunMessageTypeEnum;
import com.dasoops.dasserver.plugin.shell.log.LogSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @Title: shellWebSocketHandler
 * @ClassPath com.dasoops.dasserver.plugin.shell.websocket.shellWebSocketHandler
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: shellWebSocket处理程序
 * client -> shamMessageTemplate -> ShellShamCqTemplate -> ShellTemplate -> client
 * @see TextWebSocketHandler
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ShellWsHandelr extends TextWebSocketHandler {

    private final ConfigCache configCache;
    private final ConfigService configService;
    private final ExceptionTemplate exceptionTemplate;
    /**
     * 虚假消息template
     */
    private final ShamMessageTemplate shamMessageTemplate;

    /**
     * 与前端连接的shellTemplate
     */
    private ShellTemplate shellTemplate;

    /**
     * 虚假cqTemplate
     */
    private ShellCqTemplate shellCqTemplate;

    /**
     * shell配置
     */
    private ShellConfig shellConfig;

    /**
     * 日志发送方
     */
    private LogSender logSender;

    @Override
    protected void handleTextMessage(@NotNull WebSocketSession session, @NotNull TextMessage textMessage) {
        if (shellTemplate == null) {
            log.error("shellTemplate is null");
        }
        String message = textMessage.getPayload();

        boolean isConfig = resloveConfig(message);
        if (isConfig) {
            return;
        }

        Long groupId = shellConfig.getGroupId();
        Long userId = shellConfig.getUserId();

        CqMessageEvent event;
        if (shellConfig.getType().equals(ShellRunMessageTypeEnum.GROUP)) {
            CqGroupMessageEvent cqGroupMessageEvent = new CqGroupMessageEvent();
            cqGroupMessageEvent.setGroupId(groupId);
            event = cqGroupMessageEvent;
            event.setMessageType(EventTypeEnum.MESSAGE_GROUP.getKey());
        } else {
            event = new CqPrivateMessageEvent();
            event.setMessageType(EventTypeEnum.MESSAGE_PRIVATE.getKey());
        }
        event.setPostType(PostTypeEnum.MESSAGE.getKey());
        event.setMessage(message);
        event.setRawMessage(message);
        event.setUserId(userId);

        JSONObject eventJson = JSON.parseObject(JSON.toJSONString(event));
        EventUtil.set(eventJson);
        try {
            shamMessageTemplate.sendMsg(shellCqTemplate, JSON.parseObject(JSON.toJSONString(event)));
        } catch (Exception e) {
            exceptionTemplate.resloveException(shellCqTemplate, e);
        }
        shellTemplate.sendMsg("ok");
    }

    final String ping = ".ping";
    final String set = ".set";
    final String get = ".get";
    final String userId = "userId";
    final String groupId = "groupId";
    final String type = "type";
    final String selfId = "selfId";

    private boolean resloveConfig(String message) {
        if (ping.equals(message)) {
            //ping pong
            shellTemplate.sendMsg("pong");
        } else if (StrUtil.startWith(message, set)) {
            //set
            String config = message.substring(set.length() + 1);
            if (config.startsWith(userId)) {
                //set userId
                shellConfig.setUserId(Long.valueOf(config.substring(userId.length() + 1)));
            } else if (config.startsWith(groupId)) {
                //set userId
                shellConfig.setUserId(Long.valueOf(config.substring(groupId.length() + 1)));
            } else if (config.startsWith(type)) {
                shellConfig.setType(ShellRunMessageTypeEnum.valueOf(config.substring(type.length() + 1)));
            } else if (config.startsWith(selfId)) {
                shellConfig.setSelfId(Long.valueOf(config.substring(selfId.length() + 1)));
            } else {
                throw new LogicException(ShellExceptionEnum.RESLOVE_ERROR);
            }
            //更新数据库缓存
            configService.setConfig(ShellRedisHashKeyEnum.SHELL_CONFIG, JSON.toJSONString(shellConfig));
            shellTemplate.sendMsg("ok");
        } else if (StrUtil.startWith(message, get)) {
            shellTemplate.sendMsg(StrUtil.format("""
                            type:   {},
                            selfId: {},
                            groupId:{},
                            userId: {},
                            """,
                    shellConfig.getType().name(),
                    shellConfig.getSelfId(),
                    shellConfig.getGroupId(),
                    shellConfig.getUserId()
            ));
        } else {
            return false;
        }
        return true;
    }

    @Override
    public void afterConnectionEstablished(@NotNull WebSocketSession session) {
        shellTemplate = new ShellTemplate(session);
        shellCqTemplate = new ShellCqTemplate(shellTemplate);
        shellConfig = configCache.getJsonConfig(ShellRedisHashKeyEnum.SHELL_CONFIG, ShellConfig.class);
        shellTemplate.sendMsg("connection completed");
        if (logSender != null) {
            logSender.beStop();
        }
        logSender = new LogSender(shellTemplate);
        logSender.start();
    }

    @Override
    public void afterConnectionClosed(@NotNull WebSocketSession session, @NotNull CloseStatus status) {
        shellTemplate = null;
        shellCqTemplate = null;
        logSender.beStop();
        logSender = null;
    }
}

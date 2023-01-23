package com.dasoops.dasserver.plugin.shell;

import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.plugin.shell.entity.enums.ShellExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * @Title: ShellTemplate
 * @ClassPath com.dasoops.dasserver.plugin.shell.ShellTemplate
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: shellTemplate(向前端发送消息)
 */
@Slf4j
@RequiredArgsConstructor
public class ShellTemplate {

    private final WebSocketSession session;

    public void sendMsg(String msg) {
        TextMessage textMessage = new TextMessage(msg);
        try {
            session.sendMessage(textMessage);
        } catch (IOException e) {
            log.error("消息发送失败");
            throw new LogicException(ShellExceptionEnum.SEND_ERROR);
        }
    }


}

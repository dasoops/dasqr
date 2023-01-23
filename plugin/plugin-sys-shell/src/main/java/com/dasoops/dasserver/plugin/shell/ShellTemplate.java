package com.dasoops.dasserver.plugin.shell;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

/**
 * @Title: ShellTemplate
 * @ClassPath com.dasoops.dasserver.plugin.shell.ShellTemplate
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: shell模板
 */
@Slf4j
@RequiredArgsConstructor
public class ShellTemplate {

    private final WebSocketSession session;

}

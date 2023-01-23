package com.dasoops.dasserver.plugin.shell;

import org.springframework.web.socket.WebSocketSession;

/**
 * @Title: ShellWsGlobal
 * @ClassPath com.dasoops.dasserver.plugin.shell.ShellWsGlobal
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: ShellWebSocket连接
 */
public class ShellWsGlobal {

    /**
     * shellTemplate 仅允许保持一个连接
     */
    private static ShellTemplate shellTemplate;

    public static void set(WebSocketSession session) {
        shellTemplate = new ShellTemplate(session);
    }

    public static ShellTemplate get(String hostStr) {
        return shellTemplate;
    }

    public static void clear() {
        shellTemplate = null;
    }

}

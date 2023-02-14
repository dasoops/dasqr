package com.dasoops.dasserver.cq.conf;

import com.dasoops.dasserver.cq.bot.WsHandler;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.conf.properties.EventProperties;
import com.dasoops.dasserver.cq.conf.properties.WsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @title: CqConfiguration
 * @classPath com.dasoops.dasserver.cq.conf.CqConfiguration
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/03
 * @version 1.0.0
 * @description cq配置
 * @see WebSocketConfigurer
 */
@ComponentScan("com.dasoops.dasserver.cq")
@EnableWebSocket
@EnableConfigurationProperties({WsProperties.class, EventProperties.class, CqProperties.class})
public class CqConfiguration implements WebSocketConfigurer {

    final WsHandler wsHandler;
    final WsProperties wsProperties;

    public CqConfiguration(WsHandler wsHandler, WsProperties wsProperties) {
        this.wsHandler = wsHandler;
        this.wsProperties = wsProperties;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(wsHandler, wsProperties.getUrl()).setAllowedOrigins("*");
    }
}

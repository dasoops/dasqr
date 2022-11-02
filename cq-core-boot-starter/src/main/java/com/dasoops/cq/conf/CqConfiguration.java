package com.dasoops.cq.conf;

import com.dasoops.cq.conf.properties.CqProperties;
import com.dasoops.cq.conf.properties.EventProperties;
import com.dasoops.cq.conf.properties.WsProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Title: CqAutoConfiguration
 * @ClassPath com.dasoops.cq.boot.CqAutoConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/20
 * @Version 1.0.0
 * @Description: cq配置类
 */
@Configuration
@ComponentScan("com.dasoops.cq")
@EnableWebSocket
@Import({CqBeanConfiguration.class})
@EnableConfigurationProperties({WsProperties.class, EventProperties.class, CqProperties.class})
@EnableAutoConfiguration
public class CqConfiguration implements WebSocketConfigurer {

    final WebSocketHandler webSocketHandler;
    final WsProperties wsProperties;

    public CqConfiguration(WebSocketHandler webSocketHandler, WsProperties wsProperties) {
        this.webSocketHandler = webSocketHandler;
        this.wsProperties = wsProperties;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, wsProperties.getUrl()).setAllowedOrigins("*");
    }
}

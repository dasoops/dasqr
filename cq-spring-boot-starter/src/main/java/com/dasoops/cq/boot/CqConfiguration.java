package com.dasoops.cq.boot;

import org.springframework.beans.factory.annotation.Autowired;
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
@EnableConfigurationProperties({CqProperties.class})
public class CqConfiguration implements WebSocketConfigurer {

    @Autowired
    WebSocketHandler webSocketHandler;
    @Autowired
    CqProperties cqProperties;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, cqProperties.getUrl()).setAllowedOrigins("*");
    }
}

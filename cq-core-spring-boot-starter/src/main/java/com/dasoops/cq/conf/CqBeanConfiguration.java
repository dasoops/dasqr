package com.dasoops.cq.conf;

import com.dasoops.cq.bot.ApiHandler;
import com.dasoops.cq.bot.CqFactory;
import com.dasoops.cq.bot.EventHandler;
import com.dasoops.cq.conf.properties.CqProperties;
import com.dasoops.cq.conf.properties.EventProperties;
import com.dasoops.cq.websocket.WsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * @Title: CqBeanConfiguration
 * @ClassPath com.dasoops.cq.boot.CqBeanConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq bean配置
 */
@Component
public class CqBeanConfiguration {

    private final CqProperties cqProperties;
    private final ApplicationContext applicationContext;

    public CqBeanConfiguration(CqProperties cqProperties, ApplicationContext applicationContext) {
        this.cqProperties = cqProperties;
        this.applicationContext = applicationContext;
    }

    @Bean
    @ConditionalOnMissingBean
    public WebSocketHandler createWebSocketHandler(CqFactory cqFactory, ApiHandler apiHandler, EventHandler eventHandler, EventProperties eventProperties) {
        return new WsHandler(cqFactory, apiHandler, eventHandler, eventProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public EventHandler createEventHandler() {
        return new EventHandler(applicationContext);
    }

    @Bean
    @ConditionalOnMissingBean
    public ApiHandler createApiHandler() {
        return new ApiHandler(cqProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        // 设置bufferSize,防止数据过大导致接收不到
        container.setMaxTextMessageBufferSize(cqProperties.getMaxTextMessageBufferSize());
        container.setMaxBinaryMessageBufferSize(cqProperties.getMaxBinaryMessageBufferSize());
        container.setMaxSessionIdleTimeout(cqProperties.getMaxSessionIdleTimeout());
        return container;
    }
}
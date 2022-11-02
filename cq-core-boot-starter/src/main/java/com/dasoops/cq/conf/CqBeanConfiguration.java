package com.dasoops.cq.conf;

import com.dasoops.cq.bot.ApiHandler;
import com.dasoops.cq.bot.CqFactory;
import com.dasoops.cq.bot.EventHandler;
import com.dasoops.cq.conf.properties.CqProperties;
import com.dasoops.cq.conf.properties.EventProperties;
import com.dasoops.cq.conf.properties.WsProperties;
import com.dasoops.cq.exception.wrapper.ExceptionWrapper;
import com.dasoops.cq.websocket.WsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@Configuration
public class CqBeanConfiguration {

    private final WsProperties wsProperties;
    private final ApplicationContext applicationContext;

    public CqBeanConfiguration(WsProperties wsProperties, ApplicationContext applicationContext) {
        this.wsProperties = wsProperties;
        this.applicationContext = applicationContext;
    }

    @Bean
    @ConditionalOnMissingBean
    public WebSocketHandler createWebSocketHandler(
            CqFactory cqFactory, ApiHandler apiHandler, EventHandler eventHandler, EventProperties eventProperties, CqProperties cqProperties, @Autowired(required = false) ExceptionWrapper exceptionWrapper) {
        return new WsHandler(cqFactory, apiHandler, eventHandler, eventProperties, exceptionWrapper, cqProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public EventHandler createEventHandler() {
        return new EventHandler(applicationContext);
    }

    @Bean
    @ConditionalOnMissingBean
    public ApiHandler createApiHandler() {
        return new ApiHandler(wsProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        // 设置bufferSize,防止数据过大导致接收不到
        container.setMaxTextMessageBufferSize(wsProperties.getMaxTextMessageBufferSize());
        container.setMaxBinaryMessageBufferSize(wsProperties.getMaxBinaryMessageBufferSize());
        container.setMaxSessionIdleTimeout(wsProperties.getMaxSessionIdleTimeout());
        return container;
    }

    @Bean
    @ConditionalOnProperty(prefix = "dasq.cq.core", name = "loadLocalPluginList", havingValue = "true", matchIfMissing = false)
    public CqFactory createCqFactory(
            @Autowired(required = false) ApiHandler apiHandler,
            @Autowired(required = false) CqProperties cqProperties) {
        return new CqFactory(apiHandler, cqProperties.isLoadLocalPluginList() ? cqProperties.getPluginList() : null);
    }
}
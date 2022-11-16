package com.dasoops.dasserver.cq.conf;

import com.dasoops.dasserver.cq.api.ApiHandler;
import com.dasoops.dasserver.cq.bot.CqFactory;
import com.dasoops.dasserver.cq.bot.EventHandler;
import com.dasoops.dasserver.cq.bot.AuthWrapper;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.conf.properties.EventProperties;
import com.dasoops.dasserver.cq.conf.properties.WsProperties;
import com.dasoops.dasserver.cq.exception.wrapper.ExceptionWrapper;
import com.dasoops.dasserver.cq.websocket.WsHandler;
import com.dasoops.dasserver.cq.websocket.WsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * @Title: CqBeanConfiguration
 * @ClassPath com.dasoops.dasserver.cq.boot.CqBeanConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq bean配置
 */
@Configuration
public class CqBeanConfiguration {

    private final WsProperties wsProperties;
    private final ApplicationContext applicationContext;
    private final AuthWrapper authWrapper;

    public CqBeanConfiguration(WsProperties wsProperties, ApplicationContext applicationContext, @Autowired(required = false) AuthWrapper authWrapper) {
        this.wsProperties = wsProperties;
        this.applicationContext = applicationContext;
        this.authWrapper = authWrapper;
    }

    @Bean
    @ConditionalOnMissingBean
    @Lazy
    public WebSocketHandler createWebSocketHandler(
            CqFactory cqFactory,
            ApiHandler apiHandler,
            EventHandler eventHandler,
            EventProperties eventProperties,
            CqProperties cqProperties,
            @Autowired(required = false) ExceptionWrapper exceptionWrapper,
            @Autowired(required = false) WsWrapper wsWrapper

    ) {
        return new WsHandler(cqFactory, apiHandler, eventHandler, eventProperties, exceptionWrapper, cqProperties, wsWrapper);
    }

    @Bean
    @ConditionalOnMissingBean
    public EventHandler createEventHandler() {
        return new EventHandler(applicationContext, authWrapper);
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
package com.dasoops.dasserver.cq.conf;

import com.dasoops.dasserver.cq.CqPluginGlobal;
import com.dasoops.dasserver.cq.WrapperGlobal;
import com.dasoops.dasserver.cq.api.ApiHandler;
import com.dasoops.dasserver.cq.bot.CqFactory;
import com.dasoops.dasserver.cq.bot.EventHandler;
import com.dasoops.dasserver.cq.bot.WsHandler;
import com.dasoops.dasserver.cq.conf.properties.EventProperties;
import com.dasoops.dasserver.cq.conf.properties.WsProperties;
import com.dasoops.dasserver.cq.exception.ExceptionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

    public CqBeanConfiguration(WsProperties wsProperties, ApplicationContext applicationContext) {
        this.wsProperties = wsProperties;
        this.applicationContext = applicationContext;
    }

    @Bean
    @ConditionalOnMissingBean
    public ExecutorService executor(EventProperties eventProperties) {
        return new ThreadPoolExecutor(
                eventProperties.getCorePoolSize(),
                eventProperties.getMaxPoolSize(),
                eventProperties.getKeepAliveTime(),
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(eventProperties.getWorkQueueSize()),
                new NamedThreadFactory("ws"));
    }

    @Bean
    @ConditionalOnMissingBean
    public EventHandler createEventHandler() {
        return new EventHandler();
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
    @ConditionalOnProperty(prefix = "dasq.cq.core", name = "loadLocalPluginList", havingValue = "true")
    public CqFactory createCqFactory(
            @Autowired(required = false) ApiHandler apiHandler) {
        return new CqFactory(apiHandler);
    }

    @Bean
    @ConditionalOnMissingBean
    public WsHandler wsHandler(
            CqFactory cqFactory,
            ApiHandler apiHandler,
            EventHandler eventHandler,
            ExceptionTemplate exceptionTemplate,
            ExecutorService executor
    ) {
        return new WsHandler(cqFactory, apiHandler, eventHandler, executor, exceptionTemplate);
    }

    @PostConstruct
    public void setAndRefresh() {
        WrapperGlobal.setApplicationContext(applicationContext);
        CqPluginGlobal.setApplicationContext(applicationContext);
        WrapperGlobal.refresh();
        CqPluginGlobal.refresh();
    }
}
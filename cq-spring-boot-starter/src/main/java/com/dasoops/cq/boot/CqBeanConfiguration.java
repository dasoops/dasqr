package com.dasoops.cq.boot;

import com.dasoops.cq.websocket.WsHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;

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

    @Bean
    @ConditionalOnMissingBean
    public WebSocketHandler createWebSocketHandler() {
        return new WsHandler();
    }


}

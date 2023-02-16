package com.dasoops.dasserver.plugin.webmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @title Configuration
 * @classPath com.dasoops.dasserver.webManager.Configuration
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/28
 * @version 1.0.0
 * @description 配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.webmanager")
@MapperScan("com.dasoops.dasserver.plugin.webmanager.mapper")
public class AutoConfiguration {
    @Bean
    public WebManagerRouteRegistry webManagerRouteRegister() {
        WebManagerRouteRegistry webManagerRouteRegistry = new WebManagerRouteRegistry();
        webManagerRouteRegistry.registerRoute("config", "register", "plugin");
        return webManagerRouteRegistry;
    }
}

package com.dasoops.dasserver.plugin.webmanager;

import com.dasoops.dasserver.plugin.webmanager.entity.WebManagerRouteRegistry;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: Configuration
 * @ClassPath com.dasoops.dasserver.webManager.Configuration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 配置
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

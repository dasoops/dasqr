package com.dasoops.dasserver.plugin.shell;

import com.dasoops.dasserver.plugin.webmanager.entity.WebManagerRouteRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Title: AutoConfiguration
 * @ClassPath com.dasoops.dasserver.plugin.shell.AutoConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: 自动配置
 */
@Configuration
@ComponentScan("com.dasoops.dasserver.plugin.shell")
@RequiredArgsConstructor
public class AutoConfiguration {

    private final WebManagerRouteRegistry registry;

    @PostConstruct
    public void registerWebRoute() {
        registry.registerRoute("shell");
    }


}

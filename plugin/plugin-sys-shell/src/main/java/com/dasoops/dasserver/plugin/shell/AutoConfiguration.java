package com.dasoops.dasserver.plugin.shell;

import com.dasoops.dasserver.plugin.webmanager.WebManagerRouteRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @title: AutoConfiguration
 * @classPath com.dasoops.dasserver.plugin.shell.AutoConfiguration
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/23
 * @version 1.0.0
 * @description 自动配置
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

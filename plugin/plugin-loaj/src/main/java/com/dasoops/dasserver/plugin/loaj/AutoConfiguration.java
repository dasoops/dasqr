package com.dasoops.dasserver.plugin.loaj;

import com.dasoops.dasserver.plugin.webmanager.WebManagerRouteRegistry;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

/**
 * @title: AutoConfiguration
 * @classPath com.dasoops.dasserver.plugin.loaj.AutoConfiguration
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/04
 * @version 1.0.0
 * @description 自动配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.loaj")
@MapperScan("com.dasoops.dasserver.plugin.loaj.mapper")
@EnableTransactionManagement
@RequiredArgsConstructor
public class AutoConfiguration {

    private final WebManagerRouteRegistry registry;

    @PostConstruct
    public void registerWebRoute() {
        registry.registerRoute("reply");
    }

}

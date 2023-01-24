package com.dasoops.dasserver.plugin.schedule;

import com.dasoops.dasserver.plugin.webmanager.entity.WebManagerRouteRegistry;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

/**
 * @Title: AutoConfiguration
 * @ClassPath com.dasoops.dasserver.plugin.schedule.AutoConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: 自动配置
 */
@Configuration
@ComponentScan("com.dasoops.dasserver.plugin.schedule")
@MapperScan("com.dasoops.dasserver.plugin.schedule.mapper")
@EnableScheduling
@RequiredArgsConstructor
public class AutoConfiguration {

    private final WebManagerRouteRegistry registry;

    @PostConstruct
    public void registerWebRoute() {
        registry.registerRoute("schedule");
    }

}

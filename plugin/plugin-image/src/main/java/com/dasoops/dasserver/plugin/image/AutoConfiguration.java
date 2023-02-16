package com.dasoops.dasserver.plugin.image;

import com.dasoops.dasserver.plugin.webmanager.WebManagerRouteRegistry;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

/**
 * @title configuration
 * @classPath com.dasoops.dasserver.plugin.gitnotice.configuration
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/02
 * @version 1.0.0
 * @description 自动配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.image.*")
@MapperScan("com.dasoops.dasserver.plugin.image.mapper")
@RequiredArgsConstructor
public class AutoConfiguration {

    private final WebManagerRouteRegistry registry;

    @PostConstruct
    public void registerWebRoute() {
        registry.registerRoute("image");
    }

}

package com.dasoops.dasserver.plugin.pluginloader;

import com.dasoops.dasserver.plugin.pluginloader.core.ModuleApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @title: configuration
 * @classPath com.dasoops.dasserver.plugin.gitnotice.configuration
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/02
 * @version 1.0.0
 * @description 自动配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.pluginloader.*")
public class AutoConfiguration {

    @Bean
    public ModuleApplication moduleApplication() {
        return new ModuleApplication();
    }
}

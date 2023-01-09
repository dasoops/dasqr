package com.dasoops.dasserver.plugin.pluginloader;

import com.dasoops.dasserver.plugin.pluginloader.core.ModuleApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: configuration
 * @ClassPath com.dasoops.dasserver.plugin.gitnotice.configuration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/02
 * @Version 1.0.0
 * @Description: 自动配置
 */
@ComponentScan("com.dasoops.dasserver.plugin.pluginloader.*")
public class AutoConfiguration {

    @Bean
    public ModuleApplication moduleApplication() {
        return new ModuleApplication();
    }
}

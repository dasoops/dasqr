package com.dasoops.cq.conf;

import com.dasoops.cq.bot.ApiHandler;
import com.dasoops.cq.bot.CqFactory;
import com.dasoops.cq.conf.properties.CqProperties;
import com.dasoops.cq.service.PluginService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Title: CqAutoConfiguration
 * @ClassPath com.dasoops.cq.boot.CqAutoConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/20
 * @Version 1.0.0
 * @Description: cq配置类
 */
@Configuration
@ComponentScan("com.dasoops.cq")
@MapperScan("com.dasoops.cq.mapper")
@Import({MybatisPlusConfiguration.class, ParameterFillConfiguration.class})
public class CqDbConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "dasq.cq.core", name = "loadLocalPluginList", havingValue = "false", matchIfMissing = true)
    public CqFactory cqFactory(
            @Autowired(required = false) ApiHandler apiHandler,
            @Autowired(required = false) CqProperties cqProperties,
            @Autowired(required = false) PluginService pluginService) {
        return new CqFactory(apiHandler, cqProperties.isLoadLocalPluginList() ? cqProperties.getPluginList() : pluginService.getAllPluginClass().orElse(null));
    }

}

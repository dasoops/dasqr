package com.dasoops.dasserver.cq.conf;

import com.dasoops.dasserver.cq.api.ApiHandler;
import com.dasoops.dasserver.cq.bot.CqFactory;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.service.PluginService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

/**
 * @Title: CqAutoConfiguration
 * @ClassPath com.dasoops.dasserver.cq.boot.CqAutoConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/20
 * @Version 1.0.0
 * @Description: cq配置类
 */
@ComponentScan("com.dasoops.dasserver.cq")
@MapperScan("com.dasoops.dasserver.cq.mapper")
public class CqDbConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "dasq.cq.core", name = "loadLocalPluginList", havingValue = "false", matchIfMissing = true)
    @Lazy
    public CqFactory cqFactory(
            @Autowired(required = false) ApiHandler apiHandler,
            @Autowired(required = false) CqProperties cqProperties,
            @Autowired(required = false) PluginService pluginService) {
        return new CqFactory(apiHandler, cqProperties.isLoadLocalPluginList() ? cqProperties.getPluginList() : pluginService.getAllPluginClass().orElse(null));
    }

}

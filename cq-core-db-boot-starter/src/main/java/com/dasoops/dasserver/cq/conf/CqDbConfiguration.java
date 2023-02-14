package com.dasoops.dasserver.cq.conf;

import com.dasoops.dasserver.cq.api.ApiHandler;
import com.dasoops.dasserver.cq.bot.CqFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @title: CqAutoConfiguration
 * @classPath com.dasoops.dasserver.cq.boot.CqAutoConfiguration
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/20
 * @version 1.0.0
 * @description cq配置类
 */
@ComponentScan("com.dasoops.dasserver.cq")
@MapperScan("com.dasoops.dasserver.cq.mapper")
public class CqDbConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "dasq.cq.core", name = "loadLocalPluginList", havingValue = "false", matchIfMissing = true)
    @Lazy
    public CqFactory cqFactory(
            @Autowired(required = false) ApiHandler apiHandler) {
        return new CqFactory(apiHandler);
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(@SuppressWarnings("all") RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

}

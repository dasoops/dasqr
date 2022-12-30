package com.dasoops.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Title: configuration
 * @ClassPath com.dasoops.config.configuration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 配置
 */
@org.springframework.context.annotation.Configuration
@ComponentScan("com.dasoops.common.config")
public class Configuration {

    @Bean
    public StringRedisTemplate stringRedisTemplate(@SuppressWarnings("all") RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}

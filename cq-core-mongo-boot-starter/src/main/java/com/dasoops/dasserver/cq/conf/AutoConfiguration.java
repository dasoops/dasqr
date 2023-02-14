package com.dasoops.dasserver.cq.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @title: AutoConfiguration
 * @classPath com.dasoops.dasserver.cq.conf.AutoConfiguration
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/04
 * @version 1.0.0
 * @description 自动配置
 */
@ComponentScan("com.dasoops.dasserver.cq")
@EnableAsync
public class AutoConfiguration {

    @Bean
    @SuppressWarnings("all")
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory) {
        return new MongoTemplate(mongoDatabaseFactory);
    }

}

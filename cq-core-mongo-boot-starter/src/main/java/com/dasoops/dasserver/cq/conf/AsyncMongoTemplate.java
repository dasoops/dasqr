package com.dasoops.dasserver.cq.conf;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Title: AsyncMongoTemplate
 * @ClassPath com.dasoops.dasserver.cq.conf.AsyncMongoTemplate
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/04
 * @Version 1.0.0
 * @Description: 异步mongoTemplate
 */
@Component
public class AsyncMongoTemplate {

    private final MongoTemplate mongoTemplate;

    public AsyncMongoTemplate(@SuppressWarnings("all") MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Async
    public <T> void save(T t) {
        mongoTemplate.save(t);
    }

}

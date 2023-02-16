package com.dasoops.dasserver.cq.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @title AsyncMongoTemplate
 * @classPath com.dasoops.dasserver.cq.conf.AsyncMongoTemplate
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/04
 * @version 1.0.0
 * @description 异步mongoTemplate
 */
@Component
@RequiredArgsConstructor
public class AsyncMongoTemplate {

    private final MongoTemplate mongoTemplate;

    @Async
    public <T> void save(T t) {
        mongoTemplate.save(t);
    }

}

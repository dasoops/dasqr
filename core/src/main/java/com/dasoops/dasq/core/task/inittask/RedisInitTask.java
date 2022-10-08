package com.dasoops.dasq.core.task.inittask;

import com.dasoops.dasq.core.image.service.ImageTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Title: redisInitTask
 * @ClassPath com.dasoops.dasq.task.inittask.redisInitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: redis初始化任务
 */

@Component
@AllArgsConstructor
@Slf4j
public class RedisInitTask {

    private final ImageTypeService imageTypeService;
    private final StringRedisTemplate redisTemplate;

    /**
     * 初始化
     * -初始化/更新 ImageType 数据至redis
     */
    @PostConstruct
    void init(){
//     * -初始化/更新 ImageType 数据至redis
        imageTypeService.initOrUpdateImageType2Redis();
    }





}

package com.dasoops.dasq.task.inittask;

import com.alibaba.fastjson2.JSON;
import com.dasoops.dasq.image.entity.ImageRedisKeyEnum;
import com.dasoops.dasq.image.entity.ImageType;
import com.dasoops.dasq.image.service.ImageInfoService;
import com.dasoops.dasq.image.service.ImageTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        initOrUpdateImageType2Redis();
    }

    /**
     * 初始化/更新 ImageType 数据至redis
     */
    public void initOrUpdateImageType2Redis(){
        log.info("初始化/更新 ImageType 数据至redis");

        List<ImageType> list = imageTypeService.lambdaQuery().list();
        Map<String, String> redisRes = list.stream().collect(Collectors.toMap(ImageType::getInnerCode, JSON::toJSONString));
        redisTemplate.opsForHash().putAll(ImageRedisKeyEnum.IMAGE_INNER_CODE_GET_IMAGE_JSON.name(),redisRes);

        log.info("完成: 初始化/更新 ImageType 数据至redis,data:{}",JSON.toJSONString(redisRes));

    }



}

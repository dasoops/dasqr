package com.dasoops.dasq.core.common.task.inittask;

import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.image.service.ImageTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Title: redisInitTask
 * @ClassPath com.dasoops.dasq.task.inittask.redisInitTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: redis初始化任务
 */

@Component
@Slf4j
public class RedisInitTask {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    private StringRedisTemplate redisTemplate;
    @Resource
    private ImageTypeService imageTypeService;
    @Resource
    private DictionaryService dictionaryService;

    /**
     * 初始化
     * -初始化/更新 ImageType innerCode-entityJson 数据至redis
     * -初始化/更新 ImageType id-entityJson 数据至redis
     * -初始化/更新 DictionaryTreeData 数据至redis
     * -初始化/更新 DictFatherDictCodeMap 数据至redis
     */
    @PostConstruct
    void init() {
//     * -初始化/更新 ImageType innerCode-entityJson 数据至redis
        imageTypeService.initOrUpdateImageTypeInnerCodeGetEntityJson2Redis();
//     * -初始化/更新 ImageType id-entityJson 数据至redis
        imageTypeService.initOrUpdateImageTypeIdGetEntityJson2Redis();
//     * -初始化/更新 DictionaryTreeData 数据至redis
        dictionaryService.initOrUpdateDictTreeData2Redis();
//     * -初始化/更新 DictFatherDictCodeMap 数据至redis
        dictionaryService.initOrUpdateDictFatherDictCodeMap2Redis();
    }





}

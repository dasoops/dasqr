package com.dasoops.dasq.core.common.task;

import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.game.RereadStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.sys.StyleStrategy;
import com.dasoops.dasq.core.cq.service.MethodInfoService;
import com.dasoops.dasq.core.cq.service.MethodTypeService;
import com.dasoops.dasq.core.cq.service.PassListService;
import com.dasoops.dasq.core.image.service.ImageInfoService;
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
public class RedisTask {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    private StringRedisTemplate redisTemplate;
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    private ImageTypeService imageTypeService;
    @Resource
    private ImageInfoService imageInfoService;
    @Resource
    private MethodTypeService methodTypeService;
    @Resource
    private MethodInfoService methodInfoService;
    @Resource
    private PassListService passListService;
    @Resource
    private StyleStrategy styleStrategy;
    @Resource
    private RereadStrategy rereadStrategy;


    /**
     * 初始化
     * -初始化/更新 ImageType innerCode-entityJson 数据至redis
     * -初始化/更新 ImageType id-entityJson 数据至redis
     * -初始化/更新 DictionaryTreeData 数据至redis
     * -初始化/更新 DictFatherDictCodeMap 数据至redis
     * -初始化/更新 MethodType Id-EntityJson 数据至redis
     * -初始化/更新 MethodInfo Id-EntityJson 数据至redis
     * -初始化/更新 PassListTypeGetEntityJsonSetMap 数据至redis
     * -初始化/更新 白名单关键词-方法info id映射集合 数据至redis
     * -初始化/更新 图像关键字列表
     */
    @PostConstruct
    public void initOrUpdate() {
//     * -初始化/更新 ImageType innerCode-entityJson 数据至redis
//     * -初始化/更新 ImageType id-entityJson 数据至redis
        imageTypeService.initOrUpdate();
//     * -初始化/更新 DictionaryTreeData 数据至redis
//     * -初始化/更新 DictFatherDictCodeMap 数据至redis
        dictionaryService.initOrUpdate();
//     * -初始化/更新 MethodType Id-EntityJson 数据至redis
        methodTypeService.initOrUpdate();
//     * -初始化/更新 MethodInfo Id-EntityJson 数据至redis
        methodInfoService.initOrUpdate();
//     * -初始化/更新 PassListTypeGetEntityJsonSetMap 数据至redis
//     * -初始化/更新 白名单关键词-方法info id映射集合 数据至redis
        passListService.initOrUpdate();
//     * -初始化 指令风格
        styleStrategy.init();
//     * -初始化/更新 图像关键字列表
        imageInfoService.initOrUpdate();

    }


}

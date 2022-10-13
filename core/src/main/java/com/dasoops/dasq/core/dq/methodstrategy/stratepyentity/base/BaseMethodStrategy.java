package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base;

import com.dasoops.dasq.core.common.entity.DasqProperties;
import com.dasoops.dasq.core.cq.service.CqService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @Title: BaseMethodStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseMethodStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/11
 * @Version 1.0.0
 * @Description: 方法策略基类
 */
public class BaseMethodStrategy {

    @Resource
    protected DasqProperties dasqProperties;
    @Resource
    protected CqService cqService;
    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    protected StringRedisTemplate redisTemplate;

}

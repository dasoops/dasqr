package com.dasoops.common.exception.service;

import com.dasoops.common.entity.enums.RedisKeyEnum;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Title: ExceptionServiceImpl
 * @ClassPath com.dasoops.common.exception.service.ExceptionServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/11
 * @Version 1.0.0
 * @Description:
 * @see ExceptionService
 */
@Service
public class ExceptionServiceImpl implements ExceptionService {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    StringRedisTemplate redisTemplate;

    @Override
    public String getException(String errorId) {
        return (String) redisTemplate.opsForHash().get(RedisKeyEnum.ID_GET_EXCEPTION_INFO_JSON_MAP.getRedisKey(), errorId);
    }

    @Override
    public void saveException(String errorId, String msg) {
        redisTemplate.opsForHash().put(RedisKeyEnum.ID_GET_EXCEPTION_INFO_JSON_MAP.getRedisKey(), errorId, msg);
    }

}

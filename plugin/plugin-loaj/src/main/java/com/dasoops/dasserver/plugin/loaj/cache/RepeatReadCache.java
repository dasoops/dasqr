package com.dasoops.dasserver.plugin.loaj.cache;

import com.alibaba.fastjson2.JSON;
import com.dasoops.common.cache.BaseCache;
import com.dasoops.dasserver.plugin.loaj.entity.dto.RepeatReadRedisDto;
import com.dasoops.dasserver.plugin.loaj.entity.enums.RepeatReadRedisKeyShamEnum;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Title: RepeatReadCache
 * @ClassPath com.dasoops.dasserver.plugin.loaj.cache.RepeatReadCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/19
 * @Version 1.0.0
 * @Description: 复读缓存
 * @see BaseCache
 */
@Component
public class RepeatReadCache extends BaseCache {
    public RepeatReadCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    /**
     * 将消息存入redis
     *
     * @param groupId 群组id
     * @return {@link String}
     */
    public void put(Long groupId, RepeatReadRedisDto dto) {
        RepeatReadRedisKeyShamEnum shamEnum = new RepeatReadRedisKeyShamEnum(groupId);
        super.set(shamEnum, JSON.toJSONString(dto));
    }

    /**
     * 获取消息对象
     *
     * @param groupId 群组id
     * @return {@link RepeatReadRedisDto}
     */
    public RepeatReadRedisDto get(Long groupId) {
        RepeatReadRedisKeyShamEnum shamEnum = new RepeatReadRedisKeyShamEnum(groupId);
        return JSON.parseObject(super.get(shamEnum), RepeatReadRedisDto.class);
    }


}

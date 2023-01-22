package com.dasoops.dasserver.plugin.setu.cache;

import com.dasoops.common.cache.BaseCache;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Title: SetuConfig
 * @ClassPath com.dasoops.dasserver.plugin.setu.cache.SetuConfig
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/22
 * @Version 1.0.0
 * @Description: setu配置
 */
@Component
public class SetuCache extends BaseCache {

    public SetuCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    /**
     * 获取群组r18配置
     *
     * @return
     */
    public Integer getDefaultR18(Long groupId) {
        return 1;
    }
}

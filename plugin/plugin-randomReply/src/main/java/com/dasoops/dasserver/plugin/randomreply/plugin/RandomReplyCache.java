package com.dasoops.dasserver.plugin.randomreply.plugin;

import com.alibaba.fastjson2.JSON;
import com.dasoops.common.cache.BaseCache;
import com.dasoops.dasserver.plugin.log.entity.dbo.MessageDo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title RandomReplyCache
 * @classPath com.dasoops.dasserver.plugin.randomreply.plugin.RandomReplyCache
 * @date 2023/03/01
 * @description 随机回复缓存
 */
@Component
public class RandomReplyCache extends BaseCache {
    public RandomReplyCache(StringRedisTemplate redis) {
        super(redis);
    }

    public void setLastInfo(MessageDo messageDo) {
        super.set(RandomReplyCacheKey.LAST_INFO, JSON.toJSONString(messageDo));
    }

    public MessageDo getLastInfo() {
        return JSON.parseObject(super.get(RandomReplyCacheKey.LAST_INFO), MessageDo.class);
    }
}

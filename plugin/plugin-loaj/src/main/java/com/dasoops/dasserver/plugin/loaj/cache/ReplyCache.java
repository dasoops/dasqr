package com.dasoops.dasserver.plugin.loaj.cache;

import com.dasoops.common.cache.BaseCache;
import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajRedisKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Title: ReplyCache
 * @ClassPath com.dasoops.dasserver.plugin.loaj.cache.ReplyCache
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: 回复消息 缓存
 * @see BaseCache
 */
@Component
@Slf4j
public class ReplyCache extends BaseCache {
    public ReplyCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    public void setReplyMap(Map<String, String> replyMap) {
        super.hset(LoajRedisKeyEnum.REPLY_KEYWORD_OTO_REPLY_MAP, replyMap);
    }

    public void getReply(String keyword) {
        super.hget(LoajRedisKeyEnum.REPLY_KEYWORD_OTO_REPLY_MAP, keyword);
    }
}

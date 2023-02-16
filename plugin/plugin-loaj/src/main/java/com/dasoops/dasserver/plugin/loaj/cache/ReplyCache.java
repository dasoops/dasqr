package com.dasoops.dasserver.plugin.loaj.cache;

import com.alibaba.fastjson2.JSON;
import com.dasoops.common.cache.BaseCache;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ReplyRedisValueDto;
import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajRedisKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @title ReplyCache
 * @classPath com.dasoops.dasserver.plugin.loaj.cache.ReplyCache
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/09
 * @version 1.0.0
 * @description 回复消息 缓存
 * @see BaseCache
 */
@Component
@Slf4j
public class ReplyCache extends BaseCache {
    public ReplyCache(StringRedisTemplate stringRedisTemplate) {
        super(stringRedisTemplate);
    }

    public void setReplySet(Set<ReplyRedisValueDto> dtoSet) {
        super.remove(LoajRedisKeyEnum.REPLY_KEYWORD_OTO_REPLY_SET);
        Set<String> valueSet = dtoSet.stream().map(JSON::toJSONString).collect(Collectors.toSet());
        super.sadd(LoajRedisKeyEnum.REPLY_KEYWORD_OTO_REPLY_SET, valueSet);
    }

    public ReplyRedisValueDto getReply(String keyword) {
        String replyDtoJSONString = super.hget(LoajRedisKeyEnum.REPLY_KEYWORD_OTO_REPLY_SET, keyword);
        return JSON.parseObject(replyDtoJSONString, ReplyRedisValueDto.class);
    }

    public Set<ReplyRedisValueDto> getAllReply() {
        Set<String> valueSet = super.members(LoajRedisKeyEnum.REPLY_KEYWORD_OTO_REPLY_SET);
        return valueSet.stream().map(jsonString -> JSON.parseObject(jsonString, ReplyRedisValueDto.class)).collect(Collectors.toSet());
    }

    public void addreply(ReplyRedisValueDto dto) {
        super.sadd(LoajRedisKeyEnum.REPLY_KEYWORD_OTO_REPLY_SET, JSON.toJSONString(dto));
    }

    public void clear() {
        super.remove(LoajRedisKeyEnum.REPLY_KEYWORD_OTO_REPLY_SET);
    }
}

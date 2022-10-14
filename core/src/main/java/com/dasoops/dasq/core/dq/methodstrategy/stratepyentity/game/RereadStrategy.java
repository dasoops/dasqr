package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.game;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.dq.methodstrategy.entity.enums.DqRedisKeyEnum;
import com.dasoops.dasq.core.cq.service.CqService;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Title: ReReadStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.game.ReReadStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: 复读策略
 */
@Component
public class RereadStrategy extends BaseMethodStrategy {

    /**
     * 初始化 复读消息
     */
    public void init() {
        Set<String> keys = redisTemplate.keys(DqRedisKeyEnum.REREAD.getRedisKey() + "*");
        if (keys != null) {
            redisTemplate.delete(keys);
        }
    }

    public void invokeReread(JSONObject paramObj) {
        final int rereadThreshold = 3;

        //非群聊不记录
        boolean group = EventUtil.isGroup(paramObj);
        if (!group) {
            return;
        }

        //获取群聊id
        String message = paramObj.getString(CqKeywordEnum.MESSAGE.getOtherName());
        Long groupId = EventUtil.getGroupId(paramObj);

        //构建redisKey
        String messageKey = DqRedisKeyEnum.REREAD.getRedisKey() + ":" + groupId + ":" + DqRedisKeyEnum.REREAD_MESSAGE;
        String messageCountKey = DqRedisKeyEnum.REREAD.getRedisKey() + ":" + groupId + ":" + DqRedisKeyEnum.REREAD_MESSAGE_COUNT;

        //获取最新消息
        String lastMessage = redisTemplate.opsForValue().get(messageKey);

        //首条消息/非复读消息记录
        if (lastMessage == null || !lastMessage.equals(message)) {
            redisTemplate.opsForValue().set(messageKey, message);
            redisTemplate.opsForValue().set(messageCountKey, "1");
        }

        //复读消息
        String count = redisTemplate.opsForValue().get(messageCountKey);
        if (count == null) {
            redisTemplate.opsForValue().set(messageCountKey, "1");
            return;
        }

        if (Integer.parseInt(count) >= rereadThreshold) {
            //禁止反复重复
            redisTemplate.opsForValue().set(messageCountKey, "-10");
            cqService.sendMsg(true, groupId, message);
        }

        redisTemplate.opsForValue().increment(messageCountKey);


    }

}

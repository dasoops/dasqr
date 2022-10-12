package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.game;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.cq.methodstrategy.entity.enums.DqRedisKeyEnum;
import com.dasoops.dasq.core.cq.service.CqService;
import jdk.jfr.Event;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Title: ReReadStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.game.ReReadStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: 复读策略
 */
@Component
public class RereadStrategy {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    StringRedisTemplate redisTemplate;
    @Resource
    private CqService cqService;

    public void invokeReread(JSONObject paramObj) {
        final int rereadThreshold = 3;

        //非群聊不记录
        boolean group = EventUtil.isGroup();
        if (!group) {
            return;
        }

        //获取群聊id
        String message = paramObj.getString(CqKeywordEnum.MESSAGE.getOtherName());
        EventInfo eventInfo = EventUtil.get();
        Long groupId = eventInfo.getGroupId();

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

        if (Integer.parseInt(count) >= rereadThreshold - 1) {
            //禁止反复重复
            redisTemplate.opsForValue().set(messageCountKey, "-10");
            cqService.sendMsg(message);
        }

        redisTemplate.opsForValue().increment(messageCountKey);


    }

}

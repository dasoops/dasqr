package com.dasoops.dasserver.plugin.loaj.plugin;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.bot.PassObj;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajKeyEnum;
import com.dasoops.dasserver.plugin.loaj.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Title: rollPlugin
 * @ClassPath com.dasoops.dasserver.plugin.loaj.plugin.rollPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/04
 * @Version 1.0.0
 * @Description: roll点插件
 */
@Component
@Slf4j
public class RelayPlugin extends CqPlugin {

    private final StringRedisTemplate stringRedisTemplate;

    public RelayPlugin(@SuppressWarnings("all") StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    private PassObj onMessage(CqTemplate cqTemplate, CqMessageEvent event) {
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(LoajKeyEnum.REPLY.getKey());

        String message = event.getMessage();
        if (entries.containsKey(message)) {
            cqTemplate.sendMsg(event, (String) entries.get(message));
            return PassObj.block();
        }

        return PassObj.pass(event);
    }
}

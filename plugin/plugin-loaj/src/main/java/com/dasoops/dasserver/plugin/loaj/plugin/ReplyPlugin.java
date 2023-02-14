package com.dasoops.dasserver.plugin.loaj.plugin;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.plugin.loaj.cache.ReplyCache;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ReplyRedisValueDto;
import com.dasoops.dasserver.plugin.loaj.utils.MatchUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

/**
 * @title: rollPlugin
 * @classPath com.dasoops.dasserver.plugin.loaj.plugin.rollPlugin
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/04
 * @version 1.0.0
 * @description 回复插件
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ReplyPlugin extends CqPlugin {



    private final ReplyCache replyCache;

    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    public PassObj onMessage(CqTemplate cqTemplate, CqMessageEvent event) {
        String message = event.getMessage();
        Set<ReplyRedisValueDto> allReply = replyCache.getAllReply();
        Optional<ReplyRedisValueDto> replyDtoOpt = allReply.stream().filter(dto -> MatchUtil.match(message, dto)).findFirst();
        if (replyDtoOpt.isEmpty()) {
            return PassObj.pass(event);
        }
        cqTemplate.sendMsg(event, replyDtoOpt.get().getReply());
        return PassObj.block();
    }
}

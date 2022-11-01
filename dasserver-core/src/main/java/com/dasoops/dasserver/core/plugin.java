package com.dasoops.dasserver.core;

import com.alibaba.fastjson2.JSON;
import com.dasoops.cq.CqPlugin;
import com.dasoops.cq.bot.CqTemplate;
import com.dasoops.cq.bot.PassObj;
import com.dasoops.cq.entity.event.message.CqPrivateMessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class plugin extends CqPlugin {
    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        log.info(JSON.toJSONString(event));
        return super.onPrivateMessage(cqTemplate, event);
    }
}

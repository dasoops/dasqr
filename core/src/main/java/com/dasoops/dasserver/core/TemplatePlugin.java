package com.dasoops.dasserver.core;

import com.dasoops.cq.CqPlugin;
import com.dasoops.cq.bot.CqTemplate;
import com.dasoops.cq.bot.PassObj;
import com.dasoops.cq.entity.event.message.CqPrivateMessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: plugin
 * @ClassPath com.dasoops.dasserver.core.plugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 插件
 * @see CqPlugin
 */
@Component
@Slf4j
public class TemplatePlugin extends CqPlugin {
    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        log.info("你收到了一条消息:{} --来自TemplatePlugin", event.getMessage());
        return super.onPrivateMessage(cqTemplate, event);
    }
}

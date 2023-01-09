package com.dasoops.dasserver.core;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqPrivateMessageEvent;
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
        return PassObj.pass(event);
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return super.onGroupMessage(cqTemplate, event);
    }

}

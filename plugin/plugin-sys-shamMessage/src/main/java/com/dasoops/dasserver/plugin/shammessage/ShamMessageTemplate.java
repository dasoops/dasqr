package com.dasoops.dasserver.plugin.shammessage;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.EventUtil;
import com.dasoops.dasserver.cq.bot.EventHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: ShamMessageTemplate
 * @ClassPath com.dasoops.dasserver.plugin.shammessage.ShamMessageTemplate
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/18
 * @Version 1.0.0
 * @Description: 虚假信息Template
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ShamMessageTemplate {

    private final EventHandler eventHandler;

    public void sendMsg(String message) {
        JSONObject rawEventJson = EventUtil.get().getRawEventJson();
        rawEventJson.put("message", message);
        rawEventJson.put("raw_message", message);
        this.sendMsg(CqGlobal.get(), rawEventJson);
    }

    public void sendMsg(CqTemplate cqTemplate, JSONObject rawEventJson) {
        eventHandler.handle(cqTemplate, rawEventJson);
    }

}

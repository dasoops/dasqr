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
 * @title ShamMessageTemplate
 * @classPath com.dasoops.dasserver.plugin.shammessage.ShamMessageTemplate
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/18
 * @version 1.0.0
 * @description 虚假信息Template
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ShamMessageTemplate {

    private final EventHandler eventHandler;

    /**
     * 发送虚假消息(需EventUtil初始化)
     *
     * @param message 消息
     */
    public void sendMsg(String message) {
        JSONObject rawEventJson = EventUtil.get().getRawEventJson();
        rawEventJson.put("message", message);
        rawEventJson.put("raw_message", message);
        this.sendMsg(CqGlobal.get(), rawEventJson);
    }

    /**
     * 发送虚假消息(需EventUtil初始化)
     *
     * @param cqTemplate
     * @param rawEventJson
     */
    public void sendMsg(CqTemplate cqTemplate, JSONObject rawEventJson) {
        eventHandler.handle(cqTemplate, rawEventJson);
    }

//    public void sendMsg(CqTemplate cqTemplate, JSONObject rawEventJson) {
//        eventHandler.handle(cqTemplate, rawEventJson);
//    }

}

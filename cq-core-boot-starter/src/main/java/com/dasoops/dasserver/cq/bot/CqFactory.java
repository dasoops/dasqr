package com.dasoops.dasserver.cq.bot;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.DefaultCqTemplate;
import com.dasoops.dasserver.cq.api.ApiHandler;
import org.springframework.web.socket.WebSocketSession;

/**
 * @title CqTemplateFactor
 * @classPath com.dasoops.dasserver.cq.bot.CqTemplateFactor
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description cq工厂
 */
public class CqFactory {
    private final ApiHandler apiHandler;

    public CqFactory(ApiHandler apiHandler) {
        this.apiHandler = apiHandler;
    }

    public CqTemplate create(Long selfId, WebSocketSession webSocketSession) {
        return new DefaultCqTemplate(selfId, webSocketSession, apiHandler);
    }
}

package com.dasoops.dasserver.cq.bot;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.api.ApiHandler;
import org.springframework.web.socket.WebSocketSession;

/**
 * @Title: CqTemplateFactor
 * @ClassPath com.dasoops.dasserver.cq.bot.CqTemplateFactor
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq工厂
 */
public class CqFactory {
    private final ApiHandler apiHandler;

    public CqFactory(ApiHandler apiHandler) {
        this.apiHandler = apiHandler;
    }
    public CqTemplate create(Long selfId, WebSocketSession webSocketSession) {
        return new CqTemplate(selfId, webSocketSession, apiHandler);
    }
}

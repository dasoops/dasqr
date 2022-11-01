package com.dasoops.cq.bot;

import com.dasoops.cq.CqPlugin;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

/**
 * @Title: CqTemplateFactor
 * @ClassPath com.dasoops.cq.bot.CqTemplateFactor
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq工厂
 */
@Service
public class CqFactory {

    private final ApiHandler apiHandler;

    private final List<Class<? extends CqPlugin>> pluginList;

    public CqFactory(ApiHandler apiHandler, List<Class<? extends CqPlugin>> pluginList) {
        this.apiHandler = apiHandler;
        this.pluginList = pluginList;
    }

    public CqTemplate create(long selfId, WebSocketSession webSocketSession) {
        return new CqTemplate(selfId, webSocketSession, apiHandler, pluginList);
    }

}

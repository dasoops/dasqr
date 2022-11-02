package com.dasoops.dasserver.cq.bot;

import com.dasoops.dasserver.cq.CqPlugin;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

/**
 * @Title: CqTemplate
 * @ClassPath com.dasoops.dasserver.cq.bot.CqTemplate
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/20
 * @Version 1.0.0
 * @Description: cq对外暴露模板类, 提供cq消息发送
 */
@Data
public class CqTemplate {

    private WebSocketSession session;
    private ApiHandler apiHandler;
    private List<Class<? extends CqPlugin>> pluginList;
    private long selfId;

    public CqTemplate(long selfId, WebSocketSession session, ApiHandler apiHandler, List<Class<? extends CqPlugin>> pluginList) {
        this.selfId = selfId;
        this.session = session;
        this.apiHandler = apiHandler;
        this.pluginList = pluginList;
    }

}

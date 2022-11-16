package com.dasoops.dasserver.cq.websocket;

import com.dasoops.dasserver.cq.bot.CqTemplate;

/**
 * @Title: WsWrapper
 * @ClassPath com.dasoops.dasserver.cq.websocket.WsWrapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/15
 * @Version 1.0.0
 * @Description: ws增强
 */
public interface WsWrapper {

    /**
     * 连接建立后增强
     *
     * @param cqTemplate cqTemplate
     */
    void afterConnectionEstablishedWrapper(CqTemplate cqTemplate);

    /**
     * 连接关闭后增强
     *
     * @param cqTemplate cqTemplate
     */
    void afterConnectionClosedWrapper(CqTemplate cqTemplate);

}

package com.dasoops.dasserver.cq.wrapper;

import com.dasoops.dasserver.cq.CqTemplate;
import org.springframework.scheduling.annotation.Async;

/**
 * @Title: WsWrapper
 * @ClassPath com.dasoops.dasserver.cq.wrapper.WsWrapper
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
    @Async
    void afterConnectionEstablishedWrapper(CqTemplate cqTemplate);

    /**
     * 连接关闭后增强
     *
     * @param cqTemplate cqTemplate
     */
    @Async
    void afterConnectionClosedWrapper(CqTemplate cqTemplate);

    /**
     * 获取排序
     *
     * @return {@link Integer}
     */
    Integer getOrder();
}

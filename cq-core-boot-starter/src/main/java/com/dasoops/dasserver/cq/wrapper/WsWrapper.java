package com.dasoops.dasserver.cq.wrapper;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.utils.entity.EventInfo;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

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
     * @return {@link CompletableFuture}<{@link Void}>
     */
    @Async
    default void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {

    }

    /**
     * 连接关闭后增强
     *
     * @param cqTemplate cqTemplate
     * @return {@link CompletableFuture}<{@link Void}>
     */
    @Async
    default void afterConnectionClosedWrapper(CqTemplate cqTemplate) {

    }

    /**
     * 处理消息前
     *
     * @param cqTemplate cqTemplate
     * @param eventInfo  事件信息
     * @return boolean 返回true是放行,false是阻塞
     */
    default boolean beforeHandleTextMessage(CqTemplate cqTemplate, EventInfo eventInfo) {
        return true;
    }

    /**
     * 获取排序
     *
     * @return {@link Integer}
     */
    Integer getOrder();

    /**
     * 获取初始化是否完成
     *
     * @return boolean
     */
    Boolean getInitIsCompleted();
}

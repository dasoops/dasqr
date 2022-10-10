package com.dasoops.dasq.core.cq.service;

/**
 * @Title: CqService
 * @ClassPath com.dasoops.dasq.core.cq.service.CqService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: cq服务
 */
public interface CqService {
    /**
     * 发送消息
     *
     * @param isGroup   是否为群聊消息
     * @param receiveId 发送对象id
     * @param msg       消息
     * @return {@link Long}
     */
    Long sendMsg(Boolean isGroup, Long receiveId, String msg);

    /**
     * 发送消息
     *
     * @param msg 消息
     * @return {@link Long}
     */
    Long sendMsg(String msg);
}

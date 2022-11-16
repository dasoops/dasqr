package com.dasoops.dasserver.cq.bot;

/**
 * @Title: EventWrapper
 * @ClassPath com.dasoops.dasserver.cq.bot.EventWrapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/15
 * @Version 1.0.0
 * @Description: 事件增强
 */
public interface AuthWrapper {

    /**
     * 身份验证
     *
     * @return boolean
     */
    boolean auth();

}

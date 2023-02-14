package com.dasoops.dasserver.cq.wrapper;

/**
 * @title: EventWrapper
 * @classPath com.dasoops.dasserver.cq.bot.EventWrapper
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/15
 * @version 1.0.0
 * @description 事件增强
 */
public interface AuthWrapper {

    /**
     * 身份验证
     *
     * @param classPath 类路径
     * @return boolean
     */

    boolean auth(String classPath);

    /**
     * 获取排序
     *
     * @return {@link Integer}
     */
    Integer getOrder();
}

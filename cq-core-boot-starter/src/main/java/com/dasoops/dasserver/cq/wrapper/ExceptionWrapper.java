package com.dasoops.dasserver.cq.wrapper;

import com.dasoops.dasserver.cq.CqTemplate;

/**
 * @title: ExceptionHandlerReinforced
 * @classPath com.dasoops.common.exception.handler.ExceptionHandlerReinforced
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/08
 * @version 1.0.0
 * @description 异常处理程序增强
 */
public interface ExceptionWrapper {

    /**
     * 执行增强
     *
     * @param e e
     */
    void invoke(CqTemplate cqTemplate, Exception e);

    /**
     * 获取排序
     *
     * @return {@link Integer}
     */
    Integer getOrder();
}

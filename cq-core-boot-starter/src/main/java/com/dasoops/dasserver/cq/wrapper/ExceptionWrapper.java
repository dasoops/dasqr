package com.dasoops.dasserver.cq.wrapper;

import com.dasoops.dasserver.cq.CqTemplate;

/**
 * @Title: ExceptionHandlerReinforced
 * @ClassPath com.dasoops.common.exception.handler.ExceptionHandlerReinforced
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: 异常处理程序增强
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

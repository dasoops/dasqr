package com.dasoops.dasserver.cq.exception.wrapper;

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
    void invoke(Exception e);
}

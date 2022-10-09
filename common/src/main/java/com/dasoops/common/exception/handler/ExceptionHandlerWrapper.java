package com.dasoops.common.exception.handler;

/**
 * @Title: ExceptionHandlerReinforced
 * @ClassPath com.dasoops.common.exception.handler.ExceptionHandlerReinforced
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: 异常处理程序增强
 */
public interface ExceptionHandlerWrapper {

    /**
     * 处理前执行
     *
     * @param id id
     */
    default void before(Long id) {

    }

    /**
     * 处理后执行
     *
     * @param id id
     */
    default void after(Long id){

    }

}

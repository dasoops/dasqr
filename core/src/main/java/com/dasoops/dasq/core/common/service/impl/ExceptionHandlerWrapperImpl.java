package com.dasoops.dasq.core.common.service.impl;

import com.dasoops.common.exception.handler.ExceptionHandlerWrapper;

/**
 * @Title: ExceptionHandlerReinforcedImpl
 * @ClassPath com.dasoops.dasq.core.conf.ExceptionHandlerReinforcedImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: 异常处理程序增强实现
 * @see ExceptionHandlerWrapper
 */
public class ExceptionHandlerWrapperImpl implements ExceptionHandlerWrapper {
    @Override
    public void after(Long id) {
        //todo 向用户/群组 发送错误id
    }
}

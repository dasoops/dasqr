package com.dasoops.dasserver.core;

import com.dasoops.core.exception.BaseCustomException;
import com.dasoops.core.util.Assert;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.exception.wrapper.ExceptionWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Title: ExceptionHandler
 * @ClassPath com.dasoops.dasserver.core.ExceptionHandler
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: 异常处理程序
 */
@Slf4j
@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    private final CqProperties cqProperties;
    private final ExceptionWrapper exceptionWrapper;

    public GlobalExceptionHandler(CqProperties cqProperties, @Autowired(required = false) ExceptionWrapper exceptionWrapper) {
        this.cqProperties = cqProperties;
        this.exceptionWrapper = exceptionWrapper;
    }

    /**
     * 逻辑异常处理
     *
     * @param e e
     */
    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e) {
        try {
            //异常处理
            Assert.isTrue(cqProperties.isConsolePrintStack(), () -> {
                Assert.isTrueOrElse(cqProperties.isNativePrintStack(), e::printStackTrace, () -> {
                    if (e instanceof BaseCustomException) {
                        log.error("消息处理发生异常: {}", ((BaseCustomException) e).getStackMessage());
                    } else {
                        log.error("消息处理发生异常: ", e);
                    }
                });
            });
            Assert.notNull(exceptionWrapper, () -> exceptionWrapper.invoke(e));
        } catch (Exception e2) {
            log.error("Exception at ExceptionHandler", e2);
        }
    }
}

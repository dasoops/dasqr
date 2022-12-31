package com.dasoops.dasserver.core;

import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.enums.IExceptionEnum;
import com.dasoops.common.entity.vo.result.SimpleResult;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.exception.wrapper.ExceptionWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title: GlobalExceptionHandler
 * @ClassPath com.dasoops.dasserver.core.GlobalExceptionHandler
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 全局异常处理程序
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
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public SimpleResult exceptionHandler(Exception e) {
        try {
            if (cqProperties.isConsolePrintStack()) {
                //异常处理
                if (cqProperties.isNativePrintStack()) {
                    e.printStackTrace();
                } else {
                    if (e instanceof LogicException) {
                        IExceptionEnum exceptionEnum = ((LogicException) e).getExceptionEnum();
                        log.error("消息处理发生异常: {}", ((LogicException) e).getStackMessage());
                        return SimpleResult.fail(exceptionEnum);
                    } else {
                        log.error("消息处理发生异常: ", e);
                    }
                }
            }
//            CqAssert.ifNotNull(exceptionWrapper, () -> exceptionWrapper.invoke(e));
        } catch (Exception e2) {
            log.error("Exception at ExceptionHandler", e2);
            return SimpleResult.fail(ExceptionEnum.UN_EXPECTED);
        }
        return SimpleResult.fail(ExceptionEnum.UN_EXPECTED);
    }
}

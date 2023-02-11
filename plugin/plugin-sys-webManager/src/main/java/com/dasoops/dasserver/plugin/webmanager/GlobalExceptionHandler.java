package com.dasoops.dasserver.plugin.webmanager;

import com.dasoops.common.config.BaseExceptionHandler;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.enums.base.IExceptionEnum;
import com.dasoops.common.entity.result.SimpleResult;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Title: GlobalExceptionHandler
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.GlobalExceptionHandler
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 全局异常处理程序
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends BaseExceptionHandler {

    private final CqProperties cqProperties;

    public GlobalExceptionHandler(CqProperties cqProperties) {
        this.cqProperties = cqProperties;
    }

    /**
     * 逻辑异常处理
     *
     * @param e e
     */
    @Override
    @ExceptionHandler(LogicException.class)
    public SimpleResult catchLogicException(LogicException e) {
        if (cqProperties.isConsolePrintStack()) {
            //异常处理
            if (cqProperties.isNativePrintStack()) {
                e.printStackTrace();
            } else {
                log.error("消息处理发生异常: {}", e.getStackMessage());
                IExceptionEnum exceptionEnum = e.getExceptionEnum();
                return SimpleResult.fail(exceptionEnum);
            }
        }
        return SimpleResult.fail(ExceptionEnum.UN_EXPECTED);
    }

    /**
     * 逻辑异常处理
     *
     * @param e e
     */
    @Override
    @ExceptionHandler(Exception.class)
    public SimpleResult exceptionHandler(Exception e) {
        if (cqProperties.isConsolePrintStack()) {
            //异常处理
            if (cqProperties.isNativePrintStack()) {
                e.printStackTrace();
            } else {
                log.error("消息处理发生异常: ", e);
            }
        }
        return SimpleResult.fail(ExceptionEnum.UN_EXPECTED);
    }

    @Override
    public SimpleResult catchHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return super.catchHttpMessageNotReadableException(e);
    }
}
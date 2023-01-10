package com.dasoops.dasserver.core;

import com.dasoops.common.config.BaseExceptionHandler;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.enums.IExceptionEnum;
import com.dasoops.common.entity.vo.result.SimpleResult;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public SimpleResult exceptionHandler(Exception e) {
        try {
            if (cqProperties.isConsolePrintStack()) {
                //异常处理
                if (cqProperties.isNativePrintStack()) {
                    e.printStackTrace();
                } else {
                    if (e instanceof LogicException tempE) {
                        IExceptionEnum exceptionEnum = tempE.getExceptionEnum();
                        log.error("消息处理发生异常: {}", tempE.getStackMessage());
                        return SimpleResult.fail(exceptionEnum);
                    } else if (e instanceof HttpMessageNotReadableException) {
                        return SimpleResult.fail(ExceptionEnum.PARAMETER_RESLOVE_ERROR);
                    } else {
                        log.error("消息处理发生异常: ", e);
                    }
                }
            }
//            CqAssert.getInstance()ifNotNull(exceptionWrapper, () -> exceptionWrapper.invoke(e));
        } catch (Exception e2) {
            log.error("Exception at ExceptionHandler", e2);
            return SimpleResult.fail(ExceptionEnum.UN_EXPECTED);
        }
        return SimpleResult.fail(ExceptionEnum.UN_EXPECTED);
    }
}

package com.dasoops.common.config;

import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.vo.result.SimpleResult;
import lombok.extern.slf4j.Slf4j;
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
public class BaseExceptionHandler {

    /**
     * 逻辑异常处理
     *
     * @param e e
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public SimpleResult exceptionHandler(Exception e) {
        log.error("catch Exception: ", e);
        return SimpleResult.fail(ExceptionEnum.UN_EXPECTED);
    }
}

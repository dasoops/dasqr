package com.dasoops.common.exception.handler;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.alibaba.fastjson2.JSON;
import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.service.ExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import java.net.http.HttpRequest;

/**
 * @Title: GlobalExceptionHandler
 * @ClassPath com.dasoops.dasq.common.exception.handler.GlobalExceptionHandler
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: 全局异常处理程序
 */
@Slf4j
@Component
@ControllerAdvice
public class GlobalExceptionHandler implements ApplicationContextAware {

    @Value("${dasq.consolePrintStack}")
    private boolean consolePrintStack;
    @Resource
    private ExceptionService exceptionService;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 逻辑异常处理
     *
     * @param e e
     */
    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e, HttpRequest request) {
        try {
            log.error("request:{}", JSON.toJSONString(request));
            Long id = System.currentTimeMillis();
            log.error("Exception:errorMsg:", e);
            resolve(e, id);
        } catch (Exception e2) {
            log.error("Exception at ExceptionHandler", e2);
        }
    }

    /**
     * 异常处理
     *
     * @param e e
     */
    @ExceptionHandler(LogicException.class)
    public void logicExceptionHandler(LogicException e) {
        try {
            Long id = e.getId();
            log.error("LogicException:errorId:{}, errorCode:{}", id, e.getCode());
            resolve(e, id);
        } catch (Exception e2) {
            log.error("Exception at ExceptionHandler", e2);
        }
    }


    private void resolve(Exception e, Long id) {
        ExceptionHandlerWrapper reinforcedBean;
        try {
            reinforcedBean = applicationContext.getBean(ExceptionHandlerWrapper.class);
        } catch (BeansException ex) {
            reinforcedBean = null;
        }

        if (reinforcedBean != null) {
            //执行前方法
            reinforcedBean.before(id);
        }

        //执行redis存储
        String message = ExceptionUtil.stacktraceToString(e);
        exceptionService.saveException(String.valueOf(id), message);
        if (consolePrintStack) {
            e.printStackTrace();
        }

        if (reinforcedBean != null) {
            //执行后方法
            reinforcedBean.after(id);
        }
    }

}
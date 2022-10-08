package com.dasoops.common.exception.handler;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.dasoops.common.entity.enums.RedisKeyEnum;
import com.dasoops.common.exception.entity.LogicException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;

/**
 * @Title: GlobalExceptionHandler
 * @ClassPath com.dasoops.dasq.common.exception.handler.GlobalExceptionHandler
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/08
 * @Version 1.0.0
 * @Description: 全局异常处理程序
 */
@Slf4j
public class GlobalExceptionHandler implements ApplicationContextAware {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    StringRedisTemplate redisTemplate;

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
    @ExceptionHandler(LogicException.class)
    public void logicExceptionHandler(LogicException e) {
        Long id = e.getId();
        log.error("LogicException:errorId:{}, errorCode:{}", id, e.getCode());
        ExceptionHandlerReinforced reinforcedBean;
        try {
            reinforcedBean = applicationContext.getBean(ExceptionHandlerReinforced.class);
        } catch (BeansException ex) {
            reinforcedBean = null;
        }

        if (reinforcedBean != null) {
            //执行前方法
            reinforcedBean.before(id);
        }

        //执行redis存储
        String message = ExceptionUtil.stacktraceToString(e);
        redisTemplate.opsForHash().put(RedisKeyEnum.CORE_ID_GET_EXCEPTION_INFO_JSON.name(), e.getId(), message);

        if (reinforcedBean != null) {
            //执行后方法
            reinforcedBean.after(id);
        }
    }
}
package com.dasoops.dasq.core.common.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.util.WebUtil;
import com.dasoops.dasq.core.dq.methodstrategy.entity.enums.DqRedisKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: UndoInterceptor
 * @ClassPath com.dasoops.dasq.core.common.interceptor.UndoInterceptor
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/19
 * @Version 1.0.0
 * @Description: 撤销拦截器
 */
@Component
@Slf4j
public class UndoRecordInterceptor implements HandlerInterceptor {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {

        //获取消息对象
        JSONObject paramObj = WebUtil.getParameters(request);

        //存入
        String message = paramObj.getString("message");
        String id = paramObj.getString("message_id");
        redisTemplate.opsForHash().put(DqRedisKeyEnum.UNDO_MESSAGE_ID_GET_MESSAGE_MAP.getRedisKey(), id, message);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

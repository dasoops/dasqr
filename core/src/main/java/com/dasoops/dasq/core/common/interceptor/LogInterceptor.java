package com.dasoops.dasq.core.common.interceptor;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: LogInterceptor
 * @ClassPath com.dasoops.dasq.core.common.interceptor.LogInterceptor
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: 记录拦截器
 * @see HandlerInterceptor
 * @see Ordered
 */
@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor, Ordered {


    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        JSONObject paramObj = WebUtil.getParameters(request);

        log.info("接收到消息:{}", JSON.toJSONString(paramObj));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public int getOrder() {
        return 4;
    }

}

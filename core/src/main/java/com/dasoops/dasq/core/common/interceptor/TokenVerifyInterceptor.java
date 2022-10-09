package com.dasoops.dasq.core.common.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.common.util.WebUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Title: TokenVerifyInterceptor
 * @ClassPath com.dasoops.dasq.core.common.interceptor.TokenVerifyInterceptor
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: 令牌验证拦截器
 * @see HandlerInterceptor
 * @see Ordered
 */
@Component
@Slf4j
public class TokenVerifyInterceptor implements HandlerInterceptor, Ordered {

    //todo 待完善

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public int getOrder() {
        return 2;
    }

}

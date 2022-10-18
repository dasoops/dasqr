package com.dasoops.dasq.core.common.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.entity.enums.KeywordEnum;
import com.dasoops.dasq.core.common.util.WebUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.sys.StyleStrategy;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: PassListInterceptor
 * @ClassPath com.dasoops.dasq.core.common.interceptor.PassListInterceptor
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: 通过拦截器列表
 * @see HandlerInterceptor
 * @see Ordered
 */
@Component
@Slf4j
public class CoolStyleInterceptor implements HandlerInterceptor {

    @Resource
    private StyleStrategy styleStrategy;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        //获取消息对象
        JSONObject paramObj = WebUtil.getParameters(request);

        //是否为清爽模式
        if (KeywordEnum.STYLE_NORMAL.getKeyword().equals(styleStrategy.getStyle())) {
            //是否为命令
            if (!this.isCommon(paramObj)) {
                return false;
            }
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }


    /**
     * 是否为命令
     *
     * @param paramObj param obj
     * @return boolean
     */
    public boolean isCommon(JSONObject paramObj) {
        String message = paramObj.getString(CqKeywordEnum.MESSAGE.getOtherName());
        return message.startsWith(".");
    }
}

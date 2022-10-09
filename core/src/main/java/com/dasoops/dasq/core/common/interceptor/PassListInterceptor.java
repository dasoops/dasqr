package com.dasoops.dasq.core.common.interceptor;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.common.util.WebUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.cq.entity.pojo.PassObject;
import com.dasoops.dasq.core.cq.service.PassListService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

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
public class PassListInterceptor implements HandlerInterceptor, Ordered {

    @Resource
    private PassListService passListService;
    @Resource
    private DictionaryService dictionaryService;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        //获取消息对象
        JSONObject paramObj = WebUtil.getParameters(request);
        //获取消息类型id
        String postType = paramObj.getString(CqKeywordEnum.POST_TYPE.getHumpName());

        //消息类型
        final Integer messageTypeCode = 2;
        Optional<List<PassObject>> passListOpt = passListService.getPassListByType(messageTypeCode);
        //在匹配列表中放行
        if (passListOpt.isPresent()) {
            //消息类型匹配,忽略大小写,忽略全半角
            boolean isMatch = passListOpt.get().stream().anyMatch(passObj ->
                    Convert.toDBC(passObj.getPassKeyword()).equalsIgnoreCase(Convert.toDBC(postType))
            );
            if (isMatch) {
                return HandlerInterceptor.super.preHandle(request, response, handler);
            }
        }

        return false;
    }


    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public int getOrder() {
        return 1;
    }

}

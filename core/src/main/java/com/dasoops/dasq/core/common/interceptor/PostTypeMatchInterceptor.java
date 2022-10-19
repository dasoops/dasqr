package com.dasoops.dasq.core.common.interceptor;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.util.WebUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.cq.entity.po.PassObject;
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
public class PostTypeMatchInterceptor implements HandlerInterceptor {

    @Resource
    private PassListService passListService;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        //获取消息对象
        JSONObject paramObj = WebUtil.getParameters(request);

        //go_cqhttp消息类型匹配
        if (!this.postTypeIsMatch(paramObj)) {
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * go_cqhttp消息类型匹配
     *
     * @param paramObj param obj
     * @return boolean
     */
    private boolean postTypeIsMatch(JSONObject paramObj) {
        //获取消息类型id
        String postType = "";
        try {
            postType = paramObj.getString(CqKeywordEnum.POST_TYPE.getOtherName());
        } catch (Exception e) {
            log.info(JSON.toJSONString(paramObj));
            throw e;
        }

        //消息类型
        final Integer messageTypeCode = 2;
        return isMatch(postType, messageTypeCode);
    }

    /**
     * 是否匹配
     *
     * @param keyword         关键字
     * @param messageTypeCode 消息类型编号
     * @return boolean
     */
    private boolean isMatch(String keyword, Integer messageTypeCode) {
        Optional<List<PassObject>> passListOpt = passListService.getPassListByType(messageTypeCode);

        //在匹配列表中放行(只要有一个匹配)
        return passListOpt.map(passObjects -> passObjects.stream().anyMatch(passObj ->
                //消息类型匹配,忽略大小写,忽略全半角
                Convert.toDBC(passObj.getPassKeyword()).equalsIgnoreCase(Convert.toDBC(keyword))
        )).orElse(false);
    }

}

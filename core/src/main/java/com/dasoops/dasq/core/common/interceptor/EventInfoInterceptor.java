package com.dasoops.dasq.core.common.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.common.util.WebUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Title: EventInfoInterceptor
 * @ClassPath com.dasoops.dasq.core.common.interceptor.EventInfoInterceptor
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: 事件信息拦截器
 * @see HandlerInterceptor
 * @see Ordered
 */
@Component
@Slf4j
public class EventInfoInterceptor implements HandlerInterceptor, Ordered {

    @Resource
    private DictionaryService dictionaryService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取消息对象
        JSONObject paramObj = WebUtil.getParameters(request);

        //获取dict集合
        Long id = dictionaryService.getIdByDictCode(CqKeywordEnum.MESSAGE_TYPE.getSimpleName());
        Map<String, String> dict = dictionaryService.getDictionaryMapByFatherId(id);
        //构建事件对象
        EventInfo eventInfo = EventUtil.buildEventInfo(paramObj, dict);
        EventUtil.set(eventInfo);
        //存入本地线程变量threadLocal

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    //todo 拦截器日志保存(暂定mongo)
    //todo 对非cq_http消息进行token校验


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        EventUtil.remove();
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public int getOrder() {
        return 3;
    }

}

package com.dasoops.dasq.core.common.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.common.util.WebUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.image.SaveImageStrategy;
import com.dasoops.dasq.core.image.entity.enums.ImageRedisKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
public class SaveImagePartInterceptor implements HandlerInterceptor {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    private StringRedisTemplate redisTemplate;
    @Resource
    private SaveImageStrategy saveImageStrategy;
    @Resource
    private DictionaryService dictionaryService;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        //获取消息对象
        JSONObject paramObj = WebUtil.getParameters(request);

        //是否为存图part
        if (saveImagePart(paramObj)) {
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    private boolean saveImagePart(JSONObject paramObj) {

        //获取dict集合
        Long id = dictionaryService.getIdByDictCode(CqKeywordEnum.MESSAGE_TYPE.getSimpleName());
        Map<String, String> dict = dictionaryService.getDictionaryMapByFatherId(id);
        //构建事件对象
        EventInfo eventInfo = EventUtil.buildEventInfo(paramObj, dict);
        EventUtil.set(eventInfo);

        String saveImagePart = redisTemplate.opsForValue().getAndDelete(ImageRedisKeyEnum.SAVE_IMAGE_PART.getRedisKey() + (EventUtil.isGroup() ? eventInfo.getGroupId() : eventInfo.getAuthorId()));
        if (saveImagePart == null) {
            return false;
        }
        saveImageStrategy.saveImage(saveImagePart, paramObj.getString(CqKeywordEnum.MESSAGE.getSimpleName()));
        return true;
    }

}

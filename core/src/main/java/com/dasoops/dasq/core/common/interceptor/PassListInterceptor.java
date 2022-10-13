package com.dasoops.dasq.core.common.interceptor;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.entity.enums.KeywordEnum;
import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.common.util.WebUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.cq.entity.po.PassObject;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.game.RereadStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.other.SaveImageStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.sys.StyleStrategy;
import com.dasoops.dasq.core.cq.service.CqService;
import com.dasoops.dasq.core.cq.service.PassListService;
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
import java.util.List;
import java.util.Map;
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
    private RereadStrategy rereadStrategy;
    @Resource
    private StyleStrategy styleStrategy;
    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    private StringRedisTemplate redisTemplate;
    @Resource
    private SaveImageStrategy saveImageStrategy;
    @Resource
    private CqService cqService;
    @Resource
    private DictionaryService dictionaryService;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        //获取消息对象
        JSONObject paramObj = WebUtil.getParameters(request);

        //go_cqhttp消息类型匹配
        if (!this.postTypeIsMatch(paramObj)) {
            return false;
        }

        //是否为存图part
        if (saveImagePart(paramObj)) {
            return false;
        }

        rereadStrategy.invokeReread(paramObj);

        //是否为清爽模式
        if (KeywordEnum.STYLE_NORMAL.getKeyword().equals(styleStrategy.getStyle())) {
            //是否为命令
            if (!this.isCommon(paramObj)) {
                return false;
            }
        }

        if (!this.authorIsMatch(paramObj)) {
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private boolean saveImagePart(JSONObject paramObj) {

        //获取dict集合
        Long id = dictionaryService.getIdByDictCode(CqKeywordEnum.MESSAGE_TYPE.getSimpleName());
        Map<String, String> dict = dictionaryService.getDictionaryMapByFatherId(id);
        //构建事件对象
        EventInfo eventInfo = EventUtil.buildEventInfo(paramObj, dict);
        EventUtil.set(eventInfo);

        String saveImagePart = redisTemplate.opsForValue().getAndDelete(ImageRedisKeyEnum.SAVE_IMAGE_PART.getRedisKey());
        if (saveImagePart == null) {
            return false;
        }
        saveImageStrategy.saveImage(saveImagePart, paramObj.getString(CqKeywordEnum.MESSAGE.getSimpleName()));
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public int getOrder() {
        return 1;
    }

    /**
     * go_cqhttp消息类型匹配
     *
     * @param paramObj param obj
     * @return boolean
     */
    private boolean postTypeIsMatch(JSONObject paramObj) {
        //获取消息类型id
        String postType = paramObj.getString(CqKeywordEnum.POST_TYPE.getOtherName());

        //消息类型
        final Integer messageTypeCode = 2;
        return isMatch(postType, messageTypeCode);
    }

    /**
     * 作者是否匹配
     *
     * @param paramObj param obj
     * @return boolean
     */
    private boolean authorIsMatch(JSONObject paramObj) {

        String messageType = paramObj.getString(CqKeywordEnum.MESSAGE_TYPE.getOtherName());

        if (messageType.equals(CqKeywordEnum.MESSAGE_TYPE_GROUP.getSimpleName())) {
            //群聊消息
            return groupIdIsMatch(paramObj);
        } else if (messageType.equals(CqKeywordEnum.MESSAGE_TYPE_PRIVATE.getSimpleName())) {
            //私聊消息
            return userIdIsMatch(paramObj);
        }

        return false;
    }

    /**
     * 组id是否匹配
     *
     * @param paramObj param obj
     * @return boolean
     */
    private boolean groupIdIsMatch(JSONObject paramObj) {
        String groupId = paramObj.getString(CqKeywordEnum.GROUP_ID.getOtherName());

        //消息类型
        final Integer messageTypeCode = 0;
        return isMatch(groupId, messageTypeCode);
    }


    /**
     * 用户id是否匹配
     *
     * @param paramObj param obj
     * @return boolean
     */
    private boolean userIdIsMatch(JSONObject paramObj) {
        String userId = paramObj.getString(CqKeywordEnum.USER_ID.getOtherName());

        //消息类型
        final Integer messageTypeCode = 1;
        return isMatch(userId, messageTypeCode);
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

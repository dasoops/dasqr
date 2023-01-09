package com.dasoops.dasserver.cq;

import cn.hutool.core.util.EnumUtil;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasserver.cq.entity.enums.CqEventColumnEnum;
import com.dasoops.dasserver.cq.entity.enums.EventTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.PostTypeEnum;
import com.dasoops.dasserver.cq.utils.entity.EventInfo;

/**
 * @Title: EventUtil
 * @ClassPath com.dasoops.dasq.core.common.util.EventUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: 消息工具
 */
public final class EventUtil {

    private static final ThreadLocal<EventInfo> EVENT_INFO_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取
     *
     * @return {@link EventInfo}
     */
    public static EventInfo get() {
        return EVENT_INFO_THREAD_LOCAL.get();
    }

    /**
     * 设置
     *
     * @param eventInfo 事件信息
     */
    public static void set(EventInfo eventInfo) {
        EVENT_INFO_THREAD_LOCAL.set(eventInfo);
    }

    /**
     * 设置
     *
     * @param eventJson eventJson
     */
    public static void set(JSONObject eventJson) {
        set(buildMessageInfo(eventJson));
    }

    /**
     * 清空
     */
    public static void remove() {
        EVENT_INFO_THREAD_LOCAL.remove();
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public static boolean isEmpty() {
        EventInfo eventInfo = EventUtil.get();
        return eventInfo == null;
    }

    /**
     * 构建事件信息
     *
     * @param paramObj param obj
     * @return {@link EventInfo}
     */
    public static EventInfo buildMessageInfo(JSONObject paramObj) {
        EventInfo eventInfo = paramObj.to(EventInfo.class);
        eventInfo.setPostTypeEnum(EnumUtil.getBy(PostTypeEnum::getKey, eventInfo.getPostType()));
        eventInfo.setEventTypeEnum(EnumUtil.getBy(EventTypeEnum::getKey, eventInfo.getMessageType()));
        eventInfo.setAuthorId(paramObj.getLong(CqEventColumnEnum.USER_ID.getKey()));
        return eventInfo;
    }

    /**
     * 是否为群组消息
     *
     * @return boolean
     */
    public static boolean isGroup() {
        EventInfo eventInfo = EventUtil.get();
        Long groupId = eventInfo.getGroupId();
        return groupId == null;
    }
}

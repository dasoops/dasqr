package com.dasoops.dasserver.cq.utils;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
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

    private static final ThreadLocal<EventInfo> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取
     *
     * @return {@link EventInfo}
     */
    public static EventInfo get() {
        return THREAD_LOCAL.get();
    }

    /**
     * 设置
     *
     * @param eventInfo 事件信息
     */
    public static void set(EventInfo eventInfo) {
        THREAD_LOCAL.set(eventInfo);
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
        THREAD_LOCAL.remove();
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
        eventInfo.setAuthorId(paramObj.getLong("user_id"));
        return eventInfo;
    }
}

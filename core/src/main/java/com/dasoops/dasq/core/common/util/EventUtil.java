package com.dasoops.dasq.core.common.util;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.common.entity.EventInfo;

import java.util.Map;

/**
 * @Title: EventUtil
 * @ClassPath com.dasoops.dasq.core.common.util.EventUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: 事件工具
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
     * 清空
     */
    public static void remove() {
        THREAD_LOCAL.remove();
    }

    /**
     * 构建事件信息
     *
     * @param paramObj        param obj
     * @param messageTypeDict 消息类型字典
     * @return {@link EventInfo}
     */
    public static EventInfo buildEventInfo(JSONObject paramObj, Map<String, String> messageTypeDict) {
        EventInfo eventInfo = new EventInfo();
        eventInfo.setTime(paramObj.getLong("time"));
        eventInfo.setAuthorId(paramObj.getLong("user_id"));
        eventInfo.setGroupId(paramObj.getLong("group_id"));
        eventInfo.setMessageId(paramObj.getString("message_id"));

        String messageTypeStr = paramObj.getString("message_type");
        messageTypeDict.entrySet().stream()
                .filter(res -> res.getValue().equals(messageTypeStr))
                .findFirst()
                .ifPresent(res -> eventInfo.setMessageType(Integer.parseInt(res.getKey())));

        return eventInfo;
    }
}

package com.dasoops.dasserver.cq;

import cn.hutool.core.util.EnumUtil;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.entity.enums.CqEventColumnEnum;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
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
    public static EventInfo set(JSONObject eventJson) {
        EventInfo eventInfo = buildMessageInfo(eventJson);
        set(eventInfo);
        return eventInfo;
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
        PostTypeEnum postTypeEnum = EnumUtil.getBy(PostTypeEnum::getKey, eventInfo.getPostType());
        eventInfo.setPostTypeEnum(postTypeEnum);

        String eventType;
        //心跳的messageType键不一样
        switch (postTypeEnum) {
            case MESSAGE, MESSAGE_SENT -> eventType = paramObj.getString(CqEventColumnEnum.MESSAGE_TYPE.getKey());
            case NOTICE -> eventType = paramObj.getString(CqEventColumnEnum.NOTICE_TYPE.getKey());
            case REQUEST -> eventType = paramObj.getString(CqEventColumnEnum.REQUEST_TYPE.getKey());
            case META_EVENT -> eventType = paramObj.getString(CqEventColumnEnum.MESSAGE_EVENT_TYPE.getKey());
            default -> throw new LogicException(CqExceptionEnum.UNKNOWN_POST_TYPE);
        }
        EventTypeEnum eventTypeEnum = EnumUtil.getBy(EventTypeEnum::getKey, eventType);
        eventInfo.setEventTypeEnum(eventTypeEnum);
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

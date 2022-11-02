package com.dasoops.dasserver.cq.entity.event.message;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasserver.cq.entity.entity.CqGroupAnonymous;
import com.dasoops.dasserver.cq.entity.entity.CqGroupUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CqGroupMessageEvent
 * @ClassPath com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 群消息
 * @see CqMessageEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqGroupMessageEvent extends CqMessageEvent {
    /**
     * 消息子类型
     * 正常消息是 normal
     * 匿名消息是 anonymous
     * 系统提示（如「管理员已禁止群内匿名聊天」）是 notice
     */
    @JSONField(name = "sub_type")
    private String subType;
    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private long groupId;
    /**
     * 匿名信息
     * 如果不是匿名消息则为 null
     */
    @JSONField(name = "anonymous")
    private CqGroupAnonymous anonymous;
    /**
     * 发送人信息
     */
    @JSONField(name = "sender")
    private CqGroupUser sender;
}

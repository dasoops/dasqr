package com.dasoops.cq.entity.event.message;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.cq.entity.entity.CqUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: CqPrivateMessageEvent
 * @ClassPath com.dasoops.cq.entity.event.message.CqPrivateMessageEvent
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 私聊消息
 * @see CqMessageEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqPrivateMessageEvent extends CqMessageEvent {
    /**
     * 消息子类型
     * 如果是好友则是 friend
     * 如果从群或讨论组来的临时会话则分别是 group、discuss
     */
    @JSONField(name = "sub_type")
    private String subType;
    /**
     * 发送人信息
     */
    @JSONField(name = "sender")
    private CqUser sender;
}

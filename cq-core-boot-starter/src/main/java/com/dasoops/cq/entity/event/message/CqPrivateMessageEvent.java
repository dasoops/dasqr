package com.dasoops.cq.entity.event.message;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.cq.entity.entity.CqUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 私聊消息
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

package com.dasoops.dasserver.cq.entity.dto.cq.event.request;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.dasserver.cq.entity.dto.cq.event.CqEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: CqRequestEvent
 * @classPath com.dasoops.dasserver.cq.entity.event.request.CqRequestEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description cq请求事件
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqRequestEvent extends CqEvent {
    /**
     * 请求类型
     * group/friend
     */
    @JSONField(name = "request_type")
    private String requestType;
    /**
     * 发送请求的 QQ 号
     */
    @JSONField(name = "user_id")
    private long userId;
    /**
     * 验证信息（可能包含 CQ 码，特殊字符被转义）
     */
    @JSONField(name = "comment")
    private String comment;
    /**
     * 请求 flag，在调用处理请求的 API 时需要传入
     */
    @JSONField(name = "flag")
    private String flag;
}

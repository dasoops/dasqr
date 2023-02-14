package com.dasoops.dasserver.cq.entity.dto.cq.event.notice;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: CqGroupCardNoticeEvent
 * @classPath com.dasoops.dasserver.cq.entity.event.notice.CqGroupCardNoticeEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/18
 * @version 1.0.0
 * @description cq群名片提醒事件
 * @see CqNoticeEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqGroupCardNoticeEvent extends CqNoticeEvent {

    /**
     * 群id
     */
    private Long groupId;

    /**
     * 新名片
     */
    private String cardNew;

    /**
     * 旧名片
     */
    private String cardOld;

}

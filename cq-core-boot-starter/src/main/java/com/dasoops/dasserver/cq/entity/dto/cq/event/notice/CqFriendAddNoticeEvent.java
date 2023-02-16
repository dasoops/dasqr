package com.dasoops.dasserver.cq.entity.dto.cq.event.notice;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title CQFriendAddNoticeEvent
 * @classPath com.dasoops.dasserver.cq.entity.event.notice.CQFriendAddNoticeEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 好友添加
 * @see CqNoticeEvent
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CqFriendAddNoticeEvent extends CqNoticeEvent {
}

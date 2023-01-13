package com.dasoops.dasserver.cq.entity.event.message;

import com.dasoops.common.entity.param.base.BaseParam;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: MessageParam
 * @ClassPath com.dasoops.dasserver.cq.entity.event.message.MessageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/07
 * @Version 1.0.0
 * @Description: 消息param
 * @see BaseParam
 */
@Data
@NoArgsConstructor
public class MessageParam {

    /**
     * 是否为群组消息
     */

    private Boolean isGroup;

    /**
     * 群组id
     */
    private Long groupId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 匹配关键字
     */
    private String matchKeyword;

    public Long getRegisterId() {
        if (isGroup) {
            return groupId;
        }
        return userId;
    }
}
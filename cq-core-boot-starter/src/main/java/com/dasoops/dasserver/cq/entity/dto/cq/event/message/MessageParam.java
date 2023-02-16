package com.dasoops.dasserver.cq.entity.dto.cq.event.message;

import com.dasoops.common.entity.param.base.BaseFastBuildParam;
import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.dasserver.cq.entity.enums.MessageMatchTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title MessageParam
 * @classPath com.dasoops.dasserver.cq.entity.event.message.MessageParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/07
 * @version 1.0.0
 * @description 消息param
 * @see BaseFastBuildParam
 */
@Data
@NoArgsConstructor
public class MessageParam<T extends BaseParam> {

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

    /**
     * 匹配类型
     */
    private MessageMatchTypeEnum matchType;

    /**
     * 原始消息
     */
    private String rawMessage;

    /**
     * 用户输入参数
     */
    private T param;

    public Long getRegisterId() {
        if (isGroup) {
            return groupId;
        }
        return userId;
    }
}
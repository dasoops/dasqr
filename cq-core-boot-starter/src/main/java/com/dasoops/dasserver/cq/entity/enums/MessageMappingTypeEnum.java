package com.dasoops.dasserver.cq.entity.enums;

/**
 * @Title: MessageResloveEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.MessageResloveEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/07
 * @Version 1.0.0
 * @Description: 消息解析 可选类型 枚举
 * @see Enum
 */
public enum MessageMappingTypeEnum {
    /**
     * 私聊消息
     */
    PRIVATE,
    /**
     * 群组消息
     */
    GROUP,
    /**
     * 所有
     */
    ALL,
    /**
     * 依据方法名称调用
     */
    FORM_METHOD_NAME,

}

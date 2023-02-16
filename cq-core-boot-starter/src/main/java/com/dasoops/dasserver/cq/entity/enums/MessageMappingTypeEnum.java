package com.dasoops.dasserver.cq.entity.enums;

/**
 * @title MessageResloveEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.MessageResloveEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/07
 * @version 1.0.0
 * @description 消息解析 可选类型 枚举
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

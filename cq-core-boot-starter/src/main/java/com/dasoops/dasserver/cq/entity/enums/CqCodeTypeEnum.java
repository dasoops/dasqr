package com.dasoops.dasserver.cq.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title CqCodeTypeEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.CqCodeTypeEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/19
 * @version 1.0.0
 * @description cq码类型枚举
 * @see Enum
 */
@AllArgsConstructor
@Getter
public enum CqCodeTypeEnum {


    /**
     * 系统表情
     */
    FACE("face"),

    /**
     * emoji表情
     */
    EMOJI("emoji"),

    /**
     * 原创表情
     */
    BFACE("bface"),

    /**
     * 小表情
     */
    SFACE("sface"),

    /**
     * 自定义图片
     */
    IMAGE("image"),

    /**
     * 语音
     */
    RECORD("record"),

    /**
     * at某人
     */
    AT("at"),

    /**
     * 猜拳魔法表情
     */
    RPS("rps"),

    /**
     * 掷骰子魔法表情
     */
    DICE("dice"),

    /**
     * 戳一戳
     */
    SHAKE("shake"),

    /**
     * 匿名发消息
     */
    ANONYMOUS("anonymous"),

    /**
     * 地点
     */
    LOCATION("location"),

    /**
     * 签到
     */
    SIGN("sign"),

    /**
     * 音乐
     */
    MUSIC("music"),

    /**
     * 音乐自定义分享
     */
    CUSTOM_MUSIC("customMusic"),

    /**
     * 链接分享
     */
    SHARE("share"),

    /**
     * 分享联系人/群
     */
    CONTACT("contact"),
    ;
    final String stringValue;
}

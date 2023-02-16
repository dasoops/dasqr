package com.dasoops.dasserver.cq.entity.annocation;


import com.dasoops.dasserver.cq.entity.enums.EventTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;

import java.lang.annotation.*;


/**
 * @title MessageParamReslove
 * @classPath com.dasoops.dasserver.cq.entity.annocation.MessageParamReslove
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/07
 * @version 1.0.0
 * @description 消息参数解析
 * @see Annotation
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MessageMapping {

    /**
     * 解析哪个消息类型
     *
     * @return {@link EventTypeEnum}
     */
    MessageMappingTypeEnum type() default MessageMappingTypeEnum.FORM_METHOD_NAME;

    /**
     * 前缀
     */
    String[] prefix() default {};

    /**
     * 包含
     */
    String[] contains() default {};

    /**
     * 后缀
     */
    String[] suffix() default {};

    /**
     * 相等
     */
    String[] equal() default {};

    /**
     * 必须@bot
     *
     * @return boolean
     */
    boolean at() default false;

    /**
     * 匹配所有
     * 请注意,匹配所有无法获得matchKeyword,也无法获得参数
     *
     * @return boolean
     */
    boolean matchAll() default false;

    /**
     * 分隔符
     *
     * @return {@link String}
     */
    String separator() default ",";

    /**
     * 是否忽略大小写
     *
     * @return boolean
     */
    boolean ignoreCase() default true;

    /**
     * 是否忽略全角标点
     *
     * @return boolean
     */
    boolean ignoreDbc() default true;

    /**
     * 不以cq中的字符串切分
     *
     * @return boolean
     */
    boolean skipCq() default true;

    /**
     * 消除两边空格
     *
     * @return boolean
     */
    boolean trim() default true;

}

package com.dasoops.dasserver.cq.entity.annocation;


import com.dasoops.dasserver.cq.entity.enums.EventTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;

import java.lang.annotation.*;


/**
 * @Title: MessageParamReslove
 * @ClassPath com.dasoops.dasserver.cq.entity.annocation.MessageParamReslove
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/07
 * @Version 1.0.0
 * @Description: 消息参数解析
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

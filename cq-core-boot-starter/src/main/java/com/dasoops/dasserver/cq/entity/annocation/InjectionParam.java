package com.dasoops.dasserver.cq.entity.annocation;

import java.lang.annotation.*;

/**
 * @title ParamOrder
 * @classPath com.dasoops.dasserver.cq.entity.annocation.ParamOrder
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/07
 * @version 1.0.0
 * @description 参数排序
 * @see Annotation
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectionParam {

    int order();

}

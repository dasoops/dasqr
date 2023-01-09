package com.dasoops.dasserver.cq.entity.annocation;

import java.lang.annotation.*;

/**
 * @Title: ParamOrder
 * @ClassPath com.dasoops.dasserver.cq.entity.annocation.ParamOrder
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/07
 * @Version 1.0.0
 * @Description: 参数排序
 * @see Annotation
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectionParam {

    int order();

}

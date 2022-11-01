package com.dasoops.dasserver.core.util;

import cn.hutool.core.util.ObjUtil;

/**
 * @Title: Assert
 * @ClassPath com.dasoops.core.util.Assert
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 断言
 */
public class Assert {

    /**
     * 对象非空
     *
     * @param obj obj
     */
    public static void isNull(Object... obj) {
        for (Object o : obj) {
            if (!ObjUtil.isNull(o) && !ObjUtil.isEmpty(o)) {
                ExceptionUtil.buildParameterIsNull();
            }
        }
    }

    /**
     * 对象非空
     *
     * @param obj obj
     */
    public static void notNull(Object... obj) {
        for (Object o : obj) {
            if (ObjUtil.isNull(o) || ObjUtil.isEmpty(o)) {
                ExceptionUtil.buildParameterNotNull();
            }
        }
    }

    /**
     * 结果为真
     *
     * @param bool boolean
     */
    public static void isTrue(Boolean bool) {
        if (bool) {
            ExceptionUtil.buildIsTrue();
        }
    }

    /**
     * 结果为假
     *
     * @param bool boolean
     */
    public static void isFalse(Boolean bool) {
        if (!bool) {
            ExceptionUtil.buildIsFalse();
        }
    }

    /**
     * 执行结果必须成功
     *
     * @param bool 保龄球
     */
    public static void dbExecuteSuccess(Boolean bool) {
        if (!bool) {
            ExceptionUtil.buildDbExecuteFailed();
        }
    }

    /**
     * sql执行返回记录数不可为空
     *
     * @param count 记录数
     */
    public static void dbExecuteResNotZero(Integer count) {
        if (count <= 0) {
            ExceptionUtil.buildDbExecuteResIsZero();
        }
    }

}

package com.dasoops.core.util;

import cn.hutool.core.util.ObjUtil;

import java.util.function.Function;

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
    public static void allNull(Object... obj) {
        if (!ObjUtil.isNull(obj) && !ObjUtil.isEmpty(obj)) {
            ExceptionUtil.buildParameterIsNull();
        }
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
    public static <T> void isNull(T obj, NoneFunction function) {
        if (ObjUtil.isNull(obj) || ObjUtil.isEmpty(obj)) {
            function.invoke();
        }
    }

    /**
     * 对象非空
     *
     * @param obj obj
     */
    public static <T, R> R isNullOrElse(T obj, Function<T, R> function, Function<T, R> orElseFunction) {
        if (ObjUtil.isNull(obj) || ObjUtil.isEmpty(obj)) {
            function.apply(obj);
        }
        return orElseFunction.apply(obj);
    }

    /**
     * 对象非空
     *
     * @param obj obj
     */
    public static void allNotNull(Object... obj) {
        if (ObjUtil.isNull(obj) || ObjUtil.isEmpty(obj)) {
            ExceptionUtil.buildParameterIsNull();
        }
        for (Object o : obj) {
            if (ObjUtil.isNull(o) || ObjUtil.isEmpty(o)) {
                ExceptionUtil.buildParameterNotNull();
            }
        }
    }

    /**
     * 对象非空时执行
     *
     * @param obj obj
     */
    public static <T> void notNull(T obj, NoneFunction function) {
        if (!ObjUtil.isNull(obj) && !ObjUtil.isEmpty(obj)) {
            function.invoke();
        }
    }

    /**
     * 对象非空时执行function,为空时执行orElseFunction
     *
     * @param obj obj
     */
    public static <T, R> R notNullOrElse(T obj, Function<T, R> function, Function<T, R> orElseFunction) {
        if (!ObjUtil.isNull(obj) && !ObjUtil.isEmpty(obj)) {
            return function.apply(obj);
        }
        return orElseFunction.apply(obj);
    }

    /**
     * 对象非空时执行function,为空时执行orElseFunction
     *
     * @param obj obj
     */
    public static <T> void notNullOrElse(T obj, NoneFunction function, NoneFunction orElseFunction) {
        if (!ObjUtil.isNull(obj) && !ObjUtil.isEmpty(obj)) {
            function.invoke();
        }
        orElseFunction.invoke();
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
     * 结果为真
     *
     * @param bool     boolean
     * @param function 函数
     */
    public static void isTrue(Boolean bool, NoneFunction function) {
        if (bool) {
            function.invoke();
        }
    }

    /**
     * 结果为真
     *
     * @param bool     boolean
     * @param function 函数
     */
    public static void isTrueOrElse(Boolean bool, NoneFunction function, NoneFunction orElseFunction) {
        if (bool) {
            function.invoke();
        } else {
            orElseFunction.invoke();
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
     * 结果为假
     *
     * @param bool     boolean
     * @param function 函数
     */
    public static void isFalse(Boolean bool, NoneFunction function) {
        if (!bool) {
            function.invoke();
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
            ExceptionUtil.buildDbExecuteReturnIsZero();
        }
    }

    public static void isNotFailed(String status, String message) {
        String failed = "failed";
        if (failed.equals(status)) {
            ExceptionUtil.buildCqReturnFailed(message);
        }
    }

    /**
     * @Title: noneFunction
     * @ClassPath com.dasoops.dasserver.core.util.Assert.noneFunction
     * @Author DasoopsNicole@Gmail.com
     * @Date 2022/11/01
     * @Version 1.0.0
     * @Description: 无参无返回值函数
     */
    public interface NoneFunction {
        /**
         * 调用
         */
        void invoke();
    }

}

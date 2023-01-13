package com.dasoops.common.util.entity;

/**
 * @Title: AssertReslover
 * @ClassPath com.dasoops.common.util.entity.AssertReslover
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 断言类解析器
 */
public interface AssertReslover {


    /**
     * 对象必须全部为空
     */
    void allMustNull();

    /**
     * 对象非空
     */
    void allMustNotNull();

    /**
     * 结果为真
     */
    void isTrue();

    /**
     * 结果为假
     */
    void isFalse();

    /**
     * 执行结果必须成功
     */
    void dbExecuteMustSuccess();

    /**
     * 数据库不可返回null
     */
    void dbExecuteReturnMustNotNull();

    /**
     * sql执行返回记录数不可为空
     */
    void dbExecuteResNotZero();

}

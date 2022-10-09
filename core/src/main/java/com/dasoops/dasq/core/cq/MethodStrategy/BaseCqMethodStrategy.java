package com.dasoops.dasq.core.cq.MethodStrategy;

/**
 * @Title: BaseCqMethodStrategy
 * @ClassPath com.dasoops.dasq.core.cq.MethodStrategy.BaseCqMethodStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: cq方法策略基类
 */
public interface BaseCqMethodStrategy {

    /**
     * 得到id
     *
     * @return {@link Long}
     */
    Long getId();


    /**
     * 执行方法
     *
     * @param params 参数
     */
    void invoke(Object... params);

}

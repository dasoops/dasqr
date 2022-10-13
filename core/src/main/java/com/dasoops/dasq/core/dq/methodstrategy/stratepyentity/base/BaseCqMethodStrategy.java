package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base;

import java.util.List;

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
     * 方法typeId
     *
     * @return {@link Long}
     */
    Long getId();


    /**
     * 执行方法
     *
     * @param params 参数
     */
    void invoke(List<String> params);

}

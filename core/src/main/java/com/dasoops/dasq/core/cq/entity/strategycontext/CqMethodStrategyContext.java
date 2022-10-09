package com.dasoops.dasq.core.cq.entity.strategycontext;

import com.dasoops.dasq.core.cq.MethodStrategy.BaseCqMethodStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Title: CqMethodStrategyContext
 * @ClassPath com.dasoops.dasq.core.cq.entity.context.CqMethodStrategyContext
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: cq白名单方法策略抉择上下文对象
 */
public class CqMethodStrategyContext {
    /**
     * 策略集合
     */
    private Map<Long, BaseCqMethodStrategy> strategyMap;

    /**
     * 依据策略List集合设置策略Map集合
     *
     * @param strategyList 策略列表
     */
    public void setStrategyMap(List<BaseCqMethodStrategy> strategyList) {
        strategyMap = strategyList.stream().collect(Collectors.toMap(BaseCqMethodStrategy::getId, res -> res));
    }

    /**
     * 调用方法
     *
     * @param id     方法id
     * @param params 参数
     */
    public void invokeMethod(Long id, Object... params) {
        strategyMap.get(id).invoke(params);
    }
}

package com.dasoops.dasq.core.cq.methodstrategy.strategycontext;

import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.BaseCqMethodStrategy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Map;

/**
 * @Title: CqMethodStrategyContextFactory
 * @ClassPath com.dasoops.dasq.core.cq.entity.context.CqMethodStrategyContextFactory
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: cq白名单方法策略抉择上下文对象 工厂
 * @see ApplicationContextAware
 */
@Component
public class CqMethodStrategyContextFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private CqMethodStrategyContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        if (context == null) {
            context = new CqMethodStrategyContext();
            Map<String, BaseCqMethodStrategy> strategyMap = applicationContext.getBeansOfType(BaseCqMethodStrategy.class);
            if (!strategyMap.isEmpty()) {
                context.setStrategyMap(new LinkedList<>(strategyMap.values()));
            }
        }
    }

    /**
     * 获得策略抉择上下文对象
     *
     * @return {@link CqMethodStrategyContext}
     */
    public CqMethodStrategyContext getContext() {
        return context;
    }
}

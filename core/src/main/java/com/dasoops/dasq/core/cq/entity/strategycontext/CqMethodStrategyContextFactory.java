package com.dasoops.dasq.core.cq.entity.strategycontext;

import com.dasoops.dasq.core.cq.MethodStrategy.BaseCqMethodStrategy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

import java.util.LinkedList;

/**
 * @Title: CqMethodStrategyContextFactory
 * @ClassPath com.dasoops.dasq.core.cq.entity.context.CqMethodStrategyContextFactory
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: cq白名单方法策略抉择上下文对象 工厂
 * @see ApplicationContextAware
 */
public class CqMethodStrategyContextFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获得策略抉择上下文对象
     *
     * @return {@link CqMethodStrategyContext}
     */
    public CqMethodStrategyContext getContext(){
        CqMethodStrategyContext context = new CqMethodStrategyContext();
        context.setStrategyMap(new LinkedList<>(applicationContext.getBeansOfType(BaseCqMethodStrategy.class).values()));
        return context;
    }
}

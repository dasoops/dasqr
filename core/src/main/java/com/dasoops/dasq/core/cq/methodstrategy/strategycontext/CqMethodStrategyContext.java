package com.dasoops.dasq.core.cq.methodstrategy.strategycontext;

import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.cq.entity.po.MethodInfo;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.common.util.CqMethodUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Title: CqMethodStrategyContext
 * @ClassPath com.dasoops.dasq.core.cq.entity.context.CqMethodStrategyContext
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: cq白名单方法类型策略抉择上下文对象
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
    private void invoke(Long id, List<String> params) {
        BaseCqMethodStrategy strategy = strategyMap.get(id);
        if (strategy == null) {
            return;
        }
        strategy.invoke(params);
    }

    /**
     * 调用方法
     *
     * @param methodInfo 方法信息
     * @param message    消息
     */
    public void invoke(MethodInfo methodInfo, String message, String style) {
        try {
            invoke(methodInfo.getTypeId(), CqMethodUtil.getParameterMap(methodInfo.getParameters(), message, style));
        } catch (LogicException e) {
            throw e;
        } catch (NullPointerException e) {
            throw new LogicException(ExceptionCodeEnum.PARAMETER_GET_ERROR, e);
        } catch (Exception e) {
            throw new LogicException(ExceptionCodeEnum.UN_EXPECTED_ERROR, e);
        }
    }
}

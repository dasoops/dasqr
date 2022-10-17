package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.sys;

import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title: ThrowErrorStrategy
 * @ClassPath com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.sys.ThrowErrorStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/17
 * @Version 1.0.0
 * @Description: 扔错误策略
 * @see BaseMethodStrategy
 * @see BaseCqMethodStrategy
 */
@Component
public class ThrowErrorStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Override
    public Long getId() {
        return 1581923948196622338L;
    }

    @Override
    public void invoke(List<String> params) {
        if (params == null || params.isEmpty() || params.get(0) == null) {
            throw new LogicException(ExceptionCodeEnum.CUSTOM_ERROR);
        }
        throw new LogicException(ExceptionCodeEnum.CUSTOM_ERROR, params.get(0));
    }
}

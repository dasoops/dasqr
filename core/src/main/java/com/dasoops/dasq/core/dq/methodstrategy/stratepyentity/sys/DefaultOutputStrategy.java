package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.sys;

import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title: defaultOutputStrategy
 * @ClassPath com.dasoops.dasq.core.cq.service.defaultOutputStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: keyword : do(default output)
 * 默认输出方法,params($authorType,$authorId,String msg)
 */
@Component
public class DefaultOutputStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {


    @Override
    public Long getId() {
        return 0L;
    }

    @Override
    public void invoke(List<String> params) {
        cqService.sendMsg(params.get(0));
    }
}

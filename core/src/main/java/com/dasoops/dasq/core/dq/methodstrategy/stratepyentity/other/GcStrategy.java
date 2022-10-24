package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.other;

import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;

import java.util.List;

/**
 * @author yly
 * @date 2022-10-24 18:40
 */
public class GcStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Override
    public Long getId() {
        return 1584484072559779841L;
    }

    @Override
    public void invoke(List<String> params) {
        System.gc();
        cqService.sendMsg("success");
    }
}

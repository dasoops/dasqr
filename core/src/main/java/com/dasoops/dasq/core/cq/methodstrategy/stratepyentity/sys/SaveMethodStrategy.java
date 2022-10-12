package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.sys;

import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import com.dasoops.dasq.core.cq.service.CqService;
import com.dasoops.dasq.core.cq.service.MethodInfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: SaveMethodStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.sys.SaveMethodStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: 保存方法策略
 * @see BaseCqMethodStrategy
 */
@Component
public class SaveMethodStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Resource
    private MethodInfoService methodInfoService;

    @Override
    public Long getId() {
        return 1L;
    }

    @Override
    public void invoke(List<String> params) {
        methodInfoService.addMethod(params.get(0), params.get(1), params.get(2), params.get(3));
        cqService.sendMsg("方法添加成功");
    }
}

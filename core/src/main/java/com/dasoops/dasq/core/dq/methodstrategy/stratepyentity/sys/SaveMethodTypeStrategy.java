package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.sys;

import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import com.dasoops.dasq.core.cq.service.MethodTypeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: SaveMethodStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.sys.SaveMethodStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: 保存方法类型策略
 * @see BaseCqMethodStrategy
 */
@Component
public class SaveMethodTypeStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Resource
    private MethodTypeService methodTypeService;

    @Override
    public Long getId() {
        return 2L;
    }

    @Override
    public void invoke(List<String> params) {
        Long id = methodTypeService.addMethodType(params.get(0), params.get(1), params.get(2));
        cqService.sendMsg("方法类型添加成功,id: " + id);
    }
}

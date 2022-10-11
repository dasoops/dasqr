package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity;

import com.dasoops.dasq.core.cq.service.CqService;
import com.dasoops.dasq.core.cq.service.MethodInfoService;
import com.dasoops.dasq.core.cq.service.MethodTypeService;
import com.dasoops.dasq.core.cq.service.impl.MethodTypeServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: SaveMethodStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.SaveMethodStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: 保存方法类型策略
 * @see BaseCqMethodStrategy
 */
@Component
public class SaveMethodTypeStrategy implements BaseCqMethodStrategy {

    @Resource
    private MethodTypeService methodTypeService;
    @Resource
    private CqService cqService;

    @Override
    public Long getId() {
        return 2L;
    }

    @Override
    public void invoke(List<String> params) {
        methodTypeService.addMethodType(params.get(0), params.get(1), params.get(2));
        cqService.sendMsg("方法类型添加成功");
    }
}

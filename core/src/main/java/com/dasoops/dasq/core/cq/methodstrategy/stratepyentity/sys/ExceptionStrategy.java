package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.sys;

import com.dasoops.common.exception.service.ExceptionService;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import com.dasoops.dasq.core.cq.service.CqService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: OneParamStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.OneParamStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/11
 * @Version 1.0.0
 * @Description: 获取异常策略
 */
@Component
public class ExceptionStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Resource
    private ExceptionService exceptionService;

    @Override
    public Long getId() {
        return 1579671773032632322L;
    }

    @Override
    public void invoke(List<String> params) {
        if (params.isEmpty() || params.get(0) == null) {
            cqService.sendMsg("CrazyFridayException\r\n\tStack at\r\nvMe50");
            return;
        }
        String exceptionMsg = exceptionService.getException(params.get(0));
        if (exceptionMsg == null) {
            cqService.sendMsg("未查询到错误信息");
            return;
        }
        cqService.sendMsg(exceptionMsg);
    }
}

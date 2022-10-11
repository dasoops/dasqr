package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity;

import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.dasq.core.cq.entity.po.MethodInfo;
import com.dasoops.dasq.core.cq.service.CqService;
import com.dasoops.dasq.core.cq.service.MethodInfoService;
import com.dasoops.dasq.core.cq.service.PassListService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: helpStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.helpStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: 帮助策略
 * @see BaseCqMethodStrategy
 */
@Component
public class HelpStrategy implements BaseCqMethodStrategy {

    @Resource
    private CqService cqService;
    @Resource
    private PassListService passListService;
    @Resource
    private MethodInfoService methodInfoService;

    @Override
    public Long getId() {
        return 1579433884143243266L;
    }

    @Override
    public void invoke(List<String> params) {
        String helpKeyword = params.get(0);
        if (helpKeyword == null) {
            cqService.sendMsg(methodInfoService.getHelpDoc());
        }
        MethodInfo methodInfo = passListService.getMethodInfoByPassKeyword(helpKeyword);
        if (methodInfo == null) {
            cqService.sendMsg("未知方法");
            return;
        }
        cqService.sendMsg(methodInfo.getDescription() + "\r\n" + methodInfo.getParameters());
    }
}

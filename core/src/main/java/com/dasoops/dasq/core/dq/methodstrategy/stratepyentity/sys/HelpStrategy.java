package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.sys;

import com.dasoops.dasq.core.cq.entity.bo.MethodTypeAndInfoBo;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
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
public class HelpStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

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
        if (params.isEmpty() || params.get(0) == null) {
            cqService.sendMsg(methodInfoService.getHelpDoc());
            return;
        }

        MethodTypeAndInfoBo bo = passListService.getMethodInfoByPassKeyword(params.get(0));
        if (bo == null) {
            cqService.sendMsg("未知方法");
            return;
        }
        cqService.sendMsg(bo.getDescription() + "(" + bo.getTypeKeyword() + ")" + "\r\n" + bo.getTypeDescription() + "\r\n" + bo.getParam());
    }
}

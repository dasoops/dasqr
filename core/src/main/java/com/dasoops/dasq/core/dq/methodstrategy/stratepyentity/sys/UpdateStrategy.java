package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.sys;

import com.dasoops.dasq.core.common.task.RedisTask;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
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
public class UpdateStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Resource
    private RedisTask redisTask;

    @Override
    public Long getId() {
        return 1579653655149408257L;
    }

    @Override
    public void invoke(List<String> params) {
        redisTask.update();
        cqService.sendMsg("success");
    }
}

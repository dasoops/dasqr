package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.sys;//package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity;

import com.dasoops.dasq.core.common.event.RebootEvent;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: RebootStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.sys.RebootStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/13
 * @Version 1.0.0
 * @Description: 重新启动策略
 * @see BaseMethodStrategy
 * @see BaseCqMethodStrategy
 */
@Component
@Slf4j
public class RebootStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Resource
    private RebootEvent rebootEvent;

    @Override
    public Long getId() {
        return 1580389375226793985L;
    }

    @Override
    public void invoke(List<String> params) {
        log.info("reboot");
        rebootEvent.run();
    }
}

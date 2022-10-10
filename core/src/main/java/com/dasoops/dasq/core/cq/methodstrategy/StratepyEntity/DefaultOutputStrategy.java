package com.dasoops.dasq.core.cq.methodstrategy.StratepyEntity;

import com.dasoops.dasq.core.cq.service.CqService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
public class DefaultOutputStrategy implements BaseCqMethodStrategy {

    @Resource
    private CqService cqService;

    @Override
    public Long getId() {
        return 0L;
    }

    @Override
    public void invoke(List<String> params) {
        cqService.sendMsg(params.get(0));
    }
}

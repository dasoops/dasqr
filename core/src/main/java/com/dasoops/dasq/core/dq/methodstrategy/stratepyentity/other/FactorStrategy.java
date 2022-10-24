package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.other;

import cn.hutool.core.util.StrUtil;
import com.dasoops.dasq.core.common.util.CqCodeUtil;
import com.dasoops.dasq.core.common.util.CqMethodUtil;
import com.dasoops.dasq.core.dq.entity.pojo.Factor;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import com.dasoops.dasq.core.dq.service.FactorService;
import com.dasoops.minio.MinioTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: FactorStrategy
 * @ClassPath com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.other.FactorStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/18
 * @Version 1.0.0
 * @Description: 因子策略
 * @see BaseMethodStrategy
 * @see BaseCqMethodStrategy
 */
@Component
public class FactorStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Resource
    private FactorService factorService;
    @Resource
    private MinioTemplate minioTemplate;

    @Override
    public Long getId() {
        return 1582333461202509825L;
    }

    @Override
    public void invoke(List<String> params) {
        //无参
        if (params == null || params.isEmpty()) {
            cqService.sendMsg("没有这个因子捏!");
            return;
        }

        Factor factor = factorService.getFactorByName(params.get(0));
        if (factor == null) {
            cqService.sendMsg("没有这个因子捏!");
            return;
        }
        String str = StrUtil.format("{}\r\n{}({}分)\r\n{}",
                CqCodeUtil.buildImageCqCode(minioTemplate.buildImagePath(factor.getImageFileName())),
                factor.getName(), factor.getScore(), factor.getDescription());
        cqService.sendMsg(str);
    }
}

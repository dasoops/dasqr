package com.dasoops.dasq.core.dq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasq.core.dq.entity.pojo.Factor;
import com.dasoops.dasq.core.dq.service.FactorService;
import com.dasoops.dasq.core.dq.mapper.FactorMapper;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【TB_OTHER_SC2_FACTOR(sc2 因子)】的数据库操作Service实现
 * @createDate 2022-10-18 19:14:43
 */
@Service
public class FactorServiceImpl extends ServiceImpl<FactorMapper, Factor>
        implements FactorService {

    @Override
    public Factor getFactorByName(String name) {
        return super.lambdaQuery().eq(Factor::getName, name).one();
    }

}





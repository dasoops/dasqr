package com.dasoops.dasserver.plugin.starcraft2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasserver.plugin.starcraft2.entity.dbo.FactorDo;
import com.dasoops.dasserver.plugin.starcraft2.mapper.FactorMapper;
import com.dasoops.dasserver.plugin.starcraft2.service.FactorService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【tb_plugin_star_craft_2_factor(sc2 因子)】的数据库操作Service实现
 * @createDate 2023-01-20 19:24:24
 */
@Service
public class FactorServiceImpl extends ServiceImpl<FactorMapper, FactorDo>
        implements FactorService {

    @Override
    public FactorDo getFactorByName(String name) {
        return super.lambdaQuery().eq(FactorDo::getName, name).one();
    }
}





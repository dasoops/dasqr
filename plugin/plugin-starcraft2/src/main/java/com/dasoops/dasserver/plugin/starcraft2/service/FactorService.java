package com.dasoops.dasserver.plugin.starcraft2.service;

import com.dasoops.dasserver.plugin.starcraft2.entity.dbo.FactorDo;

/**
 * @author Administrator
 * @description 针对表【tb_plugin_star_craft_2_factor(sc2 因子)】的数据库操作Service
 * @createDate 2023-01-20 19:24:24
 */
public interface FactorService {

    /**
     * 通过名字获取因子
     *
     * @param name 名字
     * @return {@link FactorDo}
     */
    FactorDo getFactorByName(String name);
}

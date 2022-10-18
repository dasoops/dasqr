package com.dasoops.dasq.core.dq.service;

import com.dasoops.dasq.core.dq.entity.pojo.Factor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Administrator
 * @description 针对表【TB_OTHER_SC2_FACTOR(sc2 因子)】的数据库操作Service
 * @createDate 2022-10-18 19:14:43
 */
public interface FactorService extends IService<Factor> {


    /**
     * 根据因子名称获取因子
     *
     * @param name 名字
     * @return {@link Factor}
     */
    Factor getFactorByName(String name);
}

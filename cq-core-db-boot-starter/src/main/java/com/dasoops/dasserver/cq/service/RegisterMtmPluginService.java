package com.dasoops.dasserver.cq.service;

import com.dasoops.dasserver.cq.entity.dbo.RegisterMtmPluginDo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Title: RegisterMtmPluginService
 * @ClassPath com.dasoops.dasserver.cq.service.RegisterMtmPluginService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_REGISTER_MTM_PLUGIN】的数据库操作Service
 * @see IService
 */
public interface RegisterMtmPluginService extends IService<RegisterMtmPluginDo> {

    /**
     * 初始化/更新 多对多关系集合
     */
    void initOrUpdateRegisterMtmPluginList();
}

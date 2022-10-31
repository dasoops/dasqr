package com.dasoops.cq.service;

import com.dasoops.cq.CqPlugin;
import com.dasoops.cq.entity.po.PluginPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Optional;

/**
 * @Title: PluginService
 * @ClassPath com.dasoops.cq.service.PluginService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_PLUGIN(插件表,储存插件注册信息,权限,描述,启用状态等)】的数据库操作Service
 * @see IService
 */
public interface PluginService extends IService<PluginPo> {

    /**
     * 获取所有插件类
     *
     * @return {@link Optional}<{@link List}<{@link ?} {@link extends} {@link Class}<{@link CqPlugin}>>>
     */
    Optional<List<? extends Class<CqPlugin>>> getAllPluginClass();
}

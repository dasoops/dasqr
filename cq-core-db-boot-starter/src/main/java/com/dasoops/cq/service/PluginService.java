package com.dasoops.cq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.cq.CqPlugin;
import com.dasoops.cq.entity.po.PluginPo;

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
    Optional<List<Class<? extends CqPlugin>>> getAllPluginClass();

    /**
     * 通过关键字获取插件对象
     *
     * @param keyWord 关键字
     * @return {@link Optional}<{@link PluginPo}>
     */
    Optional<PluginPo> getByKeyWord(String keyWord);

    /**
     * 保存配置,包含处理新增插件的中间表处理操作
     *
     * @param pluginPo 插件
     * @return boolean
     */
    @Override
    boolean save(PluginPo pluginPo);

    /**
     * 通过关键字更新
     *
     * @param pluginPo 插件
     * @return boolean
     */
    boolean updateByKeyword(PluginPo pluginPo);

    /**
     * 根据最小level获取插件id集合
     *
     * @param minLevel 最小level
     * @return {@link List}<{@link Integer}>
     */
    List<Integer> getIdListByMinLevel(Integer minLevel);
}

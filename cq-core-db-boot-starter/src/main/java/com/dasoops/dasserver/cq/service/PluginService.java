package com.dasoops.dasserver.cq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.dto.PluginStatusDto;

import java.util.List;
import java.util.Optional;

/**
 * @Title: PluginService
 * @ClassPath com.dasoops.dasserver.cq.service.PluginService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_plugin(插件表,储存插件注册信息,权限,描述,启用状态等)】的数据库操作Service
 * @see IService
 */
public interface PluginService {


    /**
     * 获取所有插件和其状态(包含记录与加载)
     *
     * @return {@link List}<{@link PluginStatusDto}>
     */
    List<PluginStatusDto> getAllPluginAndStatus();

    /**
     * 获取所有没有数据库记录的插件
     *
     * @return {@link List}<{@link PluginStatusDto}>
     */
    List<PluginStatusDto> getAllNoRecordPlugin();

    /**
     * 获取所有插件类
     *
     * @return {@link Optional}<{@link List}<{@link ?} {@link extends} {@link Class}<{@link CqPlugin}>>>
     */
    List<? extends CqPlugin> getAllLoadDbCqPlugin();

    /**
     * 通过关键字获取插件对象
     *
     * @param keyWord 关键字
     * @return {@link Optional}<{@link PluginDo}>
     */
    Optional<PluginDo> getByKeyWord(String keyWord);

    /**
     * 保存配置,包含处理新增插件的中间表处理操作
     *
     * @param pluginPo 插件
     * @return boolean
     */
    boolean save(PluginDo pluginPo);

    /**
     * 通过关键字更新
     *
     * @param pluginPo 插件
     * @return boolean
     */
    boolean updateByKeyword(PluginDo pluginPo);

    /**
     * 根据最小level获取插件id集合
     *
     * @param minLevel 最小level
     * @return {@link List}<{@link Integer}>
     */
    List<Long> getIdListByMinLevel(Integer minLevel);

    /**
     * 得到最大排序
     *
     * @return {@link Integer}
     */
    Integer getMaxOrder();
}

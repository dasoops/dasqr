package com.dasoops.dasserver.plugin.webmanager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.plugin.pluginwrapper.entity.param.AddPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportPluginDto;
import com.dasoops.dasserver.plugin.webmanager.entity.param.plugin.*;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetRegisterRouteKeywordVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.plugin.GetPluginSortVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.plugin.GetPluginVo;

import java.util.List;

/**
 * @title PluginService
 * @classPath com.dasoops.dasserver.cq.service.PluginService
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/31
 * @version 1.0.0
 * @description 针对表【tb_core_plugin(插件表,储存插件注册信息,权限,描述,启用状态等)】的数据库操作Service
 * @see IService
 */
public interface PluginWebService {

    /**
     * 获取插件分页数据
     *
     * @param param param
     * @return {@link IPage}<{@link GetPluginVo}>
     */
    IPage<GetPluginVo> getPluginPageData(GetPluginPageSortParam param);

    /**
     * 编辑插件
     *
     * @param param param
     */
    void editPlugin(EditPluginParam param);

    /**
     * 获取下一个主键id
     *
     * @return {@link GetNextIdVo}
     */
    GetNextIdVo getNextId();

    /**
     * 添加插件
     *
     * @param param param
     */
    void addPlugin(AddPluginParam param);

    /**
     * 删除插件
     *
     * @param param param
     */
    void deletePlugin(DeletePluginParam param);

    /**
     * 导出所有插件
     *
     * @return {@link List}<{@link ExportPluginDto}>
     */
    List<ExportPluginDto> exportAllPlugin();

    /**
     * 排序插件
     *
     * @param param param
     */
    void sortPlugin(SortPluginParam param);

    /**
     * 获取排序插件
     *
     * @return {@link Object}
     */
    GetPluginSortVo getSortPlugin();

    /**
     * 检查插件类路径
     *
     * @param param param
     */
    void checkPluginClassPath(CheckPluginClassPathParam param);

    /**
     * 获取注册路由关键词集合
     *
     * @return {@link GetRegisterRouteKeywordVo}
     */
    GetRegisterRouteKeywordVo getRegisterRouteKeywordList();
}

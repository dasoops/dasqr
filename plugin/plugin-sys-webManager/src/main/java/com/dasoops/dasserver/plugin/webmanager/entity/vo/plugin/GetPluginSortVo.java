package com.dasoops.dasserver.plugin.webmanager.entity.vo.plugin;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @title: GetPluginSortVo
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.vo.plugin.GetPluginSortVo
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/12
 * @version 1.0.0
 * @description 获取插件排序vo
 * @see BaseVo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取插件排序vo", description = "获取插件排序vo")
public class GetPluginSortVo extends BaseVo {

    /**
     * 插件排序集合
     */
    @ApiModelProperty(value = "插件排序集合", notes = "插件排序集合", example = "{\"rowId\":\"1\",\"name\":\"模板插件(template)\",\"order\":\"1\"}", required = true)
    private List<PluginSortInnerVo> pluginSortList;

}

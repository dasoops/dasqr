package com.dasoops.dasserver.plugin.webmanager.entity.param.plugin;

import com.dasoops.common.entity.param.SortParam;
import com.dasoops.common.entity.param.base.BasePageParam;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @title GetPluginPageParam
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.param.GetPluginPageParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/12
 * @version 1.0.0
 * @description 获取插件分页信息param
 * @see BasePageParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Api("Plugin")
@ApiModel(value = "获取插件分页信息param", description = "获取插件分页信息param")
public class GetPluginPageSortParam extends BasePageParam<PluginDo> {

    /**
     * 排序规则(排序字段0:rowId;1:order;2:level;3:enable)
     */
    @ApiModelProperty(value = "排序规则", notes = "排序规则", example = "{\"sortColumn\":\"1\",\"sortRule\":\"0\"}", required = false)
    private List<SortParam<PluginDo>> sortParamList;

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词", notes = "关键词", example = "模板", required = false)
    private String keyword;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态", notes = "状态", example = "[1,2]", required = false)
    private List<Integer> statusList;


}

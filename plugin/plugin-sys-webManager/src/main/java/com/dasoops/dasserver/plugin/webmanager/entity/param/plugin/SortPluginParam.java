package com.dasoops.dasserver.plugin.webmanager.entity.param.plugin;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.common.entity.param.base.BaseFastBuildParam;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @title SortPluginParam
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.param.plugin.SortPluginParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/12
 * @version 1.0.0
 * @description 排序插件param
 * @see BaseFastBuildParam
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Api("Plugin")
@ApiModel(value = "排序插件param", description = "排序插件param")
public class SortPluginParam extends BaseFastBuildParam<PluginDo> {

    /**
     * 插件排序集合
     */
    @ApiModelProperty(name = "sortPluginList", value = "插件排序集合", notes = "插件排序集合", example = "{\"id\":\"4\",\"order\":\"2\"}", required = true)
    @JSONField(name = "sortPluginList")
    private List<SortPluginInnerParam> sortPluginParamList;

}

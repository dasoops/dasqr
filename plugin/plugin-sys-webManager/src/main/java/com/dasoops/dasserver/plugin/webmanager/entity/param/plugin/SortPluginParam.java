package com.dasoops.dasserver.plugin.webmanager.entity.param.plugin;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.common.entity.param.base.BaseFastBuildParam;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: SortPluginParam
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.param.plugin.SortPluginParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 排序插件param
 * @see BaseFastBuildParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SortPluginParam extends BaseFastBuildParam<PluginDo> {

    /**
     * 插件排序集合
     */
    @ApiModelProperty(name = "sortPluginList", value = "插件排序集合", notes = "插件排序集合", example = "{\"id\":\"4\",\"order\":\"2\"}", required = true)
    @JSONField(name = "sortPluginList")
    private List<SortPluginInnerParam> sortPluginParamList;

}

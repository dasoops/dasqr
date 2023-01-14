package com.dasoops.dasserver.plugin.webmanager.entity.param;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.plugin.webmanager.entity.dto.SortPluginInnerParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: SortPluginParam
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.param.SortPluginParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 排序插件param
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SortPluginParam extends BaseParam<PluginDo> {

    /**
     * 插件排序集合
     */
    @ApiModelProperty(name = "sortPluginList", value = "插件排序集合", notes = "插件排序集合", example = "{\"id\":\"4\",\"order\":\"2\"}", required = true)
    @JSONField(name = "sortPluginList")
    private List<SortPluginInnerParam> sortPluginParamList;

}

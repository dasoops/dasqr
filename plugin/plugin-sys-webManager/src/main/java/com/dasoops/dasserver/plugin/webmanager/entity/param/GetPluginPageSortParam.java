package com.dasoops.dasserver.plugin.webmanager.entity.param;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.common.entity.param.base.BasePageParam;
import com.dasoops.common.entity.param.SortParam;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: GetPluginPageParam
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.param.GetPluginPageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 获取插件分页信息param
 * @see BasePageParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取插件分页信息param", description = "获取插件分页信息param")
public class GetPluginPageSortParam extends BasePageParam<PluginDo> {

    /**
     * 排序规则(排序字段0:rowId;1:order;2:level;3:enable)
     */
    @ApiModelProperty(value = "排序规则", notes = "排序规则", example = "{\"sortColumn\":\"1\",\"sortRule\":\"0\"}", required = false)
    @JSONField(name = "sortParam")
    private List<SortParam<PluginDo>> sortParamList;

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词", notes = "关键词", example = "模板", required = false)
    private String keyword;


}

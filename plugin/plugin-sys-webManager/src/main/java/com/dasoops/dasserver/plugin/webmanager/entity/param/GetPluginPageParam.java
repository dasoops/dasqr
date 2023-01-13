package com.dasoops.dasserver.plugin.webmanager.entity.param;

import com.dasoops.common.entity.param.base.BasePageParam;
import com.dasoops.common.entity.param.base.SortDataParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GetPluginPageParam
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.param.GetPluginPageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 获取插件页面param
 * @see BasePageParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取插件分页信息param", description = "获取插件分页信息param")
public class GetPluginPageParam extends BasePageParam {

    /**
     * 排序规则(排序字段0:rowId;1:order;2:level;3:enable)
     */
    @ApiModelProperty(value = "排序规则", notes = "排序规则", example = "{\"sortColumn\":\"1\",\"sortRule\":\"0\"}", required = false)
    private SortDataParam SortDataParam;

}

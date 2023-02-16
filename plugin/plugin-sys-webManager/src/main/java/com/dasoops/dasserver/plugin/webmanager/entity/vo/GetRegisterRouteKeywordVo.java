package com.dasoops.dasserver.plugin.webmanager.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title GetLoadPluginVo
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.vo.GetLoadPluginVo
 * @date 2023/01/24
 * @description 获取注册路由关键词集合
 * @see BaseVo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Api("Global")
@ApiModel(value = "获取注册路由关键词集合", description = "获取注册路由关键词集合")
public class GetRegisterRouteKeywordVo extends BaseVo {

    /**
     * 注册路由关键词集合
     */
    @ApiModelProperty(value = "注册路由关键词集合", example = "none", required = false)
    private List<String> registerRouteKeywordList;

}

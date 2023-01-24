package com.dasoops.dasserver.plugin.webmanager.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: GetLoadPluginVo
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.vo.GetLoadPluginVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/24
 * @Version 1.0.0
 * @Description: 获取注册路由关键词集合
 * @see BaseVo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取注册路由关键词集合", description = "获取注册路由关键词集合")
public class GetRegisterRouteKeywordVo extends BaseVo {

    /**
     * 注册路由关键词集合
     */
    private List<String> registerRouteKeywordList;

}

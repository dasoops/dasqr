package com.dasoops.dasserver.plugin.shell.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @title: GetWsUrlVo
 * @classPath com.dasoops.dasserver.plugin.shell.entity.vo.GetWsUrlVo
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/24
 * @version 1.0.0
 * @description 获取wsurlvo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取wsUrlVo", description = "获取wsUrlVo")
public class GetWsUrlVo extends BaseVo {
    /**
     * wsUrl
     */
    @ApiModelProperty(value = "wsUrl", notes = "wsUrl", example = "/ws/shell", required = true)
    private String wsUrl;
}

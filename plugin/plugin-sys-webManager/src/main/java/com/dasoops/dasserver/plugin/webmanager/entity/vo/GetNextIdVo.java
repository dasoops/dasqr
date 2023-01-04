package com.dasoops.dasserver.plugin.webmanager.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GetNextIdVo
 * @ClassPath com.dasoops.dasserver.webManager.entity.vo.GetNextIdVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: 获取新增idVo
 * @see BaseVo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取新增idVo", description = "获取新增idVo")
public class GetNextIdVo extends BaseVo {

    /**
     * id
     */
    @ApiModelProperty(value = "id", notes = "id", example = "30", required = true)
    private Long id;

}

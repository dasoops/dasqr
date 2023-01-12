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
 * @Description: 获取下一个主键id
 * @see BaseVo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取下一个主键id", description = "获取下一个主键id")
public class GetNextIdVo extends BaseVo {

    /**
     * rowId
     */
    @ApiModelProperty(value = "rowId", notes = "rowId", example = "30", required = true)
    private Long rowId;

}

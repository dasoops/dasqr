package com.dasoops.dasserver.plugin.webmanager.entity.vo.register;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @title: GetFantasyUserVo
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.vo.register.GetFantasyUserVo
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 获取联想用户vo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取联想用户vo", description = "获取联想用户vo")
public class GetFantasyUserVo extends BaseVo {

    /**
     * 联想用户集合
     */
    @ApiModelProperty(value = "联想用户集合", notes = "联想用户集合", example = "{\"registerId\":\"776465218\",\"name\":\"Das\"}", required = false)
    private List<FantasyRegisterVo> fantasyRegisterList;

}

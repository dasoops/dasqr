package com.dasoops.dasserver.plugin.webmanager.entity.vo.register;

import com.dasoops.common.entity.vo.base.BaseInnerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title FantasyUserDto
 * @classPath com.dasoops.dasserver.plugin.image.entity.dto.FantasyUserDto
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 联想用户dto
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Api("Register")
@ApiModel(value = "联想用户dto", description = "联想用户dto")
public class FantasyRegisterVo extends BaseInnerVo {

    /**
     * 用户注册id
     */
    @ApiModelProperty(value = "用户注册id", notes = "用户注册id", example = "776465218", required = true)
    private Long registerId;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称", notes = "用户名称", example = "Das", required = true)
    private String name;

}

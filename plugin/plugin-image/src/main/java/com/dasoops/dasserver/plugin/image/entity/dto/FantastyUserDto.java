package com.dasoops.dasserver.plugin.image.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: FantasyUserDto
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.dto.FantasyUserDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 联想用户dto
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "联想用户dto", description = "联想用户dto")
public class FantastyUserDto extends BaseDto {

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

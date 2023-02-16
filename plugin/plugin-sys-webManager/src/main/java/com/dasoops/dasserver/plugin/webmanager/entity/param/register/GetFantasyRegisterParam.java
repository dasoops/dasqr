package com.dasoops.dasserver.plugin.webmanager.entity.param.register;


import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title GetFantasyRegisterParam
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetFantasyRegisterParam
 * @date 2023/02/14
 * @description 获取联想用户param
 * @see BaseParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Api("Register")
@ApiModel(value = "获取联想用户param", description = "获取联想用户param")
public class GetFantasyRegisterParam extends BaseParam {

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词", notes = "关键词", example = "77646 / Das", required = true)
    private String keyword;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", example = "0:用户;1:群组", required = true)
    private Integer type;

}

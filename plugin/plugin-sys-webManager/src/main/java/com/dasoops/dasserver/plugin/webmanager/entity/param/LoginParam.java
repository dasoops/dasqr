package com.dasoops.dasserver.plugin.webmanager.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: LoginVo
 * @ClassPath com.dasoops.imageManagerServer.user.model.vo.LoginVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/26
 * @Version 1.0.0
 * @Description: 登录Param
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "登录请求对象", description = "登录请求对象")
public class LoginParam extends BaseParam {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", notes = "用户名", example = "776465218", required = true)
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", notes = "密码", example = "776465218", required = true)
    private String password;

}

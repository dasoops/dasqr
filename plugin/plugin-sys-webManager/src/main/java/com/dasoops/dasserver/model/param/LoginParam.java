package com.dasoops.dasserver.model.param;

import com.dasoops.common.entity.param.base.BaseParam;
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
public class LoginParam extends BaseParam {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}

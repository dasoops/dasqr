package com.dasoops.dasserver.plugin.webManager.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: LoginVo
 * @ClassPath com.dasoops.imageManagerServer.user.model.vo.LoginVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/26
 * @Version 1.0.0
 * @Description: 登录vo
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginVo extends BaseVo {

    private String token;

}

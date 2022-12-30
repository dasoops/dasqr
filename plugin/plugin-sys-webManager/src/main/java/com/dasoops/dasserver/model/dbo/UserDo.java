package com.dasoops.dasserver.model.dbo;

import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: User
 * @ClassPath com.dasoops.imageManagerServer.user.model.dbo.User
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/26
 * @Version 1.0.0
 * @Description: 用户
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDo extends BaseDo {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}

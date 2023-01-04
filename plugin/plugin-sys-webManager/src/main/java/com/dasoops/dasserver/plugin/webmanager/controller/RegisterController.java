package com.dasoops.dasserver.plugin.webmanager.controller;

import com.dasoops.common.entity.vo.result.Result;
import com.dasoops.dasserver.plugin.webmanager.entity.param.LoginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.LoginVo;
import com.dasoops.dasserver.plugin.webmanager.service.RegisterWebService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: userController
 * @ClassPath com.dasoops.imageManagerServer.user.userController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/26
 * @Version 1.0.0
 * @Description: 用户控制器
 */
@RestController
@RequestMapping("register")
@Api(tags = "WM - 注册表")
@ApiSupport(author = "DasoopsNicole@gmail.com")
public class RegisterController {

    private final RegisterWebService registerWebService;

    public RegisterController(RegisterWebService registerWebService) {
        this.registerWebService = registerWebService;
    }

    @PostMapping("login")
    @ApiOperation(value = "登录", notes = "登录")
    public Result<LoginVo> login(@RequestBody LoginParam loginParam) {
        return Result.success(registerWebService.login(loginParam));
    }

}

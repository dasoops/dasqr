package com.dasoops.dasserver.controller;

import com.dasoops.common.entity.vo.result.Result;
import com.dasoops.dasserver.model.param.LoginParam;
import com.dasoops.dasserver.model.vo.LoginVo;
import com.dasoops.dasserver.service.RegisterWebService;
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
public class RegisterController {

    private final RegisterWebService registerWebService;

    public RegisterController(RegisterWebService registerWebService) {
        this.registerWebService = registerWebService;
    }

    @PostMapping("login")
    public Result<LoginVo> login(@RequestBody LoginParam loginParam) {
        return Result.success(registerWebService.login(loginParam));
    }

}

package com.dasoops.dasserver.plugin.webmanager.controller

import com.dasoops.common.entity.result.Result
import com.dasoops.common.entity.result.PageResult
import com.dasoops.common.entity.result.SimpleResult
import com.dasoops.common.util.ExcelUtil
import com.dasoops.common.util.entity.ExportInfo
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.EditRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetFantasyRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.LoginParam
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.*
import com.dasoops.dasserver.plugin.webmanager.service.RegisterWebService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

/**
 * @title userController
 * @classPath com.dasoops.imageManagerServer.user.userController
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/26
 * @version 1.0.0
 * @description 注册对象控制器
 */
@RestController
@RequestMapping("register")
@Api(tags = ["WM - 注册表"])
@RequiredArgsConstructor
class RegisterController(
    private val registerWebService: RegisterWebService,
) {

    @PostMapping("login")
    @ApiOperation(value = "登录", notes = "登录")
    fun login(@RequestBody loginParam: LoginParam): Result<LoginVo> {
        return Result.success(registerWebService.login(loginParam))
    }

    @GetMapping("getFantasyUser")
    @ApiOperation(value = "获取联想用户", notes = "获取联想用户")
    fun getFantasyUser(param: GetFantasyRegisterParam): Result<GetFantasyUserVo> {
        val getFantasyUserVo: GetFantasyUserVo = registerWebService.getFantasyRegister(param)
        return Result.success(getFantasyUserVo)
    }

    @PostMapping("getRegister")
    @ApiOperation(value = "获取注册对象信息", notes = "获取注册对象信息")
    fun getRegister(@RequestBody param: GetRegisterParam): PageResult<out GetRegisterVo> {
        val registerPage = registerWebService.getRegisterPage(param)
        return PageResult.success(registerPage)
    }

    @PostMapping("editRegister")
    @ApiOperation(value = "编辑注册对象", notes = "编辑注册对象")
    fun editRegister(@RequestBody param: EditRegisterParam): SimpleResult {
        registerWebService.editRegister(param)
        return SimpleResult.success()
    }

    @GetMapping("exportAllRegister")
    @ApiOperation(value = "导出所有注册对象", notes = "导出所有注册对象")
    fun exportAllRegister(response: HttpServletResponse) {
        val (registerList, registerPluginList) = registerWebService.exportAllRegister()
        ExcelUtil.export(
            response,
            "registerPluginData",
            listOf(
                ExportInfo.ktBuild(registerList, 0, "registerData"),
                ExportInfo.ktBuild(registerPluginList, 1, "registerPluginData")
            )
        )
    }
}

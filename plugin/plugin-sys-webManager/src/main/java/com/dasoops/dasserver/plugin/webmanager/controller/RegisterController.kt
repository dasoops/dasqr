package com.dasoops.dasserver.plugin.webmanager.controller

import com.dasoops.common.entity.result.PageResult
import com.dasoops.common.entity.result.SimpleResult
import com.dasoops.common.util.ExcelUtil
import com.dasoops.common.util.entity.ExportInfo
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.EditRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.LoginParam
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.GetRegisterVo
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.LoginVo
import com.dasoops.dasserver.plugin.webmanager.service.RegisterWebService
import com.github.xiaoymin.knife4j.annotations.ApiSupport
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

/**
 * @Title: userController
 * @ClassPath com.dasoops.imageManagerServer.user.userController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/26
 * @Version 1.0.0
 * @Description: 注册对象控制器
 */
@RestController
@RequestMapping("register")
@Api(tags = ["WM - 注册表"])
@ApiSupport(author = "DasoopsNicole@gmail.com")
@RequiredArgsConstructor
class RegisterController(
    private val registerWebService: RegisterWebService,
) {

    @PostMapping("login")
    @ApiOperation(value = "登录", notes = "登录")
    fun login(@RequestBody loginParam: LoginParam): Result<LoginVo> {
        return Result.success(registerWebService.login(loginParam))
    }

    @PostMapping("getRegister")
    @ApiOperation(value = "获取注册对象信息", notes = "获取注册对象信息")
    fun getRegister(@RequestBody param: GetRegisterParam): PageResult<GetRegisterVo> {
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

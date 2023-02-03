package com.dasoops.dasserver.plugin.webmanager.service

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.service.IService
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportRegisterDto
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportRegisterMtmDto
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.EditRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.LoginParam
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.GetRegisterVo
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.LoginVo

/**
 * @Title: RegisterService
 * @ClassPath com.dasoops.dasserver.cq.service.RegisterService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_register(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service
 * @see IService
 */
interface RegisterWebService : IService<RegisterDo> {
    /**
     * 登录
     *
     * @param loginParam 登录参数
     * @return [LoginVo]
     */
    fun login(loginParam: LoginParam): LoginVo

    /**
     * 获取注册表分页数据
     * @param [param] param
     * @return [IPage<GetRegisterVo>]
     */
    fun getRegisterPage(param: GetRegisterParam): IPage<GetRegisterVo>

    /**
     * 编辑注册表对象
     * @param [param] param
     */
    fun editRegister(param: EditRegisterParam)

    /**
     * 导出所有注册对象
     * @return [Pair<List<ExportRegisterDto>, List<ExportRegisterMtmDto>>]
     */
    fun exportAllRegister(): Pair<List<ExportRegisterDto>, List<ExportRegisterMtmDto>>
}
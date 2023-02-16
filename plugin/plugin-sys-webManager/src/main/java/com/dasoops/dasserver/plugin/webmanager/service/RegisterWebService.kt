package com.dasoops.dasserver.plugin.webmanager.service

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.service.IService
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportRegisterDto
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportRegisterMtmDto
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.EditRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetFantasyRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.LoginParam
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.GetFantasyUserVo
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.GetRegisterVo
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.LoginVo

/**
 * @title RegisterService
 * @classPath com.dasoops.dasserver.cq.service.RegisterService
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/31
 * @version 1.0.0
 * @description 针对表【tb_core_register(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service
 * @see IService
 */
interface RegisterWebService {
    /**
     * 登录
     *
     * @param  登录参数
     * @return [LoginVo]
     */
    fun login(param: LoginParam): LoginVo

    /**
     * 获取注册表分页数据
     * @param [param] param
     * @return [IPage<GetRegisterVo>]
     */
    fun getRegisterPage(param: GetRegisterParam): IPage<out GetRegisterVo>

    /**
     * 获取联想用户
     *
     * @param param param
     * @return [GetFantasyUserVo]
     */
    fun getFantasyRegister(param: GetFantasyRegisterParam): GetFantasyUserVo

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

    /**
     * 获取 群组id 单对多 群组用户id 映射集合
     * @return [Map<Long, Set<Long>>]
     */
    fun getGroupIdOtmGroupUserIdMap(): Map<Long, Set<Long>>
}
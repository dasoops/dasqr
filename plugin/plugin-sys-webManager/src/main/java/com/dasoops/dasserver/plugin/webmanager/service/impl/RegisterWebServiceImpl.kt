package com.dasoops.dasserver.plugin.webmanager.service.impl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.dasoops.common.exception.LogicException
import com.dasoops.common.util.Convert
import com.dasoops.dasserver.cq.cache.ConfigCache
import com.dasoops.dasserver.cq.cache.RegisterCache
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo
import com.dasoops.dasserver.cq.entity.enums.ConfigHashKeyEnum
import com.dasoops.dasserver.cq.entity.enums.RegisterTypeEnum
import com.dasoops.dasserver.cq.simplesql.RegisterMtmPluginSimpleSql
import com.dasoops.dasserver.cq.simplesql.RegisterSimpleSql
import com.dasoops.dasserver.plugin.authwrapper.task.AuthTask
import com.dasoops.dasserver.plugin.webauth.entity.dto.AuthUserDto
import com.dasoops.dasserver.plugin.webauth.entity.enums.RegisterExceptionEnum
import com.dasoops.dasserver.plugin.webauth.utils.JwtUtil
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportRegisterDto
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportRegisterMtmDto
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.EditRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.LoginParam
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.GetRegisterVo
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.LoginVo
import com.dasoops.dasserver.plugin.webmanager.service.RegisterWebService
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

/**
 * @Title: RegisterServiceImpl
 * @ClassPath com.dasoops.dasserver.cq.service.impl.RegisterServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_register(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service实现
 * @see RegisterWebService
 */
@Service
@Slf4j
@RequiredArgsConstructor
open class RegisterWebServiceImpl(
    private val simpleSql: RegisterSimpleSql,
    private val configCache: ConfigCache,
    private val registerCache: RegisterCache,
    private val authTask: AuthTask,
    private val registerMtmPluginSimpleSql: RegisterMtmPluginSimpleSql,
) : RegisterWebService {

    override fun login(loginParam: LoginParam): LoginVo {
        //密码暂无,账号应同密码
        val (username, password) = loginParam
        if (username != password) {
            throw LogicException(RegisterExceptionEnum.LOGIN_FAIL)
        }
        val registerDo: RegisterDo =
            simpleSql.ktQuery().eq(RegisterDo::registerId, username).eq(RegisterDo::type, RegisterTypeEnum.USER.dbValue)
                .one() ?: throw LogicException(RegisterExceptionEnum.LOGIN_FAIL)

        //登录最低权限需求
        val loginLessThanLevel = configCache.getIntegerConfig(ConfigHashKeyEnum.LOGIN_NEED_MIN_LEVEL)
        if (registerDo.level!! > loginLessThanLevel) {
            throw LogicException(RegisterExceptionEnum.NEED_HIGH_LEVEL)
        }
        val registerId = registerDo.registerId!!
        val registerName = registerCache.getRegisterNameByRowId(registerCache.getUserRowIdByRegisterId(registerId))
        val authUserDto = AuthUserDto(registerDo.rowId, registerDo.registerId, registerName)
        return LoginVo(JwtUtil.createToken(authUserDto), registerId, registerName)
    }

    override fun getRegisterPage(param: GetRegisterParam): IPage<GetRegisterVo> {
        TODO("Not yet implemented")
    }

    override fun editRegister(param: EditRegisterParam) {
        authTask.initOrUpdateAuthIdOtmIsPassMap2Cache()
        TODO("Not yet implemented")
    }

    override fun exportAllRegister(): Pair<List<ExportRegisterDto>, List<ExportRegisterMtmDto>> {
        val registerDoList = simpleSql.list()
        val registerMtmPluginDoList = registerMtmPluginSimpleSql.list()

        return Pair(
            Convert.to(registerDoList, ExportRegisterDto::class.java),
            Convert.to(registerMtmPluginDoList, ExportRegisterMtmDto::class.java)
        )
    }
}
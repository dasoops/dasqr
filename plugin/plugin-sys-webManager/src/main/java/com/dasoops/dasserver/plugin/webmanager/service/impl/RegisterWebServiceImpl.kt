package com.dasoops.dasserver.plugin.webmanager.service.impl

import cn.hutool.core.collection.ListUtil
import com.baomidou.mybatisplus.core.metadata.IPage
import com.dasoops.common.entity.enums.DbColumnEnumExceptionEnum
import com.dasoops.common.entity.enums.base.DbBooleanEnum
import com.dasoops.common.exception.LogicException
import com.dasoops.common.util.Assert
import com.dasoops.common.util.Convert
import com.dasoops.dasserver.cq.CqGlobal
import com.dasoops.dasserver.cq.cache.ConfigCache
import com.dasoops.dasserver.cq.cache.RegisterCache
import com.dasoops.dasserver.cq.entity.dbo.PluginDo
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo
import com.dasoops.dasserver.cq.entity.dbo.RegisterMtmPluginDo
import com.dasoops.dasserver.cq.entity.enums.ConfigHashKeyEnum
import com.dasoops.dasserver.cq.entity.enums.RegisterTypeEnum
import com.dasoops.dasserver.cq.simplesql.PluginSimpleSql
import com.dasoops.dasserver.cq.simplesql.RegisterMtmPluginSimpleSql
import com.dasoops.dasserver.cq.simplesql.RegisterSimpleSql
import com.dasoops.dasserver.plugin.authwrapper.cache.AuthWrapperRegisterMtmPluginCache
import com.dasoops.dasserver.plugin.authwrapper.task.AuthTask
import com.dasoops.dasserver.plugin.webauth.entity.dto.AuthUserDto
import com.dasoops.dasserver.plugin.webauth.entity.enums.RegisterExceptionEnum
import com.dasoops.dasserver.plugin.webauth.utils.JwtUtil
import com.dasoops.dasserver.plugin.webmanager.cache.RegisterWebCache
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportRegisterDto
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportRegisterMtmDto
import com.dasoops.dasserver.plugin.webmanager.entity.enums.WebManagerExceptionEnum
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.EditRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetFantasyRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.GetRegisterParam
import com.dasoops.dasserver.plugin.webmanager.entity.param.register.LoginParam
import com.dasoops.dasserver.plugin.webmanager.entity.vo.register.*
import com.dasoops.dasserver.plugin.webmanager.service.RegisterWebService
import com.dasoops.dasserver.plugin.webmanager.util.RegisterFantasyUtil
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

/**
 * 联想用户 最大返回数
 */
private const val FANTASY_USER_MAX_RETURN_COUNT = 5

/**
 * @title RegisterServiceImpl
 * @classPath com.dasoops.dasserver.cq.service.impl.RegisterServiceImpl
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/31
 * @version 1.0.0
 * @description 针对表【tb_core_register(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service实现
 * @see RegisterWebService
 */
@Service
@Slf4j
@RequiredArgsConstructor
open class RegisterWebServiceImpl(
    private val simpleSql: RegisterSimpleSql,
    private val configCache: ConfigCache,
    private val registerCache: RegisterCache,
    private val authCache: AuthWrapperRegisterMtmPluginCache,
    private val authTask: AuthTask,
    private val pluginSimpleSql: PluginSimpleSql,
    private val registerMtmPluginSimpleSql: RegisterMtmPluginSimpleSql,
    private val registerWebCache: RegisterWebCache,
) : RegisterWebService {

    override fun login(param: LoginParam): LoginVo {
        Assert.getInstance().allMustNotNull(param.username, param.password)
        //密码暂无,账号应同密码
        val (username, password) = param
        if (username != password) {
            throw LogicException(RegisterExceptionEnum.LOGIN_FAIL)
        }
        val registerDo: RegisterDo =
            simpleSql.ktQuery()
                .eq(RegisterDo::registerId, username)
                .eq(RegisterDo::type, RegisterTypeEnum.USER.dbValue)
                .one() ?: throw LogicException(RegisterExceptionEnum.LOGIN_FAIL)

        //登录最低权限需求
        val loginLessThanLevel = configCache.getIntegerConfig(ConfigHashKeyEnum.LOGIN_NEED_MIN_LEVEL)
        if (registerDo.level!! > loginLessThanLevel) {
            throw LogicException(RegisterExceptionEnum.NEED_HIGH_LEVEL)
        }
        val registerId = registerDo.registerId!!
        val registerName = registerCache.getRegisterUserNameByRowId(registerCache.getUserRowIdByRegisterId(registerId))
        val authUserDto = AuthUserDto(registerDo.rowId, registerDo.registerId, registerName)
        return LoginVo(JwtUtil.createToken(authUserDto), registerId, registerName)
    }

    override fun getRegisterPage(param: GetRegisterParam): IPage<out GetRegisterVo?> {
        if (param.type != 0 && param.type != 1) {
            throw LogicException(WebManagerExceptionEnum.UNDEFINED_ID)
        }

        val registerDoPage = getRegisterDataPage(param)
        //无记录短路
        if (registerDoPage.total <= 0) {
            return registerDoPage.convert { null }
        }

        //根据type找妈妈
        return when (param.type) {
            RegisterTypeEnum.USER.dbValue -> {
                getUserRegisterPage(registerDoPage)
            }

            RegisterTypeEnum.GROUP.dbValue -> {
                getGroupRegisterPage(registerDoPage)
            }

            else -> {
                throw LogicException(RegisterExceptionEnum.UNDEFINED_TYPE)
            }
        }
    }

    override fun getFantasyRegister(param: GetFantasyRegisterParam): GetFantasyUserVo {
        val registerIdOtoNameMap = when (param.type) {
            RegisterTypeEnum.USER.dbValue -> {
                registerCache.registerUserIdOtoNameMap
            }

            RegisterTypeEnum.GROUP.dbValue -> {
                registerCache.registerGroupIdOtoNameMap
            }

            else -> {
                throw LogicException(RegisterExceptionEnum.UNDEFINED_TYPE)
            }
        }

        //不为空进行匹配 id或名称匹配
        val registerEntryMap = if (param.keyword != null) {
            registerIdOtoNameMap.entries.stream()
                .filter { (key, value) -> key.contains(param.keyword) || value.contains(param.keyword) }
                .collect(Collectors.toMap({ it.key }, { it.value }))
        } else {
            HashMap<String, String>()
        }

        val fantasyUserList = registerEntryMap.entries.stream().map { (key, value) ->
            FantasyRegisterVo().apply {
                registerId = key.toLong()
                name = value
            }
        }.toList()

        return GetFantasyUserVo().apply {
            this.fantasyRegisterList = ListUtil.sub(fantasyUserList, 0, FANTASY_USER_MAX_RETURN_COUNT)
        }
    }

    override fun getGroupIdOtmGroupUserIdMap(): Map<Long, Set<Long>> {
        if (registerWebCache.hasGroupUserCache()) {
            //击中
            return registerWebCache.getGroupUserIdSetByGroupIdMap()
        } else {
            //Hash<群id,Set<群用户id>>
            val groupIdOtoGroupUserIdMap = HashMap<Long, Set<Long>>(8)
            CqGlobal.getAll().stream().forEach { cqTemplate ->
                //获取bot群集合
                cqTemplate.groupList.data.stream().forEach { groupData ->
                    //前面的bot没有查询过
                    if (!groupIdOtoGroupUserIdMap.contains(groupData.groupId)) {
                        //根据groupId再获取群成员集合
                        groupIdOtoGroupUserIdMap[groupData.groupId] = cqTemplate.getGroupMemberList(groupData.groupId).data
                            .stream().map { memberInfo -> memberInfo.userId }.collect(Collectors.toSet())
                    }
                }
            }
            registerWebCache.setGroupIdOtmGroupUserIdMap(groupIdOtoGroupUserIdMap)
            return groupIdOtoGroupUserIdMap
        }
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun editRegister(param: EditRegisterParam) {
        Assert.getInstance().allMustNotNull(param.level, param.rowId, param.passPluginList)
        val pluginIdList = pluginSimpleSql.lambdaQuery().select(PluginDo::rowId).list().map { it.rowId }.toList()

        if (pluginIdList.containsAll(param.passPluginList!!)) {
            throw LogicException(WebManagerExceptionEnum.UNDEFINED_ID)
        }

        val registerRowId = param.rowId
        val paramDo = param.buildDo()

        //更新register主表
        simpleSql.updateById(paramDo)
        val newRegisterMtmPluginList = pluginIdList.map {
            RegisterMtmPluginDo().apply {
                this.pluginId = it
                this.registerRowId = registerRowId
                this.isPass = DbBooleanEnum.getBy(
                    param.passPluginList?.contains(it) ?: throw LogicException(DbColumnEnumExceptionEnum.UNDEFINEND_BOOLEAN_VALUE)
                ).dbValue
            }
        }.toList()

        //更新关联表
        registerMtmPluginSimpleSql.lambdaUpdate().eq(RegisterMtmPluginDo::getRegisterRowId, registerRowId).remove()
        registerMtmPluginSimpleSql.saveBatch(newRegisterMtmPluginList)

        //更新缓存
        CqGlobal.getAll().forEach(authTask::initOrUpdateAll)

    }

    override fun exportAllRegister(): Pair<List<ExportRegisterDto>, List<ExportRegisterMtmDto>> {
        val registerDoList = simpleSql.list()
        val registerMtmPluginDoList = registerMtmPluginSimpleSql.list()

        return Pair(
            Convert.to(registerDoList, ExportRegisterDto::class.java),
            Convert.to(registerMtmPluginDoList, ExportRegisterMtmDto::class.java)
        )
    }

    private fun getRegisterDataPage(param: GetRegisterParam): IPage<RegisterDo> {
        var ktQueryWrapper = simpleSql.ktQuery()

        if (param.keyword.isNullOrEmpty()) {
            //为空 什么也不做
        } else if (RegisterFantasyUtil.isMatch(param.keyword!!)) {
            //有标识符,是已经通过联想关键词接口查找过的registerId
            ktQueryWrapper = ktQueryWrapper.eq(RegisterDo::registerId, param.keyword!!.removePrefix("_").toLong())
        } else {
            //没有标识符不为空,需要通过联想关键词查找
            val registerIdList = with(GetFantasyRegisterParam()) {
                keyword = param.keyword
                getFantasyRegister(this).fantasyRegisterList.stream().map { it.registerId }.toList()
            }
            ktQueryWrapper = ktQueryWrapper.`in`(RegisterDo::registerId, registerIdList)
        }

        //按剩余条件获取结果集
        return ktQueryWrapper
            .ge(param.minLevel != null, RegisterDo::level, param.minLevel)
            .eq(RegisterDo::type, param.type)
            .page(param.buildSelectPage())
    }

    private fun getUserRegisterPage(registerDoPage: IPage<RegisterDo>): IPage<GetRegisterVo> {

        //转为vo
        return registerDoPage.convert {
            val registerName = registerCache.getRegisterUserNameByRowId(it.rowId)
            val authMap = authCache.getAuthMap(it.rowId)
            //通过数
            val passCount = authMap.count { entry -> entry.value }

            GetRegisterVo().apply {
                rowId = it.rowId
                showName = "(${it.registerId}) $registerName"
                //authMap.size 总插件数
                passPluginCountShow = "$passCount / ${authMap.size}"
            }
        }
    }

    private fun getGroupRegisterPage(registerDoPage: IPage<RegisterDo>): IPage<GetGroupRegisterVo> {

        val groupIdOtmGroupUserIdMap = getGroupIdOtmGroupUserIdMap()


        val authMap = authCache.authMap
        return registerDoPage.convert { registerDo ->
            val registerName = registerCache.getRegisterGroupNameById(registerDo.rowId)
            //群可用插件
            val groupPassCount = authMap[registerDo.rowId]!!.count { entry -> entry.value }

            GetGroupRegisterVo().apply {
                //群信息
                rowId = registerDo.rowId
                showName = "(${registerDo.registerId}) $registerName"
                //authMap.size 总插件数
                passPluginCountShow = "$groupPassCount / ${authMap.size}"

                //组装
                groupUserList = ArrayList<GetGroupRegisterInnerVo>().apply {
                    groupIdOtmGroupUserIdMap[registerDo.registerId]!!.forEach { userId ->
                        add(GetGroupRegisterInnerVo().apply {
                            rowId = registerCache.getUserRowIdByRegisterId(userId)
                            showName = "($userId) ${registerCache.getRegisterUserNameByRowId(rowId)}"
                            //用户通过插件
                            val userPassPluginCount = authMap[rowId]!!.count { entry -> entry.value }
                            passPluginCountShow = "$userPassPluginCount / $groupPassCount"
                        })
                    }

                }
            }
        }
    }
}
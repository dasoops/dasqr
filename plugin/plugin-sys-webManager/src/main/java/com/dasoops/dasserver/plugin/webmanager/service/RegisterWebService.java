package com.dasoops.dasserver.plugin.webmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.plugin.webmanager.entity.param.LoginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.LoginVo;

/**
 * @Title: RegisterService
 * @ClassPath com.dasoops.dasserver.cq.service.RegisterService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_register(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service
 * @see IService
 */
public interface RegisterWebService extends IService<RegisterDo> {

    /**
     * 登录
     *
     * @param loginParam 登录参数
     * @return {@link LoginVo}
     */
    LoginVo login(LoginParam loginParam);

    /**
     * 初始化或更新 注册表主键id 单对单 名称,注册表用户id 单对单 名称 to缓存
     *
     * @param cqTemplate cqTemplate
     */
    void initOrUpdateRegisterRowIdOtoNameMapAndRegisterUserIdOtoNameMap2Cache(CqTemplate cqTemplate);

}

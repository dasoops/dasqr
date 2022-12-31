package com.dasoops.dasserver.plugin.webManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.plugin.webManager.entity.param.LoginParam;
import com.dasoops.dasserver.plugin.webManager.entity.vo.LoginVo;

/**
 * @Title: RegisterService
 * @ClassPath com.dasoops.dasserver.cq.service.RegisterService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_REGISTER(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service
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
}

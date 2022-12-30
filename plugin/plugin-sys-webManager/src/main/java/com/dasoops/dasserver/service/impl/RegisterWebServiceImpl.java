package com.dasoops.dasserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.cq.entity.enums.ConfigHashKeyEnum;
import com.dasoops.dasserver.cq.entity.enums.RegisterTypeEnum;
import com.dasoops.dasserver.cq.mapper.RegisterMapper;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.entity.dto.AuthUserDto;
import com.dasoops.dasserver.entity.enums.RegisterExceptionEnum;
import com.dasoops.dasserver.model.param.LoginParam;
import com.dasoops.dasserver.model.vo.LoginVo;
import com.dasoops.dasserver.service.RegisterWebService;
import com.dasoops.dasserver.utils.JwtUtil;
import org.springframework.stereotype.Service;

/**
 * @Title: RegisterServiceImpl
 * @ClassPath com.dasoops.dasserver.cq.service.impl.RegisterServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_REGISTER(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service实现
 * @see ServiceImpl
 * @see RegisterService
 */
@Service
public class RegisterWebServiceImpl extends ServiceImpl<RegisterMapper, RegisterDo>
        implements RegisterWebService {

    private final ConfigCache configCache;

    public RegisterWebServiceImpl(ConfigCache configCache) {
        this.configCache = configCache;
    }

    @Override
    public LoginVo login(LoginParam loginParam) {

        Assert.allMustNotNull(loginParam, loginParam.getUsername(), loginParam.getPassword());

        //密码暂无,账号应同密码
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        if (username.equals(password)) {
            RegisterDo registerDo = super.lambdaQuery()
                    .eq(RegisterDo::getRegisterId, username)
                    .eq(RegisterDo::getType, RegisterTypeEnum.USER.getDbValue())
                    .one();

            if (registerDo == null){
                throw new LogicException(RegisterExceptionEnum.LOGIN_FAIL);
            }

            //登录最低权限需求
            final Integer loginLessThanLevel = Integer.valueOf(configCache.getConfig(ConfigHashKeyEnum.LOGIN_NEED_MIN_LEVEL));
            if (registerDo.getLevel() <= loginLessThanLevel) {
                throw new LogicException(RegisterExceptionEnum.NEED_HIGH_LEVEL);
            }

            LoginVo loginVo = new LoginVo();

            AuthUserDto authUserDto = new AuthUserDto();
            authUserDto.setId(registerDo.getId());
            authUserDto.setRegisterId(registerDo.getRegisterId());
            loginVo.setToken(JwtUtil.createToken(authUserDto));
            return loginVo;
        }

        throw new LogicException(RegisterExceptionEnum.LOGIN_FAIL);
    }

}





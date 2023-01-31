package com.dasoops.dasserver.plugin.webmanager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.cache.RegisterCache;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.cq.entity.enums.ConfigHashKeyEnum;
import com.dasoops.dasserver.cq.entity.enums.RegisterTypeEnum;
import com.dasoops.dasserver.cq.service.RegisterService;
import com.dasoops.dasserver.plugin.webauth.entity.dto.AuthUserDto;
import com.dasoops.dasserver.plugin.webauth.entity.enums.RegisterExceptionEnum;
import com.dasoops.dasserver.plugin.webauth.utils.JwtUtil;
import com.dasoops.dasserver.plugin.webmanager.entity.param.LoginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.LoginVo;
import com.dasoops.dasserver.plugin.webmanager.mapper.RegisterWebMapper;
import com.dasoops.dasserver.plugin.webmanager.service.RegisterWebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Title: RegisterServiceImpl
 * @ClassPath com.dasoops.dasserver.cq.service.impl.RegisterServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_register(注册表,储存用户注册信息,初始权限,群组注册信息)】的数据库操作Service实现
 * @see ServiceImpl
 * @see RegisterService
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RegisterWebServiceImpl extends ServiceImpl<RegisterWebMapper, RegisterDo>
        implements RegisterWebService {

    private final ConfigCache configCache;
    private final RegisterCache registerCache;

    @Override
    public LoginVo login(LoginParam loginParam) {

        Assert.getInstance().allMustNotNull(loginParam, loginParam.getUsername(), loginParam.getPassword());

        //密码暂无,账号应同密码
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        if (!username.equals(password)) {
            throw new LogicException(RegisterExceptionEnum.LOGIN_FAIL);
        }

        RegisterDo registerDo = super.lambdaQuery()
                .eq(RegisterDo::getRegisterId, username)
                .eq(RegisterDo::getType, RegisterTypeEnum.USER.getDbValue())
                .one();

        if (registerDo == null) {
            throw new LogicException(RegisterExceptionEnum.LOGIN_FAIL);
        }

        //登录最低权限需求
        final Integer loginLessThanLevel = configCache.getIntegerConfig(ConfigHashKeyEnum.LOGIN_NEED_MIN_LEVEL);
        if (registerDo.getLevel() > loginLessThanLevel) {
            throw new LogicException(RegisterExceptionEnum.NEED_HIGH_LEVEL);
        }

        LoginVo loginVo = new LoginVo();

        Long registerId = registerDo.getRegisterId();
        String registerName = registerCache.getRegisterNameByRowId(registerCache.getUserRowIdByRegisterId(registerId));
        AuthUserDto authUserDto = new AuthUserDto();
        authUserDto.setRowId(registerDo.getRowId());
        authUserDto.setRegisterId(registerId);
        authUserDto.setName(registerName);
        loginVo.setToken(JwtUtil.createToken(authUserDto));
        loginVo.setRegisterId(registerId);
        loginVo.setName(registerName);
        return loginVo;

    }

}





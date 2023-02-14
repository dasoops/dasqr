package com.dasoops.dasserver.plugin.authwrapper.wrapper;

import com.dasoops.dasserver.cq.wrapper.AuthWrapper;
import com.dasoops.dasserver.plugin.authwrapper.utils.AuthUtil;
import org.springframework.stereotype.Component;

/**
 * @title: AuthWrapperImpl
 * @classPath com.dasoops.dasserver.plugin.authwrapper.entity.wrapper.AuthWrapperImpl
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/15
 * @version 1.0.0
 * @description 身份验证实现impl
 * @see AuthWrapper
 */
@Component
public class AuthWrapperImpl implements AuthWrapper {

    @Override
    public boolean auth(String classPath) {
        return AuthUtil.auth(classPath);
    }

    @Override
    public Integer getOrder() {
        return 10;
    }
}
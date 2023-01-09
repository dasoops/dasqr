package com.dasoops.dasserver.plugin.authwrapper.wrapper;

import com.dasoops.dasserver.cq.wrapper.AuthWrapper;
import com.dasoops.dasserver.plugin.authwrapper.utils.AuthUtil;
import org.springframework.stereotype.Component;

/**
 * @Title: AuthWrapperImpl
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.entity.wrapper.AuthWrapperImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/15
 * @Version 1.0.0
 * @Description: 身份验证实现impl
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
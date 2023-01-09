package com.dasoops.dasserver.cq.util;

import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.cq.entity.enums.RegisterTypeEnum;
import com.dasoops.dasserver.entity.enums.ConfigHashKeyEnum;
import org.springframework.stereotype.Component;

/**
 * @Title: RegisterUtil
 * @ClassPath com.dasoops.dasserver.cq.util.RegisterUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 注册工具类
 */
@Component
public class RegisterUtil {

    private static ConfigCache configCache;

    public RegisterUtil(ConfigCache configCache) {
        RegisterUtil.configCache = configCache;
    }

    /**
     * 构建新注册用户do对象
     *
     * @param registerId       注册id
     * @param registerTypeEnum 注册枚举类型
     * @return {@link RegisterDo}
     */
    public static RegisterDo buildNewRegisterDo(Long registerId, RegisterTypeEnum registerTypeEnum) {
        int defaultLevel;
        if (registerTypeEnum.equals(RegisterTypeEnum.USER)) {
            defaultLevel = configCache.getIntegerConfig(ConfigHashKeyEnum.DEFAULT_USER_LEVEL);
        } else {
            defaultLevel = configCache.getIntegerConfig(ConfigHashKeyEnum.DEFAULT_GROUP_LEVEL);
        }
        RegisterDo registerDo = new RegisterDo();
        registerDo.setRegisterId(registerId);
        registerDo.setType(registerTypeEnum.getDbValue());
        registerDo.setLevel(defaultLevel);
        return registerDo;
    }

}

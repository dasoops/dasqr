package com.dasoops.dasserver.plugin.authwrapper.utils;

import com.dasoops.dasserver.cq.cache.RegisterCache;
import com.dasoops.dasserver.cq.util.RegisterMtmPluginUtil;
import com.dasoops.dasserver.cq.EventUtil;
import com.dasoops.dasserver.cq.utils.entity.EventInfo;
import com.dasoops.dasserver.plugin.authwrapper.cache.AuthWrapperPluginCache;
import com.dasoops.dasserver.plugin.authwrapper.cache.AuthWrapperRegisterMtmPluginCache;
import org.springframework.stereotype.Component;

/**
 * @Title: AuthUtil
 * @ClassPath com.dasoops.dasserver.plugin.authwrapper.utils.AuthUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/27
 * @Version 1.0.0
 * @Description: 身份验证工具
 * @see RegisterMtmPluginUtil
 */
@Component
public class AuthUtil {

    private static AuthWrapperRegisterMtmPluginCache authWrapperRegisterMtmPluginCache;
    private static AuthWrapperPluginCache authWrapperPluginCache;
    private static RegisterCache registerCache;

    public AuthUtil(AuthWrapperRegisterMtmPluginCache authWrapperRegisterMtmPluginCache, AuthWrapperPluginCache authWrapperPluginCache, RegisterCache registerCache) {
        AuthUtil.authWrapperRegisterMtmPluginCache = authWrapperRegisterMtmPluginCache;
        AuthUtil.authWrapperPluginCache = authWrapperPluginCache;
        AuthUtil.registerCache = registerCache;
    }

    /**
     * 身份验证
     *
     * @param classPath 类路径
     * @return boolean
     */
    public static boolean auth(String classPath) {
        Long pluginId = authWrapperPluginCache.getIdByPluginClassPath(classPath);

        EventInfo eventInfo = EventUtil.get();
        if (EventUtil.isGroup()) {
            Long groupId = eventInfo.getGroupId();
            Long groupRowId = registerCache.getGroupRowIdByRegisterId(groupId);
            boolean isPass = authWrapperRegisterMtmPluginCache.getPluginIsPassByRegisterRowIdAndPluginId(groupRowId, pluginId);
            if (!isPass) {
                return false;
            }
        }

        Long userId = eventInfo.getAuthorId();
        Long userRowId = registerCache.getUserRowIdByRegisterId(userId);
        return authWrapperRegisterMtmPluginCache.getPluginIsPassByRegisterRowIdAndPluginId(userRowId, pluginId);
    }

}

package com.dasoops.dasserver.plugin.authwrapper.utils;

import com.dasoops.dasserver.plugin.authwrapper.cache.PluginCache;
import com.dasoops.dasserver.plugin.authwrapper.cache.RegisterMtmPluginCache;
import com.dasoops.dasserver.cq.util.RegisterMtmPluginUtil;
import com.dasoops.dasserver.cq.utils.EventUtil;
import com.dasoops.dasserver.cq.utils.entity.EventInfo;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
public class AuthUtil{

    private static RegisterMtmPluginCache registerMtmPluginCache;
    private static PluginCache pluginCache;

    public AuthUtil(RegisterMtmPluginCache registerMtmPluginCache, PluginCache pluginCache) {
        AuthUtil.registerMtmPluginCache = registerMtmPluginCache;
        AuthUtil.pluginCache = pluginCache;
    }

    /**
     * 身份验证
     *
     * @param classPath 类路径
     * @return boolean
     */
    public static boolean auth(String classPath) {
        Long pluginId = pluginCache.getIdByPluginClassPath(classPath);


        EventInfo eventInfo = EventUtil.get();
        if (EventUtil.isGroup()) {
            Long groupId = eventInfo.getGroupId();
            boolean auth = registerMtmPluginCache.auth(groupId, pluginId);
            if (!auth) {
                return false;
            }
        }

        Long authorId = eventInfo.getAuthorId();
        return registerMtmPluginCache.auth(authorId, pluginId);
    }

}

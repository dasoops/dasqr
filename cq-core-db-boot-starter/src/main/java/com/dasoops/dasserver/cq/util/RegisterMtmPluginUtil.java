package com.dasoops.dasserver.cq.util;

import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.cq.entity.dbo.RegisterMtmPluginDo;
import com.dasoops.dasserver.cq.entity.enums.RegisterMtmPluginIsPassEnum;
import org.springframework.stereotype.Component;

/**
 * @title RegisterMtmPluginUtil
 * @classPath com.dasoops.dasserver.cq.util.RegisterMtmPluginUtil
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/27
 * @version 1.0.0
 * @description 注册用户 插件 多对多 工具类
 */
@Component
public class RegisterMtmPluginUtil {
    /**
     * 构建新do
     *
     * @param registerDo 注册对象do
     * @param pluginDo   插件do
     * @return {@link RegisterMtmPluginDo}
     */
    public static RegisterMtmPluginDo buildNewRegisterMtmPluginDo(RegisterDo registerDo, PluginDo pluginDo) {
        RegisterMtmPluginDo registerMtmPluginDo = new RegisterMtmPluginDo();
        registerMtmPluginDo.setRegisterRowId(registerDo.getRowId());
        registerMtmPluginDo.setPluginId(pluginDo.getRowId());

        Integer pluginLevel = pluginDo.getLevel();
        Integer registerLevel = registerDo.getLevel();
        if (registerLevel <= pluginLevel) {
            registerMtmPluginDo.setIsPass(RegisterMtmPluginIsPassEnum.TRUE.getDbValue());
        } else {
            registerMtmPluginDo.setIsPass(RegisterMtmPluginIsPassEnum.FALSE.getDbValue());
        }
        return registerMtmPluginDo;
    }

}

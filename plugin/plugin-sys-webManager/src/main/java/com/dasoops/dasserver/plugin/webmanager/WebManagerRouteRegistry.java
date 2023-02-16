package com.dasoops.dasserver.plugin.webmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * @title WebManagerRouteRegister
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.WebManagerRouteRegister
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/24
 * @version 1.0.0
 * @description webManager路由注册表
 */
public class WebManagerRouteRegistry {

    private final List<String> registerRouteList = new ArrayList<>();

    public void registerRoute(String... keys) {
        registerRouteList.addAll(List.of(keys));
    }

    public List<String> getRegisterRouteList() {
        return registerRouteList;
    }

}

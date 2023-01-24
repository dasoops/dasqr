package com.dasoops.dasserver.plugin.webmanager.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: WebManagerRouteRegister
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.entity.WebManagerRouteRegister
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/24
 * @Version 1.0.0
 * @Description: webManager路由注册表
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

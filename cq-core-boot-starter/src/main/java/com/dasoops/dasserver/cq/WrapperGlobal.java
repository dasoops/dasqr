package com.dasoops.dasserver.cq;

import com.dasoops.dasserver.cq.wrapper.AuthWrapper;
import com.dasoops.dasserver.cq.wrapper.ExceptionWrapper;
import com.dasoops.dasserver.cq.wrapper.WsWrapper;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @title WrapperGlobal
 * @classPath com.dasoops.dasserver.cq.WrapperGlobal
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/06
 * @version 1.0.0
 * @description 条件构造器
 */
public class WrapperGlobal {

    private static ApplicationContext applicationContext;

    private static List<AuthWrapper> authWrapperList = new ArrayList<>();

    private static List<ExceptionWrapper> exceptionWrapperList = new ArrayList<>();

    private static List<WsWrapper> wsWrapperList = new ArrayList<>();

    public static void refresh() {
        WrapperGlobal.authWrapperList = applicationContext.getBeansOfType(AuthWrapper.class).values().stream().sorted(Comparator.comparingInt(AuthWrapper::getOrder)).toList();
        WrapperGlobal.exceptionWrapperList = applicationContext.getBeansOfType(ExceptionWrapper.class).values().stream().sorted(Comparator.comparingInt(ExceptionWrapper::getOrder)).toList();
        WrapperGlobal.wsWrapperList = applicationContext.getBeansOfType(WsWrapper.class).values().stream().sorted(Comparator.comparingInt(WsWrapper::getOrder)).toList();
    }

    public static List<AuthWrapper> getAuthWrapperList() {
        return authWrapperList;
    }

    public static List<ExceptionWrapper> getExceptionWrapperList() {
        return exceptionWrapperList;
    }

    public static List<WsWrapper> getWsWrapperList() {
        return wsWrapperList;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        WrapperGlobal.applicationContext = applicationContext;
    }

}

package com.dasoops.dasserver.cq;

import java.util.*;

/**
 * @title WsConnection
 * @classPath com.dasoops.dasserver.cq.websocket.WsConnection
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description ws连接
 */
public class CqGlobal {
    /**
     * cq集合
     * Map<QId,CqTemplate>
     */
    private static final Map<Long, CqTemplate> CQ_TEMPLATE_MAP = new HashMap<>();


    /**
     * cqTemplate 本地线程池
     */
    private static final ThreadLocal<CqTemplate> CQ_TEMPLATE_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取cqTemplate
     *
     * @return {@link CqTemplate}
     */
    public static CqTemplate get() {
        return CQ_TEMPLATE_THREAD_LOCAL.get();
    }

    /**
     * 设置cqTemplate
     *
     * @param cqTemplate cqTemplate
     */
    public static void setThreadLocal(CqTemplate cqTemplate) {
        CQ_TEMPLATE_THREAD_LOCAL.set(cqTemplate);
    }

    public static CqTemplate remove(Long id) {
        return CqGlobal.CQ_TEMPLATE_MAP.remove(id);
    }

    public static void put(Long selfId, CqTemplate cqTemplate) {
        CQ_TEMPLATE_MAP.put(selfId, cqTemplate);
    }

    public static CqTemplate get(Long key) {
        return CqGlobal.CQ_TEMPLATE_MAP.get(key);
    }

    public static Optional<CqTemplate> findFirst() {
        return CqGlobal.CQ_TEMPLATE_MAP.values().stream().findFirst();
    }

    public static List<CqTemplate> getAll() {
        return CQ_TEMPLATE_MAP.values().stream().toList();
    }

    public static void removeThreadLocal() {
        CQ_TEMPLATE_THREAD_LOCAL.remove();
    }

}

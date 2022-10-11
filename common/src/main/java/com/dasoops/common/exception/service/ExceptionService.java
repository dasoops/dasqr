package com.dasoops.common.exception.service;

/**
 * @Title: exceptionService
 * @ClassPath com.dasoops.common.exception.service.exceptionService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/11
 * @Version 1.0.0
 * @Description: 异常服务
 */
public interface ExceptionService {
    /**
     * 获取异常
     *
     * @param errorId
     * @return {@link String}
     */
    String getException(String errorId);

    /**
     * 保存异常
     *
     * @param errorId 错误id
     * @param msg     味精
     */
    void saveException(String errorId, String msg);
}

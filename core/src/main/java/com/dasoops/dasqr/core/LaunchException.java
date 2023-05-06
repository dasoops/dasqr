package com.dasoops.dasqr.core;

/**
 * 启动异常
 *
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/06
 * @see RuntimeException
 */
public class LaunchException extends RuntimeException {
    public LaunchException(String message) {
        super(message);
    }
}

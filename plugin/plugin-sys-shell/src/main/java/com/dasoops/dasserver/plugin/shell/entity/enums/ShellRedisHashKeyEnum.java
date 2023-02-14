package com.dasoops.dasserver.plugin.shell.entity.enums;


import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: ShellRedisHashKeyEnum
 * @classPath com.dasoops.dasserver.plugin.shell.entity.enums.ShellRedisHashKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/23
 * @version 1.0.0
 * @description rhke快速生成
 * @see Enum
 * @see IRedisHashKeyEnum
 */
@AllArgsConstructor
@Getter
public enum ShellRedisHashKeyEnum implements IRedisHashKeyEnum {

    /**
     * shell连接地址
     */
    WEB_SOCKET_URL("webSocketUrl"),
    /**
     * shell配置
     */
    SHELL_CONFIG("shellConfig");

    final String key;
}

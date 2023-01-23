package com.dasoops.dasserver.plugin.shell.entity.enums;


import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: ShellRedisHashKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.shell.entity.enums.ShellRedisHashKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: rhke快速生成
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
    ;

    final String key;
}

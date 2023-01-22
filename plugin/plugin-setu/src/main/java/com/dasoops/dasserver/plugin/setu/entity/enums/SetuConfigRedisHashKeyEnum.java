package com.dasoops.dasserver.plugin.setu.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: SetuConfigHashKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.setu.entity.enums.SetuConfigHashKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/22
 * @Version 1.0.0
 * @Description: setuConfigHasKeyEnum
 * @see Enum
 * @see IRedisHashKeyEnum
 */
@AllArgsConstructor
@Getter
public enum SetuConfigRedisHashKeyEnum implements IRedisHashKeyEnum {

    /**
     * setuApi请求地址
     */
    API_REQUEST_BASE_URL("apiRequestBaseUrl"),
    /**
     * image代理url
     */
    IMAGE_PROXY_BASE_URL("imageProxyBaseUrl"),
    /**
     * 是否屏蔽ai(boolean)
     */
    EXCLUDED_AI("excludedAi"),
    /**
     * 默认r18
     */
    DEFAULT_R18("defaultR18");

    final String key;
}
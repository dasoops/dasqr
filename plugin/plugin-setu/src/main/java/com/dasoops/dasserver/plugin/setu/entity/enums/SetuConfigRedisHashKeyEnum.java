package com.dasoops.dasserver.plugin.setu.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: SetuConfigHashKeyEnum
 * @classPath com.dasoops.dasserver.plugin.setu.entity.enums.SetuConfigHashKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/22
 * @version 1.0.0
 * @description setuConfigHasKeyEnum
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
    DEFAULT_R18("defaultR18"),
    /**
     * pixiv画廊url
     */
    PIXIV_ART_WORKS_URL("pixivArtWorksUrl"),
    /**
     * 代理画廊url
     */
    PROXY_ART_WORKS_URL("proxyArtWorksUrl"),

    ;

    final String key;
}
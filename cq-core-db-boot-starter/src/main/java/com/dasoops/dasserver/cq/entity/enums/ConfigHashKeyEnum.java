package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.Getter;

/**
 * @title ConfigEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.ConfigEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/01
 * @version 1.0.0
 * @description 配置枚举
 * @see Enum
 */
public enum ConfigHashKeyEnum implements IRedisHashKeyEnum {

    /**
     * 版本
     */
    CLOUD_VERSION("cloudVersion"),
    /**
     * 本地运行版本
     */
    LOCAL_VERSION("localVersion"),
    /**
     * 默认权限等级
     */
    DEFAULT_USER_LEVEL("defaultUserLevel"),
    /**
     * 默认群组权限等级
     */
    DEFAULT_GROUP_LEVEL("defaultGroupLevel"),

    /**
     * 登录webManager所需的最低level
     */
    LOGIN_NEED_MIN_LEVEL("loginNeedMinLevel"),
    /**
     * 令牌签名密钥
     */
    SIGNER_KEY("signerKey"),
    /**
     * 令牌有效时间(秒)
     */
    TOKEN_EFFECTIVE_SECONDS("tokenEffectiveSeconds"),
    /**
     * 服务模式(0:prod;1:dev)
     */
    SERVER_MODE("serverMode"),
    /**
     * pluginResult快速失败图片
     */
    FAST_FAIL_IMAGE_URL("fastFailImageUrl");

    @Getter
    final String key;

    ConfigHashKeyEnum(String key) {
        this.key = key;
    }
}

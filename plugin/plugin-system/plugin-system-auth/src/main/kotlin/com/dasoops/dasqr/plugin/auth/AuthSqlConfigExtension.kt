package com.dasoops.dasqr.plugin.auth

import com.dasoops.common.json.toJsonStr
import com.dasoops.dasqr.core.config.Config
import com.dasoops.dasqr.core.config.getOrNull

val Config.auth: AuthConfig
    get() {
        getOrNull<AuthConfig>("auth")?.run {
            return this
        }
        //初始化
        addAndInit("auth","权限过滤插件[plugin-system-auth]配置项",AuthConfig().toJsonStr())
        return getOrNull<AuthConfig>("auth")!!
    }

/**
 * 身份验证属性
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/09
 * @see [AuthConfig]
 */
data class AuthConfig(
    /**
     * 跳过单例对象的身份验证
     */
    var skipRegisterError: Boolean = false
)
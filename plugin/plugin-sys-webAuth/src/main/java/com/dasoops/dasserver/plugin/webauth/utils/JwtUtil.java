package com.dasoops.dasserver.plugin.webauth.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ValidateException;
import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.enums.ConfigHashKeyEnum;
import com.dasoops.dasserver.plugin.webauth.entity.dto.AuthUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @title: JwtUtil
 * @classPath cn.qiaoml.utils.auth.JwtUtil
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/28
 * @version 1.0.0
 * @description jwt工具类
 */
@Slf4j
@Component
public class JwtUtil {

    private static Integer TOKEN_EFFECTIVE_SECONDS;
    private static String ALGORITHM_KEY;

    public JwtUtil(ConfigCache configCache) {
        JwtUtil.ALGORITHM_KEY = configCache.getConfig(ConfigHashKeyEnum.SIGNER_KEY);
        JwtUtil.TOKEN_EFFECTIVE_SECONDS = configCache.getIntegerConfig(ConfigHashKeyEnum.TOKEN_EFFECTIVE_SECONDS);
    }

    public static String createToken(AuthUserDto authUserDto) {
        DateTime now = DateUtil.date();
        String token = JWT.create()
                .withExpiresAt(DateUtil.offsetSecond(now, TOKEN_EFFECTIVE_SECONDS))
                .withNotBefore(now)
                .withIssuedAt(now)
                .withPayload(Map.of("loginUser", JSON.toJSONString(authUserDto)))
                .sign(Algorithm.HMAC256(ALGORITHM_KEY));
        return token;
    }

    public static Optional<AuthUserDto> auth(String token) {
        try {
            final String prefix = "Bearer";
            token = token.replaceAll(prefix, "").trim();
            JWTVerifier jwtVerifyer = JWT.require(Algorithm.HMAC256(ALGORITHM_KEY)).build();
            jwtVerifyer.verify(token);
            DecodedJWT jwt = JWT.decode(token);
            String jsonStr = jwt.getClaim("loginUser").asString();
            return Optional.of(JSON.parseObject(jsonStr, AuthUserDto.class));
        } catch (ValidateException e) {
            log.debug("权限验证失败: {}", e.getMessage());
            return Optional.empty();
        } catch (TokenExpiredException e) {
            log.debug("token过期");
            return Optional.empty();
        } catch (JWTVerificationException e) {
            log.debug("token校验失败", e);
            return Optional.empty();
        }
    }
}

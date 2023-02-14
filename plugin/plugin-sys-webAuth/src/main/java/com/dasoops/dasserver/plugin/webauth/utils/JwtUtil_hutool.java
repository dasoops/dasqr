//package com.dasoops.dasserver.webManager.utils;
//
//import cn.hutool.core.date.DateTime;
//import cn.hutool.core.date.DateUtil;
//import cn.hutool.core.exceptions.ValidateException;
//import cn.hutool.jwt.JWT;
//import cn.hutool.jwt.JWTUtil;
//import cn.hutool.jwt.JWTValidator;
//import cn.hutool.jwt.RegisteredPayload;
//import cn.hutool.jwt.signers.JWTSigner;
//import cn.hutool.jwt.signers.JWTSignerUtil;
//import com.alibaba.fastjson2.JSON;
//import com.dasoops.dasserver.cq.cache.ConfigCache;
//import com.dasoops.dasserver.core.entity.enums.ConfigHashKeyEnum;
//import com.dasoops.dasserver.webManager.entity.dto.AuthUserDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
///**
// * @title: JwtUtil
// * @classPath cn.qiaoml.utils.auth.JwtUtil
// * @author DasoopsNicole@Gmail.com
// * @date 2022/11/28
// * @version 1.0.0
// * @description jwt工具类
// */
//@Slf4j
//@Component
//public class JwtUtil {
//
//    private static JWTSigner SIGNER;
//    private static Integer TOKEN_EFFECTIVE_SECONDS;
//
//    public JwtUtil(ConfigCache configCache) {
//        String signerKey = configCache.getConfig(ConfigHashKeyEnum.SIGNER_KEY);
//        JwtUtil.SIGNER = JWTSignerUtil.hs512(signerKey.getBytes());
//        JwtUtil.TOKEN_EFFECTIVE_SECONDS = Integer.parseInt(configCache.getConfig(ConfigHashKeyEnum.TOKEN_EFFECTIVE_SECONDS));
//
//    }
//
//    /**
//     * 创建令牌
//     *
//     * @return {@link String}
//     */
//    public static String createToken(AuthUserDto authUserDto) {
//        //签发token
//        Map<String, Object> map = new HashMap<>(4);
//        DateTime now = DateUtil.date();
//        //立即生效 nbf
//        map.put(RegisteredPayload.NOT_BEFORE, now);
//        //签发时间 iat
//        map.put(RegisteredPayload.ISSUED_AT, now);
//        //有效时间 exp
//        map.put(RegisteredPayload.EXPIRES_AT, DateUtil.offsetSecond(now, TOKEN_EFFECTIVE_SECONDS));
//        //登录信息
//        map.put("loginUser", JSON.toJSONString(authUserDto));
//        return JWTUtil.createToken(map, SIGNER);
//    }
//
//    /**
//     * 身份验证
//     *
//     * @param token 令牌
//     * @return {@link Optional}<{@link AuthUserDto}>
//     */
//    public static Optional<AuthUserDto> auth(String token) {
//        try {
//            final String prefix = "Bearer";
//            token = token.replaceAll(prefix, "").trim();
//            JWT jwt = JWTUtil.parseToken(token);
//            JWTValidator.of(jwt).validateAlgorithm(SIGNER).validateDate();
//            String jsonStr = String.valueOf(jwt.getPayload("loginUser"));
//            return Optional.of(JSON.parseObject(jsonStr, AuthUserDto.class));
//        } catch (ValidateException e) {
//            log.debug("权限验证失败: {}", e.getMessage());
//            return Optional.empty();
//        }
//    }
//
//
//}

package com.dasoops.dasserver.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.RegisteredPayload;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import com.alibaba.fastjson2.JSON;
import com.dasoops.dasserver.cq.entity.dbo.RegisterDo;
import com.dasoops.dasserver.entity.dto.AuthUserDto;
import com.dasoops.dasserver.model.dbo.UserDo;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Title: JwtUtil
 * @ClassPath cn.qiaoml.utils.auth.JwtUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/28
 * @Version 1.0.0
 * @Description: jwt工具类
 */
@Slf4j
public class JwtUtil {

    private static final JWTSigner SIGNER = JWTSignerUtil.hs256("auth".getBytes());
    private static final Integer TOKEN_EFFECTIVE_SECONDS = 36000;

    /**
     * 创建令牌
     *
     * @return {@link String}
     */
    public static String createToken(AuthUserDto authUserDto) {
        //签发token
        Map<String, Object> map = new HashMap<>(4);
        DateTime now = DateUtil.date();
        //立即生效
        map.put(RegisteredPayload.NOT_BEFORE, now);
        //签发时间
        map.put(RegisteredPayload.ISSUED_AT, now);
        //有效一天
        //todo 数据库设置
        map.put(RegisteredPayload.EXPIRES_AT, DateUtil.offsetSecond(now, TOKEN_EFFECTIVE_SECONDS));
        //登录信息
        map.put("loginUser", JSON.toJSONString(authUserDto));
        return JWTUtil.createToken(map, SIGNER);
    }

    /**
     * 身份验证
     *
     * @param token 令牌
     * @return {@link Optional}<{@link UserDo}>
     */
    public static Optional<AuthUserDto> auth(String token) {
        try {
            final String prefix = "Bearer";
            token = token.replaceAll(prefix, "").trim();
            JWT jwt = JWTUtil.parseToken(token);
            JWTValidator.of(jwt).validateAlgorithm(SIGNER).validateDate();
            String jsonStr = String.valueOf(jwt.getPayload("loginUser"));
            return Optional.of(JSON.parseObject(jsonStr, AuthUserDto.class));
        } catch (ValidateException e) {
            log.debug("权限验证失败: {}", e.getMessage());
            return Optional.empty();
        }
    }


}

package com.dasoops.dasserver.plugin.webauth.interceptor;

import com.alibaba.fastjson2.JSON;
import com.dasoops.common.entity.result.SimpleResult;
import com.dasoops.dasserver.cq.EventUtil;
import com.dasoops.dasserver.cq.entity.enums.EventTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.PostTypeEnum;
import com.dasoops.dasserver.cq.utils.entity.EventInfo;
import com.dasoops.dasserver.plugin.webauth.entity.dto.AuthUserDto;
import com.dasoops.dasserver.plugin.webauth.entity.enums.RegisterExceptionEnum;
import com.dasoops.dasserver.plugin.webauth.utils.JwtUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @title: AuthInterceptor
 * @classPath com.dasoops.dasserver.cq.interceptor.AuthInterceptor
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/29
 * @version 1.0.0
 * @description 身份验证拦截器
 * @see HandlerInterceptor
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {

        final String options = "OPTIONS";
        if (options.equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        String token = request.getHeader("Authorization");
        log.debug("token: {}", token);
        Optional<AuthUserDto> authUserDtoOpt;
        if (token == null || (authUserDtoOpt = JwtUtil.auth(token)).isEmpty()) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            ServletOutputStream os = response.getOutputStream();
            SimpleResult result = SimpleResult.fail(RegisterExceptionEnum.AUTH_FAIL);
            os.write(JSON.toJSONBytes(result));
            return false;
        }
        AuthUserDto authUserDto = authUserDtoOpt.get();

        EventInfo eventInfo = new EventInfo();
        eventInfo.setPostType(PostTypeEnum.HTTP_REQUEST.getKey());
        eventInfo.setPostTypeEnum(PostTypeEnum.HTTP_REQUEST);
        eventInfo.setMessageType(EventTypeEnum.HTTP_REQUEST.getKey());
        eventInfo.setEventTypeEnum(EventTypeEnum.HTTP_REQUEST);
        eventInfo.setAuthorId(authUserDto.getRegisterId());
        EventUtil.set(eventInfo);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                @NonNull Object handler, Exception ex) {
        EventUtil.remove();
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}

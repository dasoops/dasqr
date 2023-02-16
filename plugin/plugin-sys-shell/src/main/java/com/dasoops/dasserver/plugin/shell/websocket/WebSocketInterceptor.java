package com.dasoops.dasserver.plugin.shell.websocket;

import com.dasoops.dasserver.plugin.webauth.entity.dto.AuthUserDto;
import com.dasoops.dasserver.plugin.webauth.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @title WebSocketInterceptor
 * @classPath com.dasoops.dasserver.plugin.shell.websocket.WebSocketInterceptor
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/25
 * @version 1.0.0
 * @description webSocket协议
 * 发起请求携带请求头 Sec-WebSocket-Protocol
 * 返回数据必须也包含改请求头 且数据要求一致
 * @see HandshakeInterceptor
 */
@Component
@RequiredArgsConstructor
public class WebSocketInterceptor implements HandshakeInterceptor {

    private static final String TOKEN = "token";
    private static final String TOKEN_HEADER = "Sec-WebSocket-Protocol";
    public static final String AUTH_USER_DTO = "authUserDto";
    private final ShellWsHandelr shellWsHandelr;

    @Override
    public boolean beforeHandshake(@NotNull ServerHttpRequest serverHttpRequest, @NotNull ServerHttpResponse response, @NotNull WebSocketHandler wsHandler, @NotNull Map<String, Object> attributes) throws Exception {
        List<String> authHeaders = serverHttpRequest.getHeaders().get(TOKEN_HEADER);
        if (authHeaders == null || authHeaders.isEmpty()) {
            return false;
        }
        String token = authHeaders.get(0);
        Optional<AuthUserDto> authUserOpt = JwtUtil.auth(token);
        if (authUserOpt.isEmpty()) {
            return false;
        }
        if (!(serverHttpRequest instanceof ServletServerHttpRequest request)) {
            return false;
        }
        HttpSession session = request.getServletRequest().getSession();
        session.setAttribute(TOKEN, authHeaders.get(0));
        shellWsHandelr.setUserId(authUserOpt.get().getRegisterId());

        return true;
    }

    @Override
    public void afterHandshake(@NotNull ServerHttpRequest serverHttpRequest, @NotNull ServerHttpResponse response, @NotNull WebSocketHandler wsHandler, Exception exception) {
        ServletServerHttpRequest request = (ServletServerHttpRequest) serverHttpRequest;
        Object token = request.getServletRequest().getSession().getAttribute(TOKEN);
        ((ServletServerHttpResponse) response).getServletResponse().addHeader(TOKEN_HEADER, token.toString());
    }
}

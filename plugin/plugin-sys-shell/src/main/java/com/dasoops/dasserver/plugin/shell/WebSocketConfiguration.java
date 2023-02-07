package com.dasoops.dasserver.plugin.shell;

import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.plugin.shell.entity.enums.ShellRedisHashKeyEnum;
import com.dasoops.dasserver.plugin.shell.websocket.ShellWsHandelr;
import com.dasoops.dasserver.plugin.shell.websocket.WebSocketInterceptor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Title: WebSocketConfiguration
 * @ClassPath com.dasoops.dasserver.plugin.shell.WebSocketConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: socket配置
 */
@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfiguration implements WebSocketConfigurer {

    private final ShellWsHandelr shellWsHandler;
    private final WebSocketInterceptor webSocketInterceptor;
    private final ConfigCache configCache;

    @Override
    public void registerWebSocketHandlers(@NotNull WebSocketHandlerRegistry registry) {
        registry.addHandler(shellWsHandler, configCache.getStringConfig(ShellRedisHashKeyEnum.WEB_SOCKET_URL))
                .addInterceptors(webSocketInterceptor)
                .setAllowedOrigins("*");
    }
}
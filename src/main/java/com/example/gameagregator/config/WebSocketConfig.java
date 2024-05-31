package com.example.gameagregator.config;

import com.example.gameagregator.service.DownloadHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final DownloadHandler downloadHandler;

    public WebSocketConfig(DownloadHandler downloadHandler) {
        this.downloadHandler = downloadHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(downloadHandler, "/download").setAllowedOrigins("*");
    }
}
package com.example.gameagregator.service;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@Component
public class DownloadHandler extends BinaryWebSocketHandler {

    private final DownloadService downloadService;

    public DownloadHandler(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("WebSocket connection established");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        String fileName = message.getPayload();
        InputStream fileStream = null;
        try {
            fileStream = downloadService.downloadFile(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] buffer = new byte[4096];
        int bytesRead;
        try {
            while ((bytesRead = fileStream.read(buffer)) != -1) {
                ByteBuffer byteBuffer = ByteBuffer.wrap(buffer, 0, bytesRead);
                session.sendMessage(new BinaryMessage(byteBuffer));
            }

            session.close(CloseStatus.NORMAL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        exception.printStackTrace();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("WebSocket connection closed");
    }
}
package com.example.chat_service.socketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.chat_service.dto.MessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component 
public class ChatSocketHandler extends TextWebSocketHandler {
    @Lazy 
    private final ObjectMapper objectMapper;
    private final Map<Long, WebSocketSession> sessions = new ConcurrentHashMap<>();
    public ChatSocketHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override 
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("New WebSocket connection established: " + session.getId());
    }
    @Override 
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        MessageRequest chatMessage = objectMapper.readValue(message.getPayload(), MessageRequest.class);
        long senderId=chatMessage.getSenderId();
        long receiverId=chatMessage.getReceiverId();
        sessions.put(senderId, session);
        WebSocketSession receiverSession = sessions.get(receiverId);
        if (receiverSession != null && receiverSession.isOpen()) {
            receiverSession.sendMessage(new TextMessage(message.getPayload()));
        } else {
            System.out.println("Receiver session not found or closed for receiverId: " + receiverId);
        }
        System.out.println("Received message: " + message.getPayload() + " from session: " + session.getId());
    }
    @Override 
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) throws Exception {
        sessions.entrySet().removeIf(entry -> entry.getValue().equals(session));       
        System.out.println("WebSocket connection closed: " + session.getId());
    }


}

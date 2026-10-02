package com.example.chat_service.model;

import java.time.LocalDateTime;

import com.example.chat_service.enums.ConversationType;

// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;

public class Conversation {
    private long id;
   // @Enumerated(EnumType.STRING)
    private ConversationType conversationType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    



}

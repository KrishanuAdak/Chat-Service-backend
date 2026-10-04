package com.example.chat_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "messages")
public class MessageInfo {
    @Id 
    private long id;
    @NotEmpty 
    private String messages;
    private long senderId;
    private long receiverId;
    @PrePersist
    private void prePersist() {
        sendTime = LocalDateTime.now();
    }
    private LocalDateTime sendTime;

    @PreUpdate 
    private void preUpdate(){
        updatedTime=LocalDateTime.now();
    }
    private LocalDateTime updatedTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return messages;
    }

    public void setMessage(String messages) {
        this.messages = messages;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }
    public MessageInfo() {
    }

    public MessageInfo(long id, String messages, long senderId, long receiverId, LocalDateTime sendTime) {
        this.id = id;
        this.messages = messages;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.sendTime = sendTime;
    }
    
}



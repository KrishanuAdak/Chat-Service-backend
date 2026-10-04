package com.example.chat_service.dto;

public class UserSessionDetails {
    private long userId;
    private long sessionId;
    private long serverId;
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getSessionId() {
        return sessionId;
    }
    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }
    public long getServerId() {
        return serverId;
    }
    public void setServerId(long serverId) {
        this.serverId = serverId;
    }
    

}

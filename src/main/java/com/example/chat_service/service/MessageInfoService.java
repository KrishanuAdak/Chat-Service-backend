package com.example.chat_service.service;

import org.springframework.stereotype.Service;
import com.example.chat_service.dto.MessageRequest;
import com.example.chat_service.model.MessageInfo;
import com.example.chat_service.id_generator.SnowflakeIdGenerator;
import com.example.chat_service.repo.MessagesRepo;
@Service 
public class MessageInfoService {
    private final SnowflakeIdGenerator idGenerator;
    private final MessagesRepo messagesRepo;

    public MessageInfoService(SnowflakeIdGenerator idGenerator, MessagesRepo messagesRepo) {
        this.idGenerator = idGenerator;
        this.messagesRepo = messagesRepo;
    }

    public MessageRequest saveMessage(MessageRequest messageRequest) {
        MessageInfo messageInfo = new MessageInfo();
        long id = idGenerator.generateId();
        messageInfo.setId(id);
        messageInfo.setMessage(messageRequest.getMessage());
        messageInfo.setSenderId(messageRequest.getSenderId());
        messageInfo.setReceiverId(messageRequest.getReceiverId());
        messagesRepo.save(messageInfo);
        return messageRequest;
    }

}


package com.example.chat_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chat_service.model.MessageInfo;

public interface MessagesRepo extends JpaRepository<MessageInfo, Long> {

}

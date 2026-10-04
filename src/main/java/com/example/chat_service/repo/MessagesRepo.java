package com.example.chat_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.chat_service.model.MessageInfo;
@Repository 
public interface MessagesRepo extends JpaRepository<MessageInfo, Long> {

}

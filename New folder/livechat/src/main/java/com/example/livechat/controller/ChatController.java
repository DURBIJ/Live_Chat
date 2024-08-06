package com.example.livechat.controller;


import com.example.livechat.model.Message;
import com.example.livechat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        message.setTimestamp(new Date());
        message.setExpiresAt(new Date(System.currentTimeMillis() + 60000)); // Message expires in 1 minute
        messageRepository.save(message);
        return message;
    }

    @Scheduled(fixedRate = 60000)
    public void deleteExpiredMessages() {
        messageRepository.deleteByExpiresAtBefore(new Date());
    }
}
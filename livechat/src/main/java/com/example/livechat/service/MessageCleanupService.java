package com.example.livechat.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.livechat.repository.MessageRepository;

import java.sql.Timestamp;

@Service
public class MessageCleanupService {

    private final MessageRepository messageRepository;

    public MessageCleanupService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Scheduled(fixedRate = 60000) // Every 60 seconds
    public void cleanupExpiredMessages() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        messageRepository.findByExpiryTimeBefore(now);
    }
}
package com.example.livechat.service;


import org.springframework.stereotype.Service;

import com.example.livechat.repository.MessageRepository;

@Service
public class ChatService {

    private final MessageRepository messageRepository;

    public ChatService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void processMessage(String payload) {
        // Parse payload and save message to the database
        // Example payload: {"senderId":1,"receiverId":2,"content":"Hello","timestamp":"2024-08-06T10:00:00","expiryTime":"2024-08-06T10:05:00"}
        // Save to database using messageRepository
    }
}
package com.example.livechat.controller;


import org.springframework.web.bind.annotation.*;

import com.example.livechat.model.Message;
import com.example.livechat.model.User;
import com.example.livechat.repository.MessageRepository;
import com.example.livechat.repository.UserRepository;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public ChatController(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @PostMapping("/users")
    public User createUser(@RequestParam String username) {
        User user = new User();
        user.setUsername(username);
        user.setLastLogin(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/messages")
    public Message sendMessage(@RequestBody Message message) {
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return messageRepository.save(message);
    }

    @GetMapping("/messages/{userId}")
    public List<Message> getMessages(@PathVariable Long userId) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return messageRepository.findByExpiryTimeBefore(now);
    }
}
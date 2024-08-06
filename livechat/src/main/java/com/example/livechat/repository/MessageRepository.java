package com.example.livechat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.livechat.model.Message;

import java.sql.Timestamp;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByExpiryTimeBefore(Timestamp now);
}
package com.example.livechat.repository;

import org.springframework.stereotype.Repository;
import com.example.livechat.model.Message;
import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    void deleteByExpiresAtBefore(Date now);
    List<Message> findByExpiresAtAfter(Date now);
}

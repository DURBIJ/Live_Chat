package com.example.livechat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="messages")
@Data
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String sender;
    
    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    private Date timestamp;
    
    @Column(nullable = false)
    private Date expiresAt;
}
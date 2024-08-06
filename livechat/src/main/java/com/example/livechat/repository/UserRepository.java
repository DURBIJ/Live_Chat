package com.example.livechat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.livechat.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
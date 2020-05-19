package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

public interface AdminUserRepo extends JpaRepository<User, Long>{
}



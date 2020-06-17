package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Card;

public interface CardRepo extends JpaRepository<Card, Long>{

}

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Logbook;

public interface AdminLogbookRepo extends JpaRepository<Logbook, Long> {

}

package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Logbook;

@Repository
public interface Logbookrepo extends JpaRepository<Logbook, Long> {
	
	public List<Logbook> findByUser(String user);
}

package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Logbook;

public interface AdminLogbookRepo extends JpaRepository<Logbook, Long> {

	
	public	List<Logbook> findByUser(String userName);

}

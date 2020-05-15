package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.logbook;

@Repository
public interface logbookrepo extends JpaRepository<logbook, Long> {

}

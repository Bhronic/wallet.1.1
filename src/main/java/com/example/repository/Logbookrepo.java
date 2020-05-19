package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Logbook;

@Repository
public interface Logbookrepo extends JpaRepository<Logbook, Long> {
	
	public List<Logbook> findByUserAndActive(String user,int active);
	
	
	@Query("FROM Logbook   WHERE  date  BETWEEN   :date1 AND  :date2  AND (user like :user) AND (active like :active)")
	public List<Logbook> findByDateAndActive(@Param("date1") String date1 , @Param("date2") String date2 , @Param("user") String user,@Param("active") int active);
}

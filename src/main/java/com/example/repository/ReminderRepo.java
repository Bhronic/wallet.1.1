package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Reminder;

public interface ReminderRepo extends JpaRepository<Reminder,Long > {

	public Reminder findByid(Long id);
	
	@Query("FROM Reminder ")
	public List<Reminder> getreminderobjects();
}
	
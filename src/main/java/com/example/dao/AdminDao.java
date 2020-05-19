package com.example.dao;

import java.util.List;

import com.example.model.Logbook;
import com.example.model.User;

public interface AdminDao {

	public List<User> viewUsers();
	
	public List<Logbook> viewRecords();
	
}

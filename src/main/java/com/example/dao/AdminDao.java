package com.example.dao;

import java.util.List;

import com.example.model.Admin;
import com.example.model.Logbook;
import com.example.model.User;

public interface AdminDao {

	public List<User> viewUsers();
	
	public List<Logbook> viewRecords();
	
	public String gettime();
	
	public Admin savelog(Admin log);
	
	public List<Admin> viewlogs();
	
	public List<Logbook> findByUser(String userName);
	
	public List<Admin> findByuserName(String userName);
}

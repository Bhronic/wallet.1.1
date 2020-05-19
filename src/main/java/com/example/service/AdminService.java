package com.example.service;

import java.util.List;

import com.example.model.Logbook;
import com.example.model.User;

public interface AdminService {

	public List<User> viewUsers();
	
	public List<Logbook> viewRecords();
}

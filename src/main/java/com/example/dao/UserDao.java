package com.example.dao;

import java.util.List;

import com.example.model.User;
import com.example.model.logbook;

public interface UserDao {
	
	
		public User saveuser(User user);
		
	
		public User findByUserNameAndPassword(String userName , String password);
		
		public logbook saverecord(logbook record);
		
		public List<logbook> getrecordlist();
}

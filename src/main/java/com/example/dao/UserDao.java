package com.example.dao;

import com.example.model.User;

public interface UserDao {
	
	
		public User saveuser(User user);
		
	
		public User findByUserNameAndPassword(String userName , String password);
		
		
}

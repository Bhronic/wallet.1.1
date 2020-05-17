package com.example.service;

import com.example.model.User;

public interface UserService {
	
	public User saveuser(User user);
	
	
	public User findByUserNameAndPassword(String userName , String password);
	
	
}

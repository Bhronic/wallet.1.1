package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;

@Repository
public class UserServiceImpl implements UserService{
	
	

	@Autowired
	private UserDao userdao;
	
	
	@Override
	public User saveuser(User user) {
		// TODO Auto-generated method stub
		return userdao.saveuser(user);
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return userdao.findByUserNameAndPassword(userName, password);
	}

	

}

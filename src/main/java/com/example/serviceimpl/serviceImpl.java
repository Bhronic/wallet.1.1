package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.model.logbook;
import com.example.service.service;

@Repository
public class serviceImpl implements service{
	
	

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

	@Override
	public logbook saverecord(logbook record) {
		// TODO Auto-generated method stub
		return userdao.saverecord(record);
	}

	@Override
	public List<logbook> getrecordlist() {
		// TODO Auto-generated method stub
		return userdao.getrecordlist();
	}
	

}

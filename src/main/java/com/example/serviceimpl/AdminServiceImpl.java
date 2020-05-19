package com.example.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.AdminDao;
import com.example.model.Logbook;
import com.example.model.User;
import com.example.service.AdminService;

@Repository
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao user;
	
	@Override
	public List<User> viewUsers() {
		// TODO Auto-generated method stub
		return user.viewUsers();
	}

	@Override
	public List<Logbook> viewRecords() {
		// TODO Auto-generated method stub
		return user.viewRecords();
	}

}

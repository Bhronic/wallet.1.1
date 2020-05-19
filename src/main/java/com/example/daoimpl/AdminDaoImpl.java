package com.example.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.AdminDao;
import com.example.model.Logbook;
import com.example.model.User;
import com.example.repository.AdminLogbookRepo;
import com.example.repository.AdminUserRepo;


@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
	AdminUserRepo user;
	
	@Autowired
	AdminLogbookRepo logbook;
	
	
	@Override
	public List<User> viewUsers() {
		// TODO Auto-generated method stub
		return user.findAll();
	}


	@Override
	public List<Logbook> viewRecords() {
		// TODO Auto-generated method stub
		return logbook.findAll();
	}
	
	

}

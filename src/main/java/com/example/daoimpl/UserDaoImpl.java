package com.example.daoimpl;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.repository.UserRepo;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	UserRepo userepo;
	

	
	@Override
	public User saveuser(User user) {
		// TODO Auto-generated method stub
		return userepo.save(user) ;
	}



	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return userepo.findByUserNameAndPassword(userName, password);
	}




}

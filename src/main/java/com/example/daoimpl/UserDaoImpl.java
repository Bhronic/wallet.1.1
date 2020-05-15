package com.example.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.model.logbook;
import com.example.repository.UserRepo;
import com.example.repository.logbookrepo;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	UserRepo userepo;
	
	 @Autowired 
	 logbookrepo recordrepo ;
	
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



	@Override
	public logbook saverecord(logbook record) {
		// TODO Auto-generated method stub
		return recordrepo.save(record);
	}



	@Override
	public List<logbook> getrecordlist() {
		// TODO Auto-generated method stub
		return recordrepo.findAll();
	}

}

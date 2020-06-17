package com.example.daoimpl;

import java.text.DateFormat;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.AdminDao;
import com.example.model.Admin;
import com.example.model.Logbook;
import com.example.model.User;
import com.example.repository.AdminLogRepo;
import com.example.repository.AdminLogbookRepo;
import com.example.repository.AdminUserRepo;


@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
	AdminUserRepo user;
	
	@Autowired
	AdminLogbookRepo logbook;
	
	@Autowired
	AdminLogRepo userlog;
	
	
	@Override
	public List<User> viewUsers() {
		// TODO Auto-generated method stub
		return user.findAll();
	}


	@Override
	public List<Logbook> viewRecords() {
		// TODO Auto-generated method stub
		int page=0;
		int total=10;
				
		Pageable pageable =  PageRequest.of(page,total);
		return logbook.findAll();
	}


	@Override
	public String gettime() {
		  DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	       Date dateobj = new Date();
	       String d=df.format(dateobj);
		return d;
	}


	@Override
	public Admin savelog(Admin log) {
		
		return userlog.save(log);
	}


	@Override
	public List<Admin> viewlogs() {
		// TODO Auto-generated method stub
		
		return userlog.findAll(Sort.by(Sort.Direction.DESC, "dateandtime"));
	}


	@Override
	public List<Logbook> findByUser(String userName) {
		// TODO Auto-generated method stub
		return logbook.findByUser(userName);
	}


	@Override
	public List<Admin> findByuserName(String userName) {
		// TODO Auto-generated method stub
		return userlog.findByuserName(userName);
	}
	
	

}

package com.example.daoimpl;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.LogbookDao;
import com.example.model.Logbook;
import com.example.repository.Logbookrepo;

@Repository

@Transactional
public class LogbookDaoImpl implements LogbookDao {
	 
	@Autowired 
	 Logbookrepo recordrepo ;
	
	@Override
	public Logbook saverecord(Logbook record) {
		
			
			return recordrepo.save(record);
	
			
	}



	@Override
	public void deleterecord(Logbook record) {
		// TODO Auto-generated method stub
		 recordrepo.delete(record);
	}



	@Override
	public List<Logbook> findByUser(String user) {
		// TODO Auto-generated method stub
		return recordrepo.findByUser(user);
	}





}

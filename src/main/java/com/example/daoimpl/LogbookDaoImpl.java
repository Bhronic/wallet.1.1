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
		
			
			return recordrepo.saveAndFlush(record);
	
			
	}



	@Override
	public void deleterecord(Logbook record) {
		// TODO Auto-generated method stub
		 record.setActive(1);
	}



	@Override
	public List<Logbook> findByUserAndActive(String user,int active) {
		 
		return recordrepo.findByUserAndActive(user,active);
		
	}



	@Override
	public List<Logbook> findByDateAndActive(String date1, String date2,String user,Integer active) {
		// TODO Auto-generated method stub
		return recordrepo.findByDateAndActive(date1, date2,user,active);
	}





}

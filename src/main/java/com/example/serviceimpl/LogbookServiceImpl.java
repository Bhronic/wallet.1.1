package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.LogbookDao;
import com.example.model.Logbook;
import com.example.service.LogbookService;

@Repository
public class LogbookServiceImpl implements LogbookService {
	@Autowired
	LogbookDao logbookdao;
	
	@Override
	public Logbook saverecord(Logbook record) {
		// TODO Auto-generated method stub
		return logbookdao.saverecord(record);
	}



	@Override
	public void deleterecord(Logbook record) {
		logbookdao.deleterecord(record);
		
	}



	@Override
	public List<Logbook> findByUser(String user) {
		// TODO Auto-generated method stub
		return logbookdao.findByUser(user);
	}

}

package com.example.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.LogbookDao;
import com.example.model.Logbook;
import com.example.service.LogbookService;

@Repository
@Transactional
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
	public List<Logbook> findByUserAndActive(String user,int active) {
		// TODO Auto-generated method stub
		return logbookdao.findByUserAndActive(user,active);
	}



	@Override
	public List<Logbook> findByDateAndActive(String date1, String date2,String user,Integer active) {
		// TODO Auto-generated method stub
		return logbookdao.findByDateAndActive(date1, date2,user,active);
	}

}

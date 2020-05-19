package com.example.service;

import java.util.List;

import com.example.model.Logbook;

public interface LogbookService {
public Logbook saverecord(Logbook record);

public List<Logbook> findByUserAndActive(String user,int active);

public List<Logbook> findByDateAndActive(String date1, String date2,String user,Integer active);

	public void deleterecord(Logbook record);
}

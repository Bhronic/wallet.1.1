package com.example.service;

import java.util.List;

import com.example.model.Logbook;

public interface LogbookService {
public Logbook saverecord(Logbook record);

public List<Logbook> findByUser(String user);
	
	public void deleterecord(Logbook record);
}

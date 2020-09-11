package com.example.dao;

import java.util.List;

import com.example.model.Card;
import com.example.model.Logbook;
import com.example.model.MonthlyExpense;
import com.example.model.Reminder;

public interface LogbookDao {
	public Logbook saverecord(Logbook record);
	
	public List<Logbook> findByUserAndActive(String user,int active,int month,int page);
	
	public void deleterecord(Logbook record);
	
	public List<Logbook> findByDateAndActive(String date1, String date2,String user,Integer active,int page);
	
	public int getCurrentmonth();
	
	public String totalExpenseCrurrentMonth(String user, int active, int currentmonth);
	
	public String totalExpenseFilterRecord( String date1 ,  String date2 , String user, int active);
	
	public Card savecard(Card card); 
	
	public List<Card> viewcards();
	
	public String calculateincome(String payment ,String username, int active);
	
	public String calculateincomecurrentmonth(String payment , String username ,int active,int currentmonth);
	
	public String totalexpense(String user , int active);
	
	public String totalIncomeFilterRecords(String date1 , String date2 , String username,int active,String payment);
	
	public Reminder savereminder(Reminder reminder);
	
	public List<Reminder> viewremider();
	
	public void deletecard(Card card);
	
	public void monthlyexpense(MonthlyExpense monthlyexpense);
	
	public Reminder reminderbyid(Long id);
	
	public void deletereminder(Long id);
	
	public List<Reminder> getreminderobjects();
	
	public int listsize(String username , int currentmonth );
	
	public int filtersize( String date1, String date2,String user,Integer active);
	
	public void getnotification();
	
	public  Logbook  recordbyid(Long id);
}

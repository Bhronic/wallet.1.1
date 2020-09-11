package com.example.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.LogbookDao;
import com.example.model.Card;
import com.example.model.Logbook;
import com.example.model.MonthlyExpense;
import com.example.model.Reminder;
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
	public List<Logbook> findByUserAndActive(String user,int active, int month,int page) {
		// TODO Auto-generated method stub
		return logbookdao.findByUserAndActive(user,active,month, page);
	}



	@Override
	public List<Logbook> findByDateAndActive(String date1, String date2,String user,Integer active,int page) {
		// TODO Auto-generated method stub
		return logbookdao.findByDateAndActive(date1, date2,user,active,page);
	}
	

	@Override
	public int getCurrentmonth() {
		// TODO Auto-generated method stub
		return logbookdao.getCurrentmonth();

		}



	@Override
	public String totalExpenseCrurrentMonth(String user, int active, int currentmonth) {
		// TODO Auto-generated method stub
		return logbookdao.totalExpenseCrurrentMonth(user, active, currentmonth);
	}



	@Override
	public String totalExpenseFilterRecord(String date1, String date2, String user, int active) {
		// TODO Auto-generated method stub
		return logbookdao.totalExpenseFilterRecord(date1, date2, user, active);
	}



	@Override
	public Card savecard(Card card) {
		// TODO Auto-generated method stub
		return logbookdao.savecard(card);
	}



	@Override
	public List<Card> viewcards() {
		// TODO Auto-generated method stub
		return logbookdao.viewcards();
	}



	@Override
	public String calculateincome(String payment, String username, int active) {
		// TODO Auto-generated method stub
		return logbookdao.calculateincome(payment, username, active);
	}



	@Override
	public String calculateincomecurrentmonth(String payment, String username, int active, int currentmonth) {
		// TODO Auto-generated method stub
		return logbookdao.calculateincomecurrentmonth(payment, username, active, currentmonth);
	}



	@Override
	public String totalexpense(String user, int active) {
		// TODO Auto-generated method stub
		return logbookdao.totalexpense(user, active);
	}



	@Override
	public String totalIncomeFilterRecords(String date1, String date2, String username, int active, String payment) {
		// TODO Auto-generated method stub
		return logbookdao.totalIncomeFilterRecords(date1, date2, username, active, payment);
	}



	@Override
	public Reminder savereminder(Reminder reminder) {
		// TODO Auto-generated method stub
		return logbookdao.savereminder(reminder);
	}



	@Override
	public List<Reminder> viewremider() {
		// TODO Auto-generated method stub
		return logbookdao.viewremider();
	}



	@Override
	public void deletecard(Card card) {
		logbookdao.deletecard(card);
		
	}



	@Override
	public void monthlyexpense(MonthlyExpense monthlyexpense) {
			logbookdao.monthlyexpense(monthlyexpense);
		
	}



	@Override
	public Reminder reminderbyid(Long id) {
		// TODO Auto-generated method stub
		return logbookdao.reminderbyid(id);
	}



	@Override
	public void deletereminder(Long id) {
		logbookdao.deletereminder(id);
		
	}





	@Override
	public int listsize(String username, int currentmonth) {
		// TODO Auto-generated method stub
		return logbookdao.listsize(username, currentmonth);
	}



	@Override
	public int filtersize(String date1, String date2, String user, Integer active) {
		// TODO Auto-generated method stub
		return logbookdao.filtersize(date1, date2, user, active);
	}



	@Override
	public List<Reminder> getreminderobjects() {
		// TODO Auto-generated method stub
		return logbookdao.getreminderobjects();
	}



	@Override
	public void getnotification() {
		// TODO Auto-generated method stub
		logbookdao.getnotification();
	}



	@Override
	public  Logbook  recordbyid(Long id) {
		// TODO Auto-generated method stub
		return logbookdao.recordbyid(id);
	}

}

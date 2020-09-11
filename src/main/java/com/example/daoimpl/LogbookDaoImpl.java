package com.example.daoimpl;


import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.LogbookDao;
import com.example.model.Card;
import com.example.model.Logbook;
import com.example.model.MonthlyExpense;
import com.example.model.Reminder;
import com.example.repository.CardRepo;
import com.example.repository.Logbookrepo;
import com.example.repository.MonthlyExpenseRepo;
import com.example.repository.ReminderRepo;

@Repository

@Transactional
public class LogbookDaoImpl implements LogbookDao {
	 
	@Autowired 
	 Logbookrepo recordrepo ;
	
	@Autowired
	CardRepo cardrepo;
	
	@Autowired
	ReminderRepo reminderrepo;
	
	@Autowired 
	MonthlyExpenseRepo monthlyexpenserepo;
	
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
	public List<Logbook> findByUserAndActive(String user,int active,int month,int page) {
		int total=10;
		page=page-1;
		/*if(page==1) {
		page=page-1;
		}else {
			page=(page-1)*total+1;
		}*/
		System.out.print(page);
		Pageable pageable = PageRequest.of(page,total);
		return recordrepo.findByUserAndActive(user,active,month,pageable);
		
	}



	@Override
	public List<Logbook> findByDateAndActive(String date1, String date2,String user,Integer active,int page) {
		int total=10;
		page=page-1;
		Pageable pageable = PageRequest.of(page,total);
		// TODO Auto-generated method stub
		return recordrepo.findByDateAndActive(date1, date2,user,active,pageable);
		
		
	}



	@Override
	public int getCurrentmonth() {
		// TODO Auto-generated method stub
		Date today = new Date(); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);

		int currentmonth = cal.get(Calendar.MONTH);
		currentmonth=currentmonth+1;

		return currentmonth;
		

		}



	@Override
	public String totalExpenseCrurrentMonth(String user, int active, int currentmonth) {
	
		String expense=recordrepo.totalExpenseCrurrentMonth(user, active, currentmonth);
		double total1=0 ,total2=0,totalexpense=0;
		try {
		total1= Double.parseDouble(expense);
	
		String payment ="income";
		String totalincome= recordrepo.calculateincomecurrentmonth(payment, user, active, currentmonth);	
		
		 total2=Double.parseDouble(totalincome);
		 
		}catch(Exception e) {}
		totalexpense= total1-total2;
		String currentexpense = Double.toString(totalexpense);
	       NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN")); 	
	       String india = indiaFormat.format(totalexpense);
		return currentexpense;
	}



	@Override
	public String totalExpenseFilterRecord(String date1, String date2, String user, int active) {
		String expense = null;
		try {
		 expense = recordrepo.totalExpenseFilterRecord(date1, date2, user, active);
		}catch(Exception e) {
		}		return expense;
	}



	@Override
	public Card savecard(Card card) {
		// TODO Auto-generated method stub
		return cardrepo.save(card);
	}



	@Override
	public List<Card> viewcards() {
		// TODO Auto-generated method stub
		return cardrepo.findAll();
	}



	@Override
	public String calculateincome(String payment, String username, int active) {
		payment="income";
		active=0;
		return recordrepo.calculateincome(payment, username, active);
	}



	@Override
	public String calculateincomecurrentmonth(String payment, String username, int active, int currentmonth) {
		payment="income";
		active=0;
		return recordrepo.calculateincomecurrentmonth(payment, username, active, currentmonth);
	}



	@Override
	public String totalexpense(String user, int active) {
		// TODO Auto-generated method stub
		return recordrepo.totalExpense(user, active);
	}



	@Override
	public String totalIncomeFilterRecords(String date1, String date2, String username, int active, String payment) {
	payment="income";
	active=0;
		return recordrepo.totalIncomeFilterRecord(date1, date2, username, active, payment);
	}



	@Override
	public Reminder savereminder(Reminder reminder) {
	
		return reminderrepo.saveAndFlush(reminder);
	}



	@Override
	public List<Reminder> viewremider() {
		// TODO Auto-generated method stub
		return reminderrepo.findAll();
	}



	@Override
	public void deletecard(Card card) {
		// TODO Auto-generated method stub
		 cardrepo.delete(card);
	}



	@Override
	public void monthlyexpense(MonthlyExpense monthlyexpense) {
		monthlyexpenserepo.save(monthlyexpense)	;
	}



	@Override
	public Reminder reminderbyid(Long id) {
		
		return reminderrepo.findByid(id);
	}



	@Override
	public void deletereminder(Long id) {
	// TODO Auto-generated method stub
		
		reminderrepo.deleteById(id);
		
	}






	@Override
	public int listsize(String user, int currentmonth) {
		// TODO Auto-generated method stub
		
		List<Logbook> list = recordrepo.findByUserAndActive(user, 0, currentmonth);
		int size = list.size();
		return size;
	}



	@Override
	public int filtersize(String date1, String date2,String user,Integer active) {
		List<Logbook> list = recordrepo.findByDateAndActive(date1, date2, user, active);
		int size = list.size();
		return size;
	}



	@Override
	public List<Reminder> getreminderobjects() {
		// TODO Auto-generated method stub
		return reminderrepo.getreminderobjects();
	}



	@Override
	public void getnotification() {
	
		List<Reminder> timelist=reminderrepo.getreminderobjects();
		String date1 = LocalDate.now().toString();
		int i=0;
		ModelAndView mv = new ModelAndView();
		for(Reminder reminder : timelist) {
			if(reminder.date.equals(date1) ) {
				
				System.out.println("IN " );
				List<String> name= new ArrayList<String>();
				name.add(reminder.name);
				mv.addObject("Notification", i=i+1);
				mv.addObject("bell", name);
			}else {
				
				mv.addObject("bell", "No New Reminders");
			}
			
		}
		
	}



	@Override
	public Logbook recordbyid(Long id) {
		// TODO Auto-generated method stub
		return recordrepo.findByid(id);
	}
	}






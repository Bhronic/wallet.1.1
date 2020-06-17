package com.example.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Admin;
import com.example.model.Card;
import com.example.model.Logbook;
import com.example.model.Reminder;
import com.example.service.AdminService;
import com.example.service.LogbookService;

@Controller
public class LogbookController{
	
	@Autowired 
	private LogbookService logbook;
	
	@Autowired
	private AdminService admin;
	

	@RequestMapping(value="/add")
	public ModelAndView add_page() {
		ModelAndView mv = new ModelAndView("add");
	
		//notification
		List<Reminder> timelist=logbook.getreminderobjects();
		String date1 = LocalDate.now().toString();
		int i=0;
		List<String> name= new ArrayList<String>();
		for(Reminder reminder : timelist) {
			
			if(reminder.date.equals(date1) ) {
				
				System.out.println("IN " );
				
				name.add(reminder.name);
				
				System.out.println(name);
				mv.addObject("Notification", i=i+1);
				mv.addObject("bell", name);
				
			}
			
		}
		return mv;
	}
	
	@RequestMapping(value="/addRecord")
	public ModelAndView get_record(HttpServletRequest request, HttpServletResponse response)
	{
		Logbook record = new Logbook();
		Admin log = new Admin();
		
		//Setting Parameters
		HttpSession session = request.getSession();
		String user=(String) session.getAttribute("username");
		String date = request.getParameter("date");
		String payment = request.getParameter("payment");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		System.out.print(user);
		
		
		//Saving the record of user	
		record.setDate(date);
		record.setPayment(payment);
		record.setAmount(amount);
		record.setDescription(description);
		record.setUser(user);
		
		logbook.saverecord(record);
		
		// Saving the activity of user 
		String dateandtime = admin.gettime();
		log.setUserName(user);
		log.setDateandtime(dateandtime);
		log.setActivity("ADD");
		admin.savelog(log);
		

		
		
		//Getting total expense
		int currentmonth = logbook.getCurrentmonth();
		String total=logbook.totalExpenseCrurrentMonth(user, record.getActive(), currentmonth);
		int page=1;
		ModelAndView mv = new ModelAndView("welcome");
		List<Logbook> recordlist = new ArrayList<Logbook>();
		recordlist=logbook.findByUserAndActive(user,record.getActive(),currentmonth,page);
		mv.addObject("get_records", recordlist);
		mv.addObject("login_message", user);
		mv.addObject("total_expense", total);
		mv.addObject("record_message","Record Saved Successfully...");
		
		
		
		//notification
		List<Reminder> timelist=logbook.getreminderobjects();
		String date1 = LocalDate.now().toString();
		int i=0;
		List<String> name= new ArrayList<String>();
		for(Reminder reminder : timelist) {
			
			if(reminder.date.equals(date1) ) {
				
				System.out.println("IN " );
				
				name.add(reminder.name);
				
				System.out.println(name);
				mv.addObject("Notification", i=i+1);
				mv.addObject("bell", name);
				
			}
			
		}
		
		return mv;
	}
	
	
	
		
		@RequestMapping(value="/recorduptodate")
		public ModelAndView get_update()
		{
		ModelAndView mv = new ModelAndView("update");
		return mv;
		}

	
	
			@Transactional
			@RequestMapping(value="method_update")
			public ModelAndView update_method(HttpServletRequest request, HttpServletResponse response){
			Logbook lg = new Logbook();
			Admin log= new Admin();
			String username=request.getParameter("username");
			
			//Update Record Method
			lg.setId(Long.parseLong(request.getParameter("id")));
			lg.setDate(request.getParameter("date"));
			lg.setAmount(request.getParameter("amount"));
			lg.setPayment(request.getParameter("payment"));
			lg.setDescription(request.getParameter("description"));
			lg.setUser(username);
			int currentmonth = logbook.getCurrentmonth();
			logbook.saverecord(lg);
			
			
			// Saving the activity of user 
			String dateandtime = admin.gettime();
			log.setUserName(lg.getUser());
			log.setDateandtime(dateandtime);
			log.setActivity("UPDATE");
			admin.savelog(log);
			
			//TotalExpense
			String expense=logbook.totalExpenseCrurrentMonth(username, lg.getActive(), currentmonth);
			List<Logbook> recordlist = new ArrayList<Logbook>();
			int page=1;
			recordlist=logbook.findByUserAndActive(lg.getUser(),lg.getActive(), currentmonth,page);
			
			ModelAndView mv=null;
			if(lg.getId()!=null)
			{
			 mv = new ModelAndView("welcome");
				mv.addObject("get_records", recordlist);
				mv.addObject("login_message",lg.getUser());
				mv.addObject("total_expense", expense);
			}else
			{
				mv= new ModelAndView("update");
				System.out.print("else");
			}
			
			//notification
			List<Reminder> timelist=logbook.getreminderobjects();
			String date1 = LocalDate.now().toString();
			int i=0;
			List<String> name= new ArrayList<String>();
			for(Reminder reminder : timelist) {
				
				if(reminder.date.equals(date1) ) {
					
					System.out.println("IN " );
					
					name.add(reminder.name);
					
					System.out.println(name);
					mv.addObject("Notification", i=i+1);
					mv.addObject("bell", name);
					
				}
				
			}
			
			
			return mv;
			}
			
			
			@RequestMapping(value="deleterecord")
			public ModelAndView delete_record(HttpServletRequest request , HttpServletResponse response) {
				Logbook lg = new Logbook();
				Admin log = new Admin();
				
				
			HttpSession session= request.getSession();
			String username= (String) session.getAttribute("username");
				lg.setId(Long.parseLong(request.getParameter("id")));
				lg.setDate(request.getParameter("date"));
				lg.setAmount(request.getParameter("amount"));
				lg.setPayment(request.getParameter("payment"));
				lg.setDescription(request.getParameter("description")); 
				lg.setUser(username); 
				
				
				//Setting delete flag
				lg.setActive(1);
				logbook.saverecord(lg);
				lg.setActive(0);
				
				
				
				// Saving the activity of user 
				String dateandtime = admin.gettime();
				log.setUserName(lg.getUser());
				log.setDateandtime(dateandtime);
				log.setActivity("DELETE");
				admin.savelog(log);
				
				
				//Getting total expense
				int currentmonth = logbook.getCurrentmonth();
				String total=logbook.totalExpenseCrurrentMonth(lg.getUser(), lg.getActive(), currentmonth);
				
				
				
				List<Logbook> recordlist = new ArrayList<Logbook>();
				int page=1;
				recordlist=logbook.findByUserAndActive(lg.getUser(),lg.getActive(),currentmonth,page);
				
				ModelAndView mv = new ModelAndView("welcome");
				mv.addObject("get_records", recordlist);
				mv.addObject("login_message", lg.getUser());
				mv.addObject("total_expense", total);
				
				//notification
				List<Reminder> timelist=logbook.getreminderobjects();
				String date1 = LocalDate.now().toString();
				int i=0;
				List<String> name= new ArrayList<String>();
				for(Reminder reminder : timelist) {
					
					if(reminder.date.equals(date1) ) {
						
						System.out.println("IN " );
						
						name.add(reminder.name);
						
						System.out.println(name);
						mv.addObject("Notification", i=i+1);
						mv.addObject("bell", name);
						
					}
					
				}
				
				return mv;
				
			}
			@RequestMapping(value="/filterrecords")
			public ModelAndView get_filter()
			{
				ModelAndView mv= new ModelAndView("filter");
				
				return mv;
			}
			
			@RequestMapping(value="/get_filter")
			public ModelAndView filter_records(@RequestParam String date1,@RequestParam String date2,Integer active,@RequestParam int page,HttpServletRequest request) {
				HttpSession session = request.getSession();
				String username = (String)session.getAttribute("username");
				Logbook lg = new Logbook();
				Admin log = new Admin();
				List<Logbook> recordlist= new ArrayList<Logbook>();
				lg.setActive(0);
				active=lg.getActive();
				String payment="income";
				recordlist= logbook.findByDateAndActive(date1, date2,username,active,page);
				
				
				//Filter Method
				
				String expense=logbook.totalExpenseFilterRecord(date1, date2, username, active);
				
				Double total1=Double.parseDouble(expense);
				
				String income=logbook.totalIncomeFilterRecords(date1, date2, username, active, payment);
				int size= logbook.filtersize(date1, date2, username, active);
				System.out.println("list size"+size);
				session.setAttribute("size", size);
				
				System.out.println("List size"+size);
				System.out.println("Total INcome filter record"+income);
				Double total2 = Double.parseDouble(income);
				Double totalexpense= total1-total2;
				ModelAndView mv = new ModelAndView("welcome");
				mv.addObject("get_records", recordlist);
				mv.addObject("login_message", username);
				mv.addObject("total_expense", totalexpense);
				mv.addObject("date1",date1);
				mv.addObject("date2", date2);
				
				
				// Saving the activity of user 
				String dateandtime = admin.gettime();
				log.setUserName(lg.getUser());
				log.setDateandtime(dateandtime);
				log.setActivity("FILTER");
				admin.savelog(log);
				
				
				
				//notification
				List<Reminder> timelist=logbook.getreminderobjects();
				String date10 = LocalDate.now().toString();
				int i=0;
				List<String> name= new ArrayList<String>();
				for(Reminder reminder : timelist) {
					
					if(reminder.date.equals(date10) ) {
						
						System.out.println("IN " );
						
						name.add(reminder.name);
						
						System.out.println(name);
						mv.addObject("Notification", i=i+1);
						mv.addObject("bell", name);
						
					}
					
				}
			
				
				return mv;
			}
			
			@RequestMapping("/savecard")
			public ModelAndView savecard(HttpServletResponse response ,HttpServletRequest request) {
				Card card = new Card();
				card.setName(request.getParameter("name"));
				card.setDebitcredit(request.getParameter("radio"));
				card.setExpiry(request.getParameter("expiry"));
				card.setMastervisa(request.getParameter("checkbox"));
				card.setCvv(request.getParameter("cvv"));
				card.setNumber(request.getParameter("number"));
				logbook.savecard(card);
				List<Card> cardlist = logbook.viewcards();
			
				ModelAndView mv = new ModelAndView("card");
				mv.addObject("cardlist", cardlist);
				
				//notification
				List<Reminder> timelist=logbook.getreminderobjects();
				String date1 = LocalDate.now().toString();
				int i=0;
				List<String> name= new ArrayList<String>();
				for(Reminder reminder : timelist) {
					
					if(reminder.date.equals(date1) ) {
						
						System.out.println("IN " );
						
						name.add(reminder.name);
						
						System.out.println(name);
						mv.addObject("Notification", i=i+1);
						mv.addObject("bell", name);
						
					}
					
				}
				
				
				return mv;
			}
			
			@RequestMapping("/savereminder")
			public ModelAndView savereminder(HttpServletRequest request, HttpServletResponse response) {
				Reminder reminder = new Reminder();
				String id = request.getParameter("id");
				System.out.print(id);
				if(id==null) {
				reminder.setName(request.getParameter("name"));
				reminder.setDate(request.getParameter("date"));
				reminder.setTime(request.getParameter("time"));
				reminder.setDescription(request.getParameter("description"));
				logbook.savereminder(reminder);}
				else {
				Long Id = Long.parseLong(request.getParameter("id"));
				reminder.setId(Id);
				reminder.setName(request.getParameter("name"));
				reminder.setDate(request.getParameter("date"));
				reminder.setTime(request.getParameter("time"));
				reminder.setDescription(request.getParameter("description"));
				logbook.savereminder(reminder);
				}
				
				List<Reminder> reminderlist=logbook.viewremider();
				
			
		
				ModelAndView mv = new ModelAndView("reminder");
				mv.addObject("reminder_list", reminderlist);
				mv.addObject("Heading", "Create A Reminder");
				
				//notification
				List<Reminder> timelist=logbook.getreminderobjects();
				String date1 = LocalDate.now().toString();
				int i=0;
				List<String> name= new ArrayList<String>();
				for(Reminder reminder1 : timelist) {
					
					if(reminder1.date.equals(date1) ) {
						
						System.out.println("IN " );
						
						name.add(reminder1.name);
						
						System.out.println(name);
						mv.addObject("Notification", i=i+1);
						mv.addObject("bell", name);
						
					}
					
				}
				
				
				return mv;
				
			}
			
			@RequestMapping("/deletecard")
			public ModelAndView deletecard(HttpServletRequest request,@RequestParam Long id) {
				
				Card card = new Card();
				card.setId(id);
				logbook.deletecard(card);
				List<Card> cardlist = logbook.viewcards();
				
				ModelAndView mv = new ModelAndView("card");
				mv.addObject("cardlist", cardlist);
				
				//notification
				List<Reminder> timelist=logbook.getreminderobjects();
				String date1 = LocalDate.now().toString();
				int i=0;
				List<String> name= new ArrayList<String>();
				for(Reminder reminder : timelist) {
					
					if(reminder.date.equals(date1) ) {
						
						System.out.println("IN " );
						
						name.add(reminder.name);
						
						System.out.println(name);
						mv.addObject("Notification", i=i+1);
						mv.addObject("bell", name);
						
					}
					
				}
				
				return mv;
			}
			@RequestMapping("/updatereminder")
			public ModelAndView updatecard(HttpServletRequest request , HttpServletResponse response) {
				
				Long id = Long.parseLong(request.getParameter("id"));
				Reminder reminder=logbook.reminderbyid(id);
				List<Reminder> reminders= logbook.viewremider();
				ModelAndView mv = new ModelAndView("reminder");
				mv.addObject("update_reminder", reminder);
				mv.addObject("reminder_list", reminders);
				mv.addObject("Heading", "Update Reminder");
				mv.addObject("id", id);
				
				//notification
				List<Reminder> timelist=logbook.getreminderobjects();
				String date1 = LocalDate.now().toString();
				int i=0;
				List<String> name= new ArrayList<String>();
				for(Reminder reminder1 : timelist) {
					
					if(reminder1.date.equals(date1) ) {
						
						System.out.println("IN " );
						
						name.add(reminder1.name);
						
						System.out.println(name);
						mv.addObject("Notification", i=i+1);
						mv.addObject("bell", name);
						
					}
					
				}
				
				return mv;
			}
			@RequestMapping("/deletereminder")
			public ModelAndView deletereminder(HttpServletRequest request) {
				
				Long id = Long.parseLong(request.getParameter("id"));
				logbook.deletereminder(id);
				List<Reminder> reminders= logbook.viewremider();
				ModelAndView mv = new ModelAndView("reminder");
				mv.addObject("reminder_list", reminders);
				mv.addObject("Heading", "Create A Reminder");
				
				
				//notification
				List<Reminder> timelist=logbook.getreminderobjects();
				String date1 = LocalDate.now().toString();
				int i=0;
				List<String> name= new ArrayList<String>();
				for(Reminder reminder : timelist) {
					
					if(reminder.date.equals(date1) ) {
						
						System.out.println("IN " );
						
						name.add(reminder.name);
						
						System.out.println(name);
						mv.addObject("Notification", i=i+1);
						mv.addObject("bell", name);
						
					}
					
				}
				
				return mv;
			}
}

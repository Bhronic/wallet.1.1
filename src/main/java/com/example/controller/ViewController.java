package com.example.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Card;
import com.example.model.Logbook;
import com.example.model.Reminder;
import com.example.service.LogbookService;

@Controller
public class ViewController {
	
	@Autowired 
	private LogbookService logbook;
	
	@RequestMapping("/home")
	public ModelAndView home_page(HttpServletRequest request , HttpServletResponse responese) {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		
		int currentmonth = logbook.getCurrentmonth();
		List<Logbook> recordlist = logbook.findByUserAndActive( username,0,currentmonth,1);
		int size= logbook.listsize(username, currentmonth);
		System.out.println("list size"+size);
		session.setAttribute("size", size);
		System.out.println("List size"+size);
		String expense = logbook.totalExpenseCrurrentMonth(username, 0, currentmonth);
		ModelAndView mv = new ModelAndView("welcome");
		
		
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
		
		
		mv.addObject("get_records", recordlist);
		mv.addObject("login_message", " "+username);
		mv.addObject("total_expense", expense);
		
	return mv;	
	}

	@RequestMapping("/pages")
	public ModelAndView get_pages(HttpServletRequest request,HttpServletResponse response)
	{
	
		Logbook lg = new Logbook();

		
		//Setting current month
		int currentmonth = logbook.getCurrentmonth();	

		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.print(page);
		System.out.print(username);
		String date1= request.getParameter("date1");
		String date2= request.getParameter("date2");
		System.out.println(date1);
		List<Logbook> recordlist = new ArrayList<Logbook>();
		
		if(date1.isEmpty() && date2.isEmpty()) {

			 recordlist = logbook.findByUserAndActive( username,lg.getActive(),currentmonth,page);

		}else {
			recordlist = logbook.findByDateAndActive(date1, date2, username, lg.getActive(), page);
		}
	
		System.out.print(recordlist);
		String expense = logbook.totalExpenseCrurrentMonth(username, lg.getActive(), currentmonth);
		session.setAttribute("expense",expense);
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("get_records", recordlist);
		mv.addObject("login_message", " "+username);
		mv.addObject("total_expense", expense);
		mv.addObject("date1",date1);
		mv.addObject("date2", date2);
		

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
	
	@RequestMapping("/cards")
	public ModelAndView get_cards()
	{
		ModelAndView mv = new ModelAndView("card");
		List<Card> cardlist = logbook.viewcards();
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
	
	@RequestMapping("/addcard")
	public ModelAndView addcard(){
		ModelAndView mv = new ModelAndView("addcard");
		return mv;
	}
	
	@RequestMapping("/balance")
	public ModelAndView get_balance(HttpServletRequest request) {
		Logbook lg = new Logbook();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		int currentmonth = logbook.getCurrentmonth();
		String totalexpenseincome = logbook.totalexpense(username, lg.getActive());
		double total1 = Double.parseDouble(totalexpenseincome);
		String payment="income";
		String totalincome= logbook.calculateincome(payment, username, lg.getActive());
	System.out.println("Total ExpenseIncome	"+total1);

	List<Logbook> recordlist = logbook.findByUserAndActive( username,lg.getActive(),currentmonth,1);
	
	String expense = logbook.totalExpenseCrurrentMonth(username, lg.getActive(), currentmonth);
		double total2=Double.parseDouble(totalincome);
		System.out.println("Total Income"+total2);
		Double totalexpense= total1-total2;
		System.out.println("Total Expense"+totalexpense);
		Double availablebalance = total2-totalexpense;
		System.out.print("Availble Blanace"+availablebalance);
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("get_records", recordlist);
		mv.addObject("login_message", " "+username);
		mv.addObject("total_expense", expense);
		mv.addObject("available_balance", " Current Balance is "+availablebalance);
		
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
	
	@RequestMapping("/reminders")
	public ModelAndView get_reminder() {
		
		List<Reminder> reminderlist=logbook.viewremider();
		System.out.println("Reminderlist"+reminderlist);
		
		ModelAndView mv = new ModelAndView("reminder");
		mv.addObject("reminder_list", reminderlist);
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

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Admin;
import com.example.model.Logbook;
import com.example.model.Reminder;
import com.example.model.User;
import com.example.service.AdminService;
import com.example.service.LogbookService;
import com.example.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService user;
	
	
	@Autowired 
	private LogbookService logbook;
	
	@Autowired
	private AdminService admin;
	

	
	

	@RequestMapping("/index")
	public @ResponseBody ModelAndView get_index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	@RequestMapping(value="/validate", method= RequestMethod.POST)
	public @ResponseBody ModelAndView get_validate(HttpServletRequest request,HttpServletResponse response) {
	
		ModelAndView mv = null;
		User us = new User();
		Logbook lg = new Logbook();
		Admin log = new Admin();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		//Setting current month
	int currentmonth = logbook.getCurrentmonth();	
		us =  user.findByUserNameAndPassword(username, password);
	
	
		
		if(username.equalsIgnoreCase("Admin")&&password.equalsIgnoreCase("1234"))
		{
			
			
			 mv = new ModelAndView("admin");
			 
			 
		}else if(us!=null) {
			
			List<Logbook> recordlist = logbook.findByUserAndActive( username,lg.getActive(),currentmonth,1);
			
			String expense = logbook.totalExpenseCrurrentMonth(username, lg.getActive(), currentmonth);
				
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			int size= logbook.listsize(username, currentmonth);
			System.out.println("list size"+size);
			
			//Notification / Alerts
		//	logbook.getnotification();
			
			
			session.setAttribute("size", size);
			mv = new ModelAndView("welcome");
			mv.addObject("get_records", recordlist);
			mv.addObject("login_message", " "+username);
			mv.addObject("total_expense", expense);
		
			
		//	 Saving the activity of user 
			
			String dateandtime = admin.gettime();
			log.setUserName(username);
			log.setDateandtime(dateandtime);
			log.setActivity("LOGIN");
			admin.savelog(log);
			
			
		}else {
			
			
			System.out.print("out");
			 mv = new ModelAndView("index");
			mv.addObject("error_message", "Username or password incorrect");
			
			
		}
		
		
		List<Reminder> timelist=logbook.getreminderobjects();
		String date1 = LocalDate.now().toString();
		int i=0;
		List<String> name= new ArrayList<String>();
		for(Reminder reminder : timelist) {
			
			if(reminder.date.equals(date1) ) {
				
				System.out.println("IN " );
				
				name.add(reminder.name);
				mv.addObject("Notification", i=i+1);
				mv.addObject("bell", name);
			}else {
				
				mv.addObject("bell", "No New Reminders");
			}
			
		}
		

		
		
	return mv;
	}
	
		@RequestMapping(value="/registration")
		public Object get_registrate(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView mv = new ModelAndView("registration");
			
			
			return mv;
		}
		
		@RequestMapping(value="/save", method= RequestMethod.POST)
		public Object get_save(HttpServletRequest request,HttpServletResponse response)
		{
			User userDtls = new User();
			String username= request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String profession = request.getParameter("profession");
			String question = request.getParameter("question");
			String answer = request.getParameter("answer");
			userDtls.setUserName(username);
			userDtls.setPassword(password);
			userDtls.setEmail(email);
			userDtls.setProfession(profession);
			userDtls.setQuestion(question);
			userDtls.setAnswer(answer);	
			user .saveuser(userDtls);
			
			// Saving the activity of user 
			Admin log = new Admin();
			String dateandtime = admin.gettime();
			log.setUserName(username);
			log.setDateandtime(dateandtime);
			log.setActivity("REGISTRATION");
			admin.savelog(log);
			
			
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("registration_message","Registration Successfull");
			return mv;
		}
		
		@RequestMapping(value="/logout")
		public ModelAndView get_logout(HttpServletRequest request) {
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("logout_message"," Logged Out Successfully ");
			
			// Saving the activity of user 
						Admin log = new Admin();
						String dateandtime = admin.gettime();
						log.setUserName(request.getParameter("username"));
						log.setDateandtime(dateandtime);
						log.setActivity("LOGOUT");
						admin.savelog(log);
						HttpSession session = request.getSession();
						session.invalidate();
			
			return mv;
		}
		
		
		@RequestMapping(value="/forgotpassword")
		public ModelAndView get_password()
		{
			ModelAndView mv = new ModelAndView("forgot");
			
			return mv;
		}
				
				
				
				
}
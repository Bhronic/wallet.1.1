package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Admin;
import com.example.model.Logbook;
import com.example.model.User;
import com.example.service.AdminService;

@Controller
public class AdminController {

	@Autowired
    private	AdminService service;
	
	@RequestMapping("/homepage")
	public ModelAndView home_page() {
		ModelAndView mv = new ModelAndView("admin");
		return mv;
	}
	
	@RequestMapping("/viewuser")
	public ModelAndView get_users() {
		List<User> userlist= new ArrayList<User>();
		userlist=service.viewUsers();
		
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("ul", userlist);
		return mv;
	}
	
	@RequestMapping("/viewall")
	public ModelAndView get_records() {
		List<Logbook> recordlist = new ArrayList<Logbook>();
		recordlist = service.viewRecords();
		List<User> userlist= new ArrayList<User>();
		userlist=service.viewUsers();
		
	
	
		ModelAndView mv = new ModelAndView("record");
		mv.addObject("recordlist", recordlist);
		mv.addObject("ul", userlist);
		return mv;
	}
	
	@RequestMapping("/viewlogs")
	public ModelAndView get_logs() {
		List<Admin> loglist =  new ArrayList<Admin>();
		loglist = service.viewlogs();
		List<User> userlist= new ArrayList<User>();
		userlist=service.viewUsers();
		
		ModelAndView mv = new ModelAndView("log");
		mv.addObject("loglist", loglist);
		mv.addObject("ul", userlist);
		return mv;
	}
	
	@RequestMapping("/selectuser")
	public ModelAndView get_user(HttpServletRequest request , HttpServletResponse response)
	{
		String user = request.getParameter("user");
		List<Logbook> recordlist = new ArrayList<Logbook>();
		recordlist=service.findByUser(user);

		List<User> userlist= new ArrayList<User>();
		userlist=service.viewUsers();
		ModelAndView mv = new ModelAndView("record");
			mv.addObject("recordlist",recordlist);
			mv.addObject("ul", userlist);
		return mv;
	}
	
	
	@RequestMapping("/selectlog")
	public ModelAndView get_log(HttpServletRequest request , HttpServletResponse response) {
		
		String user = request.getParameter("user");
		List<Admin> loglist= new ArrayList<Admin>();
		loglist=service.findByuserName(user);
		System.out.print(user);
		List<User> userlist= new ArrayList<User>();
		userlist=service.viewUsers();
		ModelAndView mv = new ModelAndView("log");
			mv.addObject("ul", userlist);
			mv.addObject("loglist", loglist);
			return mv;
	}
	

}

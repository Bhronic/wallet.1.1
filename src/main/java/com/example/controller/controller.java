package com.example.controller;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.model.logbook;
import com.example.service.service;


@Controller
public class controller {
	
	@Autowired
	private service user;
	@Autowired 
	private service logbook;

	@RequestMapping("/index")
	public @ResponseBody ModelAndView get_index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	@RequestMapping(value="/validate", method= RequestMethod.POST)
	public @ResponseBody ModelAndView get_validate(@RequestParam String username, @RequestParam String password) {
		
		ModelAndView mv = null;
		User us = new User();
		us =  user.findByUserNameAndPassword(username, password);
	
		
		if(us!=null) {
			List<logbook> recordlist = new ArrayList<logbook>();
			recordlist=logbook.getrecordlist();
			mv = new ModelAndView("welcome");
			mv.addObject("get_records", recordlist);
			mv.addObject("login_message", "Welcome"+username);
			
			System.out.print(recordlist);
			System.out.print("in");
		}else {
			System.out.print("out");
			 mv = new ModelAndView("index");
			mv.addObject("error_message", "Username or password incorrect");
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
			userDtls.setUserName(username);
			userDtls.setPassword(password);
			userDtls.setEmail(email);
			userDtls.setProfession(profession);
			
			
			user .saveuser(userDtls);
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("registration_message","Registration Successfull");
			return mv;
		}
		
		@RequestMapping(value="/add")
		public ModelAndView add_page() {
			ModelAndView mv = new ModelAndView("add");
			return mv;
		}
		
		@RequestMapping(value="/addRecord")
		public ModelAndView get_record(HttpServletRequest request, HttpServletResponse response)
		{
			String date = request.getParameter("date");
			String payment = request.getParameter("payment");
			String amount = request.getParameter("amount");
			String description = request.getParameter("description");
			logbook record = new logbook();
			record.setDate(date);
			record.setPayment(payment);
			record.setAmount(amount);
			record.setDescription(description);
			
			logbook.saverecord(record);
			
			ModelAndView mv = new ModelAndView("welcome");
			mv.addObject("record_message","Record Saved Successfully...");
			return mv;
		}
}
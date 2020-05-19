package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Logbook;
import com.example.model.User;
import com.example.service.AdminService;

@Controller
public class AdminController {

	@Autowired
    private	AdminService service;
	
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
	
		ModelAndView mv = new ModelAndView("record");
		mv.addObject("recordlist", recordlist);
		return mv;
	}
	
	
}

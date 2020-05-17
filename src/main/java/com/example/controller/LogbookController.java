package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Logbook;
import com.example.service.LogbookService;

@Controller
public class LogbookController{
	
	@Autowired 
	private LogbookService logbook;
	

	@RequestMapping(value="/add")
	public ModelAndView add_page() {
		ModelAndView mv = new ModelAndView("add");
		return mv;
	}
	
	@RequestMapping(value="/addRecord")
	public ModelAndView get_record(HttpServletRequest request, HttpServletResponse response)
	{
		String user=request.getParameter("username");
		String date = request.getParameter("date");
		String payment = request.getParameter("payment");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		System.out.print(user);
		Logbook record = new Logbook();
		record.setDate(date);
		record.setPayment(payment);
		record.setAmount(amount);
		record.setDescription(description);
		record.setUser(user);
		
		logbook.saverecord(record);
		
		ModelAndView mv = new ModelAndView("welcome");
		List<Logbook> recordlist = new ArrayList<Logbook>();
		recordlist=logbook.findByUser(user);
		mv.addObject("get_records", recordlist);
		mv.addObject("login_message", "Welcome "+user);
		
		mv.addObject("record_message","Record Saved Successfully...");
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
			
			lg.setId(Long.parseLong(request.getParameter("id")));
			lg.setDate(request.getParameter("date"));
			lg.setAmount(request.getParameter("amount"));
			lg.setPayment(request.getParameter("payment"));
			lg.setDescription(request.getParameter("description"));
			lg.setUser(request.getParameter("username"));
			
			logbook.saverecord(lg);
			List<Logbook> recordlist = new ArrayList<Logbook>();
			recordlist=logbook.findByUser(lg.getUser());
			
			ModelAndView mv=null;
			if(lg.getId()!=null)
			{
			 mv = new ModelAndView("welcome");
				mv.addObject("get_records", recordlist);
				mv.addObject("login_message", "Welcome "+lg.getUser());
			}else
			{
				mv= new ModelAndView("update");
				System.out.print("else");
			}
			
			return mv;
			}
			
			
			@RequestMapping(value="deleterecord")
			public ModelAndView delete_record(HttpServletRequest request , HttpServletResponse response) {
				Logbook lg = new Logbook();
				
				lg.setId(Long.parseLong(request.getParameter("id")));
				lg.setDate(request.getParameter("date"));
				lg.setAmount(request.getParameter("amount"));
				lg.setPayment(request.getParameter("payment"));
				lg.setDescription(request.getParameter("description"));
				lg.setUser(request.getParameter("username"));
				
				logbook.deleterecord(lg);
				List<Logbook> recordlist = new ArrayList<Logbook>();
				recordlist=logbook.findByUser(lg.getUser());
				
				ModelAndView mv = new ModelAndView("welcome");
				mv.addObject("get_records", recordlist);
				mv.addObject("login_message", "Welcome "+lg.getUser());
				return mv;
				
			}
			
}
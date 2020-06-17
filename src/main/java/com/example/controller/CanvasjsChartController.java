package com.example.controller;


 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Logbook;
import com.example.model.Reminder;
import com.example.service.CanvasjsChartService;
import com.example.service.LogbookService;

 
@Controller
@RequestMapping("/report")
public class CanvasjsChartController {
 
	@Autowired
	private CanvasjsChartService canvasjsChartService;
	
	@Autowired 
	private LogbookService logbook;
 
	@RequestMapping(method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap,HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
		String user=(String) session.getAttribute("username");
		int active=0;
		int page=1;
		int currentmonth=logbook.getCurrentmonth();
		String payment = "income";
		int month=currentmonth;
		try {
			month=Integer.parseInt(request.getParameter("month"));
			page=Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) {}
		
		int size= logbook.listsize(user, month);
		session.setAttribute("size", size);
		System.out.println("List size"+size);
		
		List<Logbook> recordlist = logbook.findByUserAndActive(user, active, month, page); 
	
		String	 may=logbook.totalExpenseFilterRecord("2020-05-01","2020-05-31" ,user,0);
		System.out.print(may);
		String   mayincome=logbook.totalIncomeFilterRecords("2020-05-01","2020-05-31", user, 0, payment);
		Double mayagain = Double.parseDouble(may);
		Double mayincomeagain = Double.parseDouble(mayincome);
		Double mayfinal = mayagain-mayincomeagain;
		may= mayfinal.toString();
		System.out.println("May"+may);
		
		
		String	 june=logbook.totalExpenseFilterRecord("2020-06-01","2020-06-30O" ,user,0);
		
		String   juneincome=logbook.totalIncomeFilterRecords("2020-06-01", "2020-06-30", user, 0, payment);
		try {
		Double juneagain = Double.parseDouble(june);
		Double juneincomeagain = Double.parseDouble(juneincome);
		Double junefinal = juneagain-juneincomeagain;
		june= junefinal.toString();}catch(Exception e) {}
		System.out.println("June"+june);
		System.out.println("June"+juneincome);
		
		
		String	 july=logbook.totalExpenseFilterRecord("2020-07-01","2020-07-31" ,user,0);
		String   julyincome=logbook.totalIncomeFilterRecords("2020-06-01","2020-06-31", user, 0, payment);
		try {
		Double julyagain = Double.parseDouble(july);
		Double julyincomeagain = Double.parseDouble(julyincome);
		Double julyfinal = julyagain-julyincomeagain;
		july= julyfinal.toString();
		}catch(Exception e) {}
		System.out.println("july"+july);
		
		String	 august=logbook.totalExpenseFilterRecord("2020-07-01","2020-07-31" ,user,0);
		String   augustincome=logbook.totalIncomeFilterRecords("2020-07-01","2020-07-31", user, 0, "income");
		try {
		Double augustagain = Double.parseDouble(august);
		Double augustincomeagain = Double.parseDouble(augustincome);
		Double augustfinal = augustagain-augustincomeagain;
		august= augustfinal.toString();
		}catch(Exception e) {}
		System.out.println("August"+august);

		
		List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData(may,june,july,august);
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
	
		

	
		String tecm1 = logbook.totalExpenseCrurrentMonth(user, active, currentmonth);
		System.out.println("currentmonth"+currentmonth+" "+tecm1);
		currentmonth=currentmonth-1;
		String tecm = logbook.totalExpenseCrurrentMonth(user, active, currentmonth);
		System.out.println("lastmonth"+currentmonth+" "+tecm);
		Double tecmddouble1 = Double.parseDouble(tecm1);
		Double tecmddouble = Double.parseDouble(tecm);
		Double difference=tecmddouble1-tecmddouble;
		System.out.println(" Diffenrec"+difference);
		Double add=tecmddouble1+tecmddouble;
		int differncepercentage=(int) ((difference/add)*100);
		System.out.print("differncepercentage"+differncepercentage);
		String message="";
		if(differncepercentage<0) {
			 message=("Your Expense Was DOWN By "+Math.abs(differncepercentage)+"%");
		}else {
			 message=("Your Expense Was UP By "+Math.abs(differncepercentage)+"%");
		}
		
		modelMap.addAttribute("message", message);
		modelMap.addAttribute("total_expense_lastmonth", tecm);
		modelMap.addAttribute("total_expense_currentmonth", tecm1);
		modelMap.addAttribute("record_list",recordlist);
		modelMap.addAttribute("month",month);
		
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
				modelMap.addAttribute("Notification", i=i+1);
				modelMap.addAttribute("bell", name);
				
			}
			
		}
		
		
		return "report";
	}
 
}                        

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
		int month=0;
		try {
			month=Integer.parseInt(request.getParameter("month"));
			page=Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) {}
		
		int size= logbook.listsize(user, month);
		session.setAttribute("size", size);
		System.out.println("List size"+size);
		
		List<Logbook> recordlist = logbook.findByUserAndActive(user, active, month, page); 
	
		String	 jan=logbook.totalExpenseFilterRecord("2020-01-01","2020-01-31" ,user,0);
		String   janincome=logbook.totalIncomeFilterRecords("2020-01-01","2020-01-31", user, 0, payment);
		try {
		Double janagain = Double.parseDouble(jan);
		Double janincomeagain = Double.parseDouble(janincome);
		Double janfinal = janagain-janincomeagain;
		jan= janfinal.toString();
		}catch(Exception e) {}
		System.out.println("jan"+jan);
		
		String	 feb=logbook.totalExpenseFilterRecord("2020-02-01","2020-02-29" ,user,0);
		String   febincome=logbook.totalIncomeFilterRecords("2020-02-01","2020-02-29", user, 0, payment);
		try {
		Double febagain = Double.parseDouble(feb);
		Double febincomeagain = Double.parseDouble(febincome);
		Double febfinal = febagain-febincomeagain;
		feb= febfinal.toString();
		}catch(Exception e) {}
		System.out.println("feb"+feb);
		
		String	 march=logbook.totalExpenseFilterRecord("2020-03-01","2020-03-31" ,user,0);
		String   marchincome=logbook.totalIncomeFilterRecords("2020-03-01","2020-03-31", user, 0, payment);
		try {
		Double marchagain = Double.parseDouble(march);
		Double marchincomeagain = Double.parseDouble(marchincome);
		Double marchfinal = marchagain-marchincomeagain;
		march= marchfinal.toString();
		}catch(Exception e) {}
		System.out.println("march"+march);
		
		String	 april=logbook.totalExpenseFilterRecord("2020-04-01","2020-04-30" ,user,0);
		String   aprilincome=logbook.totalIncomeFilterRecords("2020-04-01","2020-04-30", user, 0, payment);
		try {
		Double aprilagain = Double.parseDouble(april);
		Double aprilincomeagain = Double.parseDouble(aprilincome);
		Double aprilfinal = aprilagain-aprilincomeagain;
		april= aprilfinal.toString();
		}catch(Exception e) {}
		System.out.println("april"+april);
		
		
		
		
		String	 may=logbook.totalExpenseFilterRecord("2020-05-01","2020-05-31" ,user,0);
		System.out.print(may);
		String   mayincome=logbook.totalIncomeFilterRecords("2020-05-01","2020-05-31", user, 0, payment);
		try {
		Double mayagain = Double.parseDouble(may);
		Double mayincomeagain = Double.parseDouble(mayincome);
		Double mayfinal = mayagain-mayincomeagain;
		may= mayfinal.toString();}catch(Exception e) {}
		System.out.println("May"+may);
		
		
		String	 june=logbook.totalExpenseFilterRecord("2020-06-01","2020-06-30" ,user,0);
		
		String   juneincome=logbook.totalIncomeFilterRecords("2020-06-01", "2020-06-30", user, 0, payment);
		try {
		Double juneagain = Double.parseDouble(june);
		Double juneincomeagain = Double.parseDouble(juneincome);
		Double junefinal = juneagain-juneincomeagain;
		june= junefinal.toString();}catch(Exception e) {}
		System.out.println("June"+june);
		System.out.println("June"+juneincome);
		
		
		String	 july=logbook.totalExpenseFilterRecord("2020-07-01","2020-07-31" ,user,0);
		String   julyincome=logbook.totalIncomeFilterRecords("2020-07-01","2020-07-31", user, 0, payment);
		
		try {
		Double julyagain = Double.parseDouble(july);
		Double julyincomeagain = Double.parseDouble(julyincome);
		Double julyfinal = julyagain-julyincomeagain;
		july= julyfinal.toString();
		}catch(Exception e) {}
		System.out.println("july"+july);
		
		
		String	 august=logbook.totalExpenseFilterRecord("2020-08-01","2020-08-31" ,user,0);
		String   augustincome=logbook.totalIncomeFilterRecords("2020-08-01","2020-08-31", user, 0, "income");
		try {
		Double augustagain = Double.parseDouble(august);
		Double augustincomeagain = Double.parseDouble(augustincome);
		Double augustfinal = augustagain-augustincomeagain;
		august= augustfinal.toString();
		}catch(Exception e) {}
		System.out.println("August"+august);
		
		
		String	 sept=logbook.totalExpenseFilterRecord("2020-09-01","2020-09-30" ,user,0);
		String   septincome=logbook.totalIncomeFilterRecords("2020-09-01","2020-09-30", user, 0, "income");
		try {
		Double septagain = Double.parseDouble(sept);
		Double septincomeagain = Double.parseDouble(septincome);
		Double septfinal = septagain-septincomeagain;
		august= septfinal.toString();
		}catch(Exception e) {}
		System.out.println("Sept"+sept);
		
		
		String	 oct=logbook.totalExpenseFilterRecord("2020-10-01","2020-10-31" ,user,0);
		String   octincome=logbook.totalIncomeFilterRecords("2020-10-01","2020-10-31", user, 0, "income");
		try {
		Double octagain = Double.parseDouble(oct);
		Double octincomeagain = Double.parseDouble(octincome);
		Double octfinal = octagain-octincomeagain;
		oct= octfinal.toString();
		}catch(Exception e) {}
		System.out.println("oct"+oct);
		
		String	 nov=logbook.totalExpenseFilterRecord("2020-11-01","2020-11-30" ,user,0);
		String   novincome=logbook.totalIncomeFilterRecords("2020-11-01","2020-11-30", user, 0, "income");
		try {
		Double novagain = Double.parseDouble(nov);
		Double novincomeagain = Double.parseDouble(novincome);
		Double novfinal = novagain-novincomeagain;
		nov= novfinal.toString();
		}catch(Exception e) {}
		System.out.println("nov"+nov);
		
		String	 dec=logbook.totalExpenseFilterRecord("2020-12-01","2020-12-31" ,user,0);
		String   decincome=logbook.totalIncomeFilterRecords("2020-12-01","2020-12-31", user, 0, "income");
		try {
		Double decagain = Double.parseDouble(dec);
		Double decincomeagain = Double.parseDouble(decincome);
		Double decfinal = decagain-decincomeagain;
		dec= decfinal.toString();
		}catch(Exception e) {}
		System.out.println("dec"+dec);

		
			switch(month) {
			case 1:
				List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData(jan,"0","0","0","0","0","0","0","0","0","0","0");
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
				break;
			case 2:
			 canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0",feb,"0","0","0","0","0","0","0","0","0","0");
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
				break;
			case 3:
			canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0","0",march,"0","0","0","0","0","0","0","0","0");
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
				break;
			case 4:
			canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0","0","0",april,"0","0","0","0","0","0","0","0");
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
				break;
			case 5:
			canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0","0","0","0",may,"0","0","0","0","0","0","0");
				 modelMap.addAttribute("dataPointsList", canvasjsDataList);
				break;
			case 6:
			canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0","0","0","0","0",june,"0","0","0","0","0","0");
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
				break;
			case 7:
			canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0","0","0","0","0","0",july,"0","0","0","0","0");
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
					break;
			case 8:
			canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0","0","0","0","0","0","0",august,"0","0","0","0");
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
					break;
			case 9:
			canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0","0","0","0","0","0","0","0",sept,"0","0","0");
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
					break;
			case 10:
			canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0","0","0","0","0","0","0","0","0",oct,"0","0");
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
					break;
			case 11:
			canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0","0","0","0","0","0","0","0","0","0",nov,"0");
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
					break;
			case 12:
			canvasjsDataList = canvasjsChartService.getCanvasjsChartData("0","0","0","0","0","0","0","0","0","0","0",dec);
				modelMap.addAttribute("dataPointsList", canvasjsDataList);
					break;
				default:
					canvasjsDataList = canvasjsChartService.getCanvasjsChartData(jan,feb,march,april,may,june,july,august,sept,oct,nov,dec);
					modelMap.addAttribute("dataPointsList", canvasjsDataList);
					break;
			
			}	
	
		
		

	
		String tecm1 = logbook.totalExpenseCrurrentMonth(user, active, currentmonth);
		System.out.println("currentmonth"+currentmonth+" "+tecm1);
		int lastmonth=currentmonth-1;
		String tecm = logbook.totalExpenseCrurrentMonth(user, active, lastmonth);
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

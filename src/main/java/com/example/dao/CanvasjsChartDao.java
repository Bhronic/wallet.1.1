package com.example.dao;
import java.util.List;
import java.util.Map;

public interface CanvasjsChartDao {
	 
	List<List<Map<Object, Object>>> getCanvasjsChartData(String jan ,String feb,String march,String april,String may,String June ,String July,String August,String Sept,String Oct,String Nov ,String Dec);
	
	public void adddatapoints();
 
}
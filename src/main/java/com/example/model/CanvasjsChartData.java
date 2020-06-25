package com.example.model;
 
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CanvasjsChartData {





	 Map<Object,Object> map = null;
	 List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
	 List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
	

	
	
		
	public List<List<Map<Object, Object>>> getCanvasjsDataList(String jan ,String feb,String march,String april,String may,String June ,String July,String August,String Sept,String Oct,String Nov ,String Dec) {
		
	
		map = new HashMap<Object,Object>(); map.put("label", "Jan"); map.put("y", jan);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Feb"); map.put("y", feb);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Mar"); map.put("y", march);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "April"); map.put("y", april);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "May"); map.put("y", may);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "June"); map.put("y", June);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "July"); map.put("y", July);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "August"); map.put("y", August);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Sept"); map.put("y", Sept);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Oct"); map.put("y", Oct);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Nov"); map.put("y",Nov);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Dec"); map.put("y",Dec);dataPoints1.add(map);
 
		list.add(dataPoints1);
		return list;
	}
}
                       
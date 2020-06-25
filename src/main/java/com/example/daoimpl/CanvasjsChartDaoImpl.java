package com.example.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CanvasjsChartDao;
import com.example.model.CanvasjsChartData;

@Repository
@Transactional
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {


	
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData(String jan ,String feb,String march,String april,String may,String June ,String July,String August,String Sept,String Oct,String Nov ,String Dec) {
		
		CanvasjsChartData data = new CanvasjsChartData();
		
		List<List<Map<Object, Object>>> datalist=	data.getCanvasjsDataList( jan , feb, march, april, may, June , July, August, Sept, Oct, Nov , Dec);
			
		return datalist;
	}

	@Override
	public void adddatapoints() {
	
		
		
	}
}

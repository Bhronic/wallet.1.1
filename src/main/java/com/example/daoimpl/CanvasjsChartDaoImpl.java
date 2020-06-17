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
	public List<List<Map<Object, Object>>> getCanvasjsChartData(String may,String June ,String July,String August) {
		CanvasjsChartData data = new CanvasjsChartData();
		
;		List<List<Map<Object, Object>>> datalist=	data.getCanvasjsDataList(may,June,July,August);
		return datalist;
	}

	@Override
	public void adddatapoints() {
	
		
		
	}
}

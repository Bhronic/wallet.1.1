package com.example.serviceimpl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CanvasjsChartDao;
import com.example.service.CanvasjsChartService;


@Repository
@Transactional
public class CanvasjsChartServiceImpl implements CanvasjsChartService {
	 
	@Autowired
	private CanvasjsChartDao canvasjsChartDao;
 
	public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
		this.canvasjsChartDao = canvasjsChartDao;
	}
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData(String May,String June ,String July,String August) {
		return canvasjsChartDao.getCanvasjsChartData(May,June,July,August);
	}
 
}                        
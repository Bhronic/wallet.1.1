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
	public List<List<Map<Object, Object>>> getCanvasjsChartData(String jan ,String feb,String march,String april,String may,String June ,String July,String August,String Sept,String Oct,String Nov ,String Dec) {
		return canvasjsChartDao.getCanvasjsChartData(jan,feb,march,april,may,June,July,August,Sept,Oct,Nov,Dec);
	}
 
}                        
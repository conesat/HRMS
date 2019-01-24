package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.PerformanceDao;
import com.nncq.sunmoon.entity.Performance;
import com.nncq.sunmoon.service.PerformanceService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Transactional
@Service
public class PerformanceServiceImpl implements PerformanceService {
	
	@Autowired
	private PerformanceDao performanceDao;

	 
	public void addPerformance(Performance performance) throws RuntimeException{
		performanceDao.addPerformance(performance);
	}

	 
	public List<Performance> getPerformanceBySe(SelectEntity selectEntity) {
		List<Performance> re=null;
		try {
			re=performanceDao.getPerformanceBySe(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public int getPerformanceNumberBySe(SelectEntity selectEntity) {
		int re=0;
		try {
			re=performanceDao.getPerformanceNumberBySe(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<Performance> getStaffPerformanceBySe(SelectEntity selectEntity) {
		List<Performance> re=null;
		try {
			re=performanceDao.getStaffPerformanceBySe(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public int getStaffPerformanceNumberBySe(SelectEntity selectEntity) {
		int re=0;
		try {
			re=performanceDao.getStaffPerformanceNumberBySe(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void updateStaffPerformance(Performance performance) throws RuntimeException{
		performanceDao.updateStaffPerformance(performance);
	}

	 
	public Performance getStaffPerformanceByPerformance(Performance performance) {
		Performance re=null;
		try {
			re=performanceDao.getStaffPerformanceByPerformance(performance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}

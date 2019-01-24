package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.SalaryDao;
import com.nncq.sunmoon.entity.MyPay;
import com.nncq.sunmoon.entity.StaffPay;
import com.nncq.sunmoon.service.SalaryService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Transactional
@Service
public class SalaryServiceImpl implements SalaryService {
	
	@Autowired
	private SalaryDao salaryDao;

	 
	public void addSalary(MyPay myPay) throws RuntimeException{
		salaryDao.addSalary(myPay);
	}

	 
	public MyPay getMyPayByMyPay(MyPay myPay) {
		MyPay re=null;
		try {
			re=salaryDao.getMyPayByMyPay(myPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void updateSalary(MyPay myPay) throws RuntimeException{
		salaryDao.updateSalary(myPay);
	}

	 
	public List<StaffPay> getStaffPayBySe(SelectEntity selectEntity) {
		List<StaffPay> re=null;
		try {
			re=salaryDao.getStaffPayBySe(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public int getStaffPayNumberBySe(SelectEntity selectEntity) {
		int re=0;
		try {
			re=salaryDao.getStaffPayNumberBySe(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<StaffPay> getNowStaffPayBySe(SelectEntity selectEntity) {
		List<StaffPay> re=null;
		try {
			re=salaryDao.getNowStaffPayBySe(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public int getNowStaffPayNumberBySe(SelectEntity selectEntity) {
		int re=0;
		try {
			re=salaryDao.getNowStaffPayNumberBySe(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void payBeforMonth(String payTime) throws RuntimeException{
		salaryDao.payBeforMonth(payTime);
	}

}
